package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entities.AllFileSystem;
import com.example.demo.message.ResponseMessage;
import com.example.demo.message.SystemResponse;
import com.example.demo.services.serviceImplementation.AllFilesServiceImplementation;

@RestController
@RequestMapping("/files/")
public class AllFilesSystemController {

	@Autowired
	private AllFilesServiceImplementation allFilesServiceImplementation;
	
	@PostMapping()
	public ResponseEntity<ResponseMessage> uploading(@RequestParam("file")MultipartFile file){
		String message="";
		try {
			allFilesServiceImplementation.upload(file);
			message= "file uploaded successfully" + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			message="Sorry,could not upload file" + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}
	
	@GetMapping("/downloadfile")
	public ResponseEntity<List<SystemResponse>> getAll(){
		List<SystemResponse> files = allFilesServiceImplementation.getAllFiles().map(file-> {
			String uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadfile/").path(file.getId()).toUriString();
			
			return new SystemResponse(file.getName(), uri, file.getType(),file.getData().length);
		}).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(files);
		
	}
	
	@GetMapping("/downloadfile/{id}")
	public ResponseEntity<byte[]> getAllData(@PathVariable String id){
		AllFileSystem allFileSystem = allFilesServiceImplementation.getFile(id);
		 
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + allFileSystem.getName() + "\"")
				.body(allFileSystem.getData());
	}
	
	
	
}

