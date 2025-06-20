import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ShopComponent } from './components/shop/shop.component';
import { ContactComponent } from './components/contact/contact.component';
import { ProductDetailComponent } from './components/product-detail/product-detail.component';
import { ExpComponent } from './components/exp/exp.component';

export const routes: Routes = [
    {path: '',component: HomeComponent},
    {path: 'shop',component:ShopComponent},
    {path: 'exp',component:ExpComponent},
    {path:'contact',component:ContactComponent},
    {path:'product/:id',component:ProductDetailComponent}
];
