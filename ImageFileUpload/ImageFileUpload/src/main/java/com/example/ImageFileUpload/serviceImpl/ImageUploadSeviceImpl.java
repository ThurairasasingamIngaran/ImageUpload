package com.example.ImageFileUpload.serviceImpl;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.ImageFileUpload.entities.ImageUploadEntity;
import com.example.ImageFileUpload.repositories.ImageUploadRepositories;
import com.example.ImageFileUpload.service.ImageUploadService;

@Service
public class ImageUploadSeviceImpl implements ImageUploadService{

	@Autowired
	private ImageUploadRepositories imageUploadRepositories;
	@Override
	public void uploadImage(MultipartFile file) throws IOException {
		ImageUploadEntity imageUploadEnitity=new ImageUploadEntity();
		imageUploadEnitity.setImage(file.getBytes());
		imageUploadRepositories.save(imageUploadEnitity);
	}

	@Override
	public Optional<ImageUploadEntity> getImageById(Long id) {
		return imageUploadRepositories.findById(id);
	}

}
