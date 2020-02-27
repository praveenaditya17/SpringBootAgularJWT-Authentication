import { BrowserModule } from '@angular/platform-browser';
import { NgModule} from '@angular/core';
import {ReactiveFormsModule,FormsModule} from '@angular/forms'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddCatalogueComponent } from './add-catalogue/add-catalogue.component';
import { ShowCatalogueComponent } from './show-catalogue/show-catalogue.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import {HttpClientModule,HttpClient, HTTP_INTERCEPTORS} from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { BasicAuthHtppInterceptorService } from './service/basic-auth-htpp-interceptor-service.service';

@NgModule({
  declarations: [
    AppComponent,
    AddCatalogueComponent,
    ShowCatalogueComponent,
    PageNotFoundComponent,
    LoginComponent,
    LogoutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,HttpClientModule,FormsModule
  ],
  providers: [
    {
      provide:HTTP_INTERCEPTORS, useClass:BasicAuthHtppInterceptorService, multi:true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
