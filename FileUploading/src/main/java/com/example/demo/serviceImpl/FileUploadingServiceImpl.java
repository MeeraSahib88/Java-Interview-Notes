package com.example.demo.serviceImpl;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.FileUploadingServices;

@Service
public class FileUploadingServiceImpl implements FileUploadingServices {

	@Autowired
	AysnFileUpload aysnFileUpload;

	@Override
	public ResponseEntity<?> fileUpload(MultipartFile file) throws IOException {

		file.transferTo(new File("C:\\File\\" + file.getOriginalFilename()));
		aysnFileUpload.asynUpload(file);
		return ResponseEntity.ok(HttpStatus.OK.value());

	}

	@Override
	public ResponseEntity<?> count() {
		int word =aysnFileUpload.wordCount();
		return ResponseEntity.ok(word);
	}

}
