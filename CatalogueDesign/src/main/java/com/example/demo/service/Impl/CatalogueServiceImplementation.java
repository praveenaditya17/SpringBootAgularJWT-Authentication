package com.example.demo.service.Impl;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.CatalogueDesign;
import com.example.demo.repository.CatalogueRepository;
import com.example.demo.service.CatalogueService;

@Service
public class CatalogueServiceImplementation implements CatalogueService{
	
	@Autowired
	CatalogueRepository catalogueRepository;
	
	@Override
	@Transactional
	public CatalogueDesign createCatalogue(CatalogueDesign catalogueDesign) {
		catalogueRepository.save(catalogueDesign);
		return catalogueDesign;
	}
	
	@Transactional
	public MultipartFile  uploadImage(MultipartFile file) {
		String folder="//home/praveen/photos/";
		Path path=Paths.get(folder+file.getOriginalFilename());
		try {
			Files.write(path,file.getBytes());
		} catch (Exception e) {
			try {
				Files.delete(path);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return file;
	}
	
	@Override
	@Transactional
	public Iterable<CatalogueDesign> getCatalogue() {
		return catalogueRepository.findAll();
	}
	
	@Override
	@Transactional
	public ResponseEntity<Map<String,String>> getAllImage() {
		Map<String,String> images=new HashMap<String,String>();
		File fileFolder=new File("/home/praveen/photos");
		if(fileFolder!=null) {
			for(final File file:fileFolder.listFiles()) {
				if(!file.isDirectory()) {
					String encodeBase64=null;
					try {
						String extension=FilenameUtils.getExtension(file.getName());
						String fname=FilenameUtils.getName(file.getName());
						FileInputStream fileInputStream=new FileInputStream(file);
						byte[] bytes=new byte[(int)file.length()];
						fileInputStream.read(bytes);
						encodeBase64=java.util.Base64.getEncoder().encodeToString(bytes);
						images.put(fname,"data:image/"+extension+";base64,"+encodeBase64);
						fileInputStream.close();		
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return new ResponseEntity<Map<String,String>>(images,HttpStatus.OK);
	}

	@Override
	@Transactional
	public Iterable<CatalogueDesign> getCatalogueType(String productType) {
		return catalogueRepository.findByProductType(productType);
	}

}
