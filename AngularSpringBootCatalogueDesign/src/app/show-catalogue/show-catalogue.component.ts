import { Component, OnInit } from '@angular/core';
import { JavaServiceService, Catalogue } from '../java-service.service';

@Component({
  selector: 'app-show-catalogue',
  templateUrl: './show-catalogue.component.html',
  styleUrls: ['./show-catalogue.component.css']
})

export class ShowCatalogueComponent implements OnInit {

  catalogueObj:Catalogue[];
  public images:any=[];

  constructor(private javaServiceObj:JavaServiceService) {   
  }

  electronics(){
    this.javaServiceObj.getElectronicsCatalogue().subscribe(
      (response)=>{this.catalogueObj=response;
        //console.log(this.catalogueObj);
      }
    );
  }

  footwear(){
    this.javaServiceObj.getFootwearCatalogue().subscribe(
      (response)=>{this.catalogueObj=response;
        //console.log(this.catalogueObj);
      }
    );
  }

  cloths(){
    this.javaServiceObj.getClothsCatalogue().subscribe(
      (response)=>{this.catalogueObj=response;
        //console.log(this.catalogueObj);
      }
    );
  }

  books(){
    this.javaServiceObj.getBooksCatalogue().subscribe(
      (response)=>{this.catalogueObj=response;
        //console.log(this.catalogueObj);
      }
    );
  }

  vehicle(){
    this.javaServiceObj.getVehicleCatalogue().subscribe(
      (response)=>{this.catalogueObj=response;
        //console.log(this.catalogueObj);
      }
    );
  }

  ngOnInit() {
    this.javaServiceObj.javaGetCatalogue().subscribe(
      (response) =>{this.catalogueObj = response; 
      }
    );
    this.javaServiceObj.getImage().subscribe(
      response=>{
        this.images=response;
       // console.log(this.images);   
      }
    );
  }
}
