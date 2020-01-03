import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FoodMenuComponent } from './food/food-menu/food-menu.component';
import { CartComponent } from './shopping/cart/cart.component';
import { ItemEditComponent } from './food/item-edit/item-edit.component';
import { SignupComponent } from './site/signup/signup.component';
import { LoginComponent } from './site/login/login.component';
import { AuthGuard } from './site/auth.guard';

const routes: Routes = [
  {path:'' , component: FoodMenuComponent},
  {path:'cart' , component: CartComponent,canActivate:[AuthGuard]},
  {path:'edit-item/:id' , component: ItemEditComponent,canActivate:[AuthGuard]},
  {path:'signUp/:error' , component: SignupComponent},
  {path:'signUp' , component: SignupComponent},
  {path:'login/:err' , component: LoginComponent},
  {path:'login' , component: LoginComponent},
  {path:'login/:pass/:value' , component: LoginComponent},
  {path:'foodMenu' , component: FoodMenuComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }