package com.example.demo.serviceImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class AysnFileUpload {

	@Value("${file.path}")
	private String folderPath;

	public static int wordCount;

	public void asynUpload(MultipartFile file) throws IOException {
		String filePaths = folderPath + "\\" + file.getOriginalFilename();

		Path path = Paths.get(filePaths);
		byte[] data = Files.readAllBytes(path);
		String content = new String(data);
		String[] words = content.split("\\s+");
		wordCount = words.length;
		System.out.println(wordCount);

	}

	public int wordCount() {
		return wordCount;

	}

}
