package com.example.ImageFileUpload.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ImageFileUpload.entities.ImageUploadEntity;

public interface ImageUploadRepositories extends JpaRepository<ImageUploadEntity,Long>{

}
