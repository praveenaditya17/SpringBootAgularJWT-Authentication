import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {} from '@angular/common';
import { Observable } from 'rxjs';

export class Catalogue{
   public itemName:string;
   public brandName:string;
   public price:string;
   public productType:string;
   public detail:string;
   public imageName:string;//image name
}

@Injectable({
  providedIn: 'root'
})
export class JavaServiceService {
  private urls:string;
  constructor(private http:HttpClient) { 
  }

  // this method is used for add the catalogue product
  javaCall(product:Catalogue){
    this.urls="http://localhost:8080/catalogue/add";
    this.http.post(this.urls,product).subscribe(
      (result)=>{
      //  console.log(result);
      }
    )  
  }
  
  //this method is used for uploading the image 
  javaUploadImage(upLoadData:FormData){
     return this.http.post('http://localhost:8080/catalogue/upload',upLoadData);
  }

  //this method is used for getting the all catalogue product
  javaGetCatalogue(){
    return this.http.get<Catalogue[]>('http://localhost:8080/catalogue/get',);
  }

  //this method is used for getting the image of catalogue product
  getImage():Observable<any>{
    return this.http.get('http://localhost:8080/catalogue/getImage');
  }

  //this method is used for getting the electronics product types
  getElectronicsCatalogue(){
    return this.http.get<Catalogue[]>('http://localhost:8080/catalogue/electronics');
  }

  //this method is used for getting the vehicle product types
  getVehicleCatalogue(){
    return this.http.get<Catalogue[]>('http://localhost:8080/catalogue/vehicle');
  }

  //this method is used for getting the cloths product types
  getClothsCatalogue(){
    return this.http.get<Catalogue[]>('http://localhost:8080/catalogue/cloths');
  }

  //this method is used for getting the books product types
  getBooksCatalogue(){
    return this.http.get<Catalogue[]>('http://localhost:8080/catalogue/books');
  }

  //this method is used for getting the footwear product types
  getFootwearCatalogue(){
    return this.http.get<Catalogue[]>('http://localhost:8080/catalogue/footwear ');
  }
}
