package com.example.demo.services.serviceImplementation;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.AllFileSystem;
import com.example.demo.repository.AllFilesSystemRepository;
import com.example.demo.services.AllFilesSystemServices;

@Service
public class AllFilesServiceImplementation implements AllFilesSystemServices {

	@Autowired
	private AllFilesSystemRepository allFilesSystemRepository;

	@Override
	public AllFileSystem upload(MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		AllFileSystem allFileSystem = new AllFileSystem(fileName, file.getContentType(), file.getContentType(),
				file.getBytes());
		return allFilesSystemRepository.save(allFileSystem);
	}

	@Override
	public Stream<AllFileSystem> getAllFiles() {
		return allFilesSystemRepository.findAll().stream();
	}
	
	public AllFileSystem getFile(String id) {
		return allFilesSystemRepository.findById(id).get();
	}
	
	

}

//
//public FileSystem getFile(String id) {
//	return repo.findById(id).get();
//}