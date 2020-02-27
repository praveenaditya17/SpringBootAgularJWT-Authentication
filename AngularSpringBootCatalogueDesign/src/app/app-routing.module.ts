import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AddCatalogueComponent } from './add-catalogue/add-catalogue.component';
import { ShowCatalogueComponent } from './show-catalogue/show-catalogue.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { LoginComponent} from './login/login.component';
import {LogoutComponent} from './logout/logout.component'; 
import{AuthGaurdService} from './service/auth-gaurd.service';
const routes: Routes = [
  {path:'',redirectTo:'/addcatalogue',pathMatch:'full'}, 
  {path:'addcatalogue',component:AddCatalogueComponent,canActivate:[AuthGaurdService]},
  {path:'showcatalogue',component:ShowCatalogueComponent,canActivate:[AuthGaurdService]},
  {path:'login',component:LoginComponent},
  {path:'logout',component:LogoutComponent,canActivate:[AuthGaurdService]},
  {path:'**',component:PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents=[AddCatalogueComponent,ShowCatalogueComponent,LoginComponent,PageNotFoundComponent]
