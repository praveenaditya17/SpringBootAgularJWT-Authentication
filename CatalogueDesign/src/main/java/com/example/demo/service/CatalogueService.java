package com.example.demo.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.CatalogueDesign;

public interface CatalogueService {
	
	public CatalogueDesign createCatalogue(CatalogueDesign catalogueDesign);
	public MultipartFile  uploadImage(MultipartFile file);
	public Iterable<CatalogueDesign> getCatalogue();
	public ResponseEntity<Map<String,String>> getAllImage();
	public Iterable<CatalogueDesign>getCatalogueType(String productType);
}
