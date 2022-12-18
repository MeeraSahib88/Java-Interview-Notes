package com.example.demo.service;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadingServices {

	ResponseEntity<?> fileUpload(MultipartFile file)throws IOException;

	ResponseEntity<?> count();

}
