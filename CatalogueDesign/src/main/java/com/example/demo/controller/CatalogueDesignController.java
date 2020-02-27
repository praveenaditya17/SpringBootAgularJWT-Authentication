package com.example.demo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.CatalogueDesign;
import com.example.demo.service.CatalogueService;

@CrossOrigin
@RestController
@RequestMapping({"/catalogue"})
public class CatalogueDesignController {
	
	@Autowired(required = true)
	@Qualifier("caltalogue2")
	CatalogueService catalogueRepository;
	
	@Autowired 
	ServletContext context;
	
	@RequestMapping("/add")
	public CatalogueDesign  addCatalogue(@RequestBody CatalogueDesign catalogueDesign) {
		return  catalogueRepository.createCatalogue(catalogueDesign);
	}
	
	@PostMapping("/upload")
	public Map<String,String> uploadImage(@RequestParam("myFile")MultipartFile file)throws IOException {
		catalogueRepository.uploadImage(file);
		return new HashMap<String,String>();
	}
	
	@GetMapping({"/get"})
	public Iterable<CatalogueDesign> getCatalogueDetails() {
		return catalogueRepository.getCatalogue();
	}
	
	@GetMapping({"/getImage"})
	@ResponseBody
	public ResponseEntity<Map<String,String>> getImage(){
		return catalogueRepository.getAllImage();
	}
	
	@GetMapping("/electronics")
	public Iterable<CatalogueDesign> gerAllElectronicsCatalogue(){
		return catalogueRepository.getCatalogueType("electronics");
	}
	
	@GetMapping("/footwear")
	public Iterable<CatalogueDesign> gerAllFootwearCatalogue(){
		return catalogueRepository.getCatalogueType("footwear");
	}
	
	@GetMapping("/cloths")
	public Iterable<CatalogueDesign> gerAllClothsCatalogue(){
		return catalogueRepository.getCatalogueType("cloths");
	}
	
	@GetMapping("/books")
	public Iterable<CatalogueDesign> gerAllBooksCatalogue(){
		return catalogueRepository.getCatalogueType("books");
	}
	
	@GetMapping("/vehicle")
	public Iterable<CatalogueDesign> gerAllVehicleCatalogue(){
		return catalogueRepository.getCatalogueType("vehicle");
	}
}
