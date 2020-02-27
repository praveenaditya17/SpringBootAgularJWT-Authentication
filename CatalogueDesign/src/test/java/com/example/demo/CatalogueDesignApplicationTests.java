package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.CatalogueDesign;
import com.example.demo.repository.CatalogueRepository;
import com.example.demo.service.Impl.CatalogueServiceImplementation;

@SpringBootTest
class CatalogueDesignApplicationTests {

	@Autowired
	CatalogueServiceImplementation catalogueServiceImpl;
	
	@MockBean
	CatalogueRepository catalogueRepository;
	
	@Test
	void createCatalogueTest() {
		CatalogueDesign catalogueObj=new CatalogueDesign();
		catalogueObj.setItemName("car");
		catalogueObj.setBrandName("mahindra");
		catalogueObj.setPrice("190");
		catalogueObj.setDetail("good");
		catalogueObj.setImageName("image.jpg");
		catalogueObj.setProductType("electronics");
		
		when(catalogueRepository.save(catalogueObj)).thenReturn(catalogueObj);
		assertEquals(catalogueObj,catalogueServiceImpl.createCatalogue(catalogueObj));	
	}
	
	@Test
	void uploadImageTest() {
		MockMultipartFile file=new MockMultipartFile("user-file","abc.txt","text/plain","test data".getBytes());
		MultipartFile xx = catalogueServiceImpl.uploadImage(file);
		assertEquals(file,xx);	
	}
	@Test
	void getCatalogueTest() {
		CatalogueDesign catalogueObj=new CatalogueDesign();
		catalogueObj.setItemName("car");
		catalogueObj.setBrandName("mahindra");
		catalogueObj.setPrice("190");
		catalogueObj.setDetail("good");
		catalogueObj.setImageName("image.jpg");
		catalogueObj.setProductType("electronics");
		
		when(catalogueRepository.findAll()).thenReturn(Stream.of(catalogueObj).collect(Collectors.toList()));
		assertEquals(1,(Stream.of(catalogueServiceImpl.getCatalogue()).count()));
	}
	@Test
	void getAllImageTest() {
		ResponseEntity<Map<String, String>> xx =new ResponseEntity<Map<String,String>>(HttpStatus.OK);
		assertEquals(catalogueServiceImpl.getAllImage().getStatusCodeValue(),xx.getStatusCodeValue());
	}
	@Test
	void getCatalogueTypeTest() {
		CatalogueDesign catalogueObj=new CatalogueDesign();
		catalogueObj.setItemName("car");
		catalogueObj.setBrandName("mahindra");
		catalogueObj.setPrice("190");
		catalogueObj.setDetail("good");
		catalogueObj.setImageName("image.jpg");
		catalogueObj.setProductType("electronics");
		
		when(catalogueRepository.findByProductType("electronics")).thenReturn(Stream.of(catalogueObj).collect(Collectors.toList()));
		assertEquals(catalogueObj.getProductType(),catalogueServiceImpl.getCatalogueType("electronics").iterator().next().getProductType());
	}
	

	

	
	
	

}
