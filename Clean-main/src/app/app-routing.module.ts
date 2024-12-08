import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FrontLayoutComponent } from './layouts/front-layout/front-layout.component';
import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';

import { HomeComponent } from './views/front/home/home/home.component';


const routes: Routes = [
 

  
  {path:"", component:FrontLayoutComponent, children:[
       {path:"", loadChildren:()=>import("./views/front/home/home.module").then(m=>m.HomeModule)},
       {path:"user",  loadChildren:()=>import("./views/front/user/user.module").then(m=>m.UserModule)},
  ]},
  {path:"admin",component: AdminLayoutComponent, children: [
       
       {path:"dashboard", loadChildren:()=>import ("./views/admin/dashboard/dashboard.module").then(m=>m.DashboardModule)},    
       {path:"universite" ,  loadChildren:()=>import ("./views/admin/universite/universite.module").then(m=>m.UniversiteModule)},
       {path:"foyer" , loadChildren:()=>import ("./views/admin/foyer/foyer.module").then(m=>m.FoyerModule)},
       {path:"bloc" ,  loadChildren:()=>import ("./views/admin/bloc/bloc.module").then(m=>m.BlocModule)},
       {path:"chambre" ,  loadChildren:()=>import ("./views/admin/chambre/chambre.module").then(m=>m.ChambreModule)},
       {path:"reservation" ,   loadChildren:()=>import ("./views/admin/reservation/reservation.module").then(m=>m.ReservationModule)},
       {path:"etudiant" , loadChildren:()=>import ("./views/admin/etudiant/etudiant.module").then(m=>m.EtudiantModule)},
  
  ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
