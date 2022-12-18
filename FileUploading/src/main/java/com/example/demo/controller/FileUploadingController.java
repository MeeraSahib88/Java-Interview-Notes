package com.example.demo.controller;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.FileUploadingServices;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/api/file/upload")
public class FileUploadingController {

	@Autowired
	FileUploadingServices fileUploadingServices;

	@PostMapping("/filepath")
	public ResponseEntity<?> filePath(@RequestParam(name = "file") MultipartFile file)throws IOException {
			return fileUploadingServices.fileUpload(file);
	}
	
	@GetMapping("/count/word")@ Retry(name = "meerasahib")
	public ResponseEntity<?> countWord(){
		return fileUploadingServices.count();
		
	}

}
