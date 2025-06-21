import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { CardModule } from 'primeng/card';
import { FooterComponent } from "../footer/footer.component";
import { HeaderComponent } from "../header/header.component";
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-shop',
  imports: [CommonModule, FooterComponent, HeaderComponent,RouterModule, CardModule],
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent {

  products = [
    {
      id: 1,
      name: 'LED Flood 50W',
      price: 29.99,
      image: 'assets/images/products/flood-light.png'
    },
    {
      id: 2,
      name: 'Cordless Drill Kit',
      price: 89.99,
      image: 'assets/images/products/drill-set.webp'
    },
    {
      id: 3,
      name: 'Light Switch Panel',
      price: 19.99,
      image: 'assets/images/products/switch.webp'
    },
    {
      id: 4,
      name: 'Extension Cord 5m',
      price: 14.99,
      image: 'assets/images/products/extension-cord.png'
    },
    {
      id: 5,
      name: 'Ceiling Fan with Remote',
      price: 129.99,
      image: 'assets/images/products/fan.webp'
    }
  ];
}
