import { Component, OnInit } from '@angular/core';
import {FormGroup,FormControl,FormBuilder,ReactiveFormsModule, Validators, NgForm} from '@angular/forms';
import { Router } from '@angular/router';
import { JavaServiceService,Catalogue} from '../java-service.service';
import { HttpClient } from '@angular/common/http';
import { error } from 'util';

@Component({
  selector: 'app-add-catalogue',
  templateUrl: './add-catalogue.component.html',
  styleUrls: ['./add-catalogue.component.css']
})
export class AddCatalogueComponent implements OnInit {

    // this is variable name for  getting the information from Form
    imageName1:any;
    productInformations :any;
    addProduct:FormGroup;

    itemName:string="";
    brandName:string="";
    price:string="";
    productType:string="";
    detail:string="";
    imageName:string="";

    submitted:boolean=false;
    public selectedFile;
    catalogueObj=new Catalogue();

  constructor(private frmbuilder:FormBuilder,private router:Router,private javaObj:JavaServiceService,private http:HttpClient) { }

   // this method used for status of the form control, used for formValidations
   get frm() { 
     return this.addProduct.controls; 
    }

   //this function used for insert record in productInformations object 
  sendData(addProduct:NgForm){
    if(this.addProduct.valid){
      // prarsing data Form Data to Object;
      this.addProduct.value.imageName=this.imageName1;
      this.productInformations=this.addProduct.value; 
      this.catalogueObj=this.productInformations;

      // image upload 
      const upLoadData=new FormData();
      upLoadData.append('myFile',this.selectedFile,this.selectedFile.name);
      this.javaObj.javaUploadImage(upLoadData).subscribe(
        data=>{
            this.javaObj.javaCall(this.catalogueObj);
            this.router.navigateByUrl("/showcatalogue");
        },error=>{
            console.log("image large ");
            this.router.navigateByUrl("/pagenotfound");
        }
      );
    }
    this.submitted=true;
  }

  public imagePath;
  imgURL: any;
  public message: string;

 // this method used for show the image on from
  readURL(files)
  {
      if (files.length === 0)
          return;
  
      var mimeType = files[0].type;
      this.selectedFile=files[0];
      if (mimeType.match(/image\/*/) == null)
      {
          this.message = "Only images are supported.";
          return;
      }
      var reader = new FileReader();
      this.imagePath = files;
      reader.readAsDataURL(files[0]); 
      reader.onload = (_event) =>
      { 
          this.imgURL = reader.result; 
      }
      this.imageName1=files[0].name;
  }

  ngOnInit() {
    // these code are used to geeting information from Form and also used for Form Validations
    this.addProduct=this.frmbuilder.group({
        itemName:['',Validators.compose([Validators.required,Validators.maxLength(15),Validators.minLength(1)])],  
        brandName:['',[Validators.required,Validators.maxLength(19)]], 
        price:['',Validators.required],
        productType:['',Validators.required],
        detail:['',Validators.required],
        imageName:['',Validators.required]
    })
  }
}
