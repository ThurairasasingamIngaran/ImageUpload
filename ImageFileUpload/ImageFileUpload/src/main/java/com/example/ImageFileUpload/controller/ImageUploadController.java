package com.example.ImageFileUpload.controller;


import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.ImageFileUpload.entities.ImageUploadEntity;
import com.example.ImageFileUpload.service.ImageUploadService;

@RestController
public class ImageUploadController {
	
	@Autowired
	ImageUploadService imageUploadService;
	
	@PostMapping("/image")
	public String uploadImage(@RequestParam("file") MultipartFile file) {
		try {
			imageUploadService.uploadImage(file);
		} catch(IOException e) {
			return "error";
		}
		return "Upload Image Successfully";
	}

	@GetMapping("/{id}")
	public ResponseEntity<byte[]> getImageById(@PathVariable Long id){
		Optional<ImageUploadEntity> optionalImage = imageUploadService.getImageById(id);
		if(optionalImage.isPresent()) {
			ImageUploadEntity imageUploadEnitity=optionalImage.get();
			return ResponseEntity.ok()
					.contentType(MediaType.IMAGE_JPEG)
					.body(imageUploadEnitity.getImage());
			} else {
				return ResponseEntity.notFound().build();
			}
		}

}
