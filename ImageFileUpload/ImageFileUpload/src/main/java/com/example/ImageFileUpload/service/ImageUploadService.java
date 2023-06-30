package com.example.ImageFileUpload.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.example.ImageFileUpload.entities.ImageUploadEntity;

public interface ImageUploadService {
	public void uploadImage(MultipartFile file) throws IOException;

	public Optional<ImageUploadEntity> getImageById(Long id);
}
