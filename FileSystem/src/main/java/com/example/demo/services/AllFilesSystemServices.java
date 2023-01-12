package com.example.demo.services;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.AllFileSystem;

public interface AllFilesSystemServices {


	public AllFileSystem upload(MultipartFile file) throws IOException;
	
	public Stream<AllFileSystem> getAllFiles();
	
	
}
