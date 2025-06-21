import { Component } from '@angular/core';
import { FooterComponent } from '../footer/footer.component';
import { HeaderComponent } from '../header/header.component';
import { CommonModule } from '@angular/common';
import { Carousel } from 'primeng/carousel';
import { ButtonModule } from 'primeng/button';
import { ServiceQualityComponent } from "../service-quality/service-quality.component";
import { RouterModule } from '@angular/router';
// import { Tag } from 'primeng/tag';

@Component({
  selector: 'app-home',
  imports: [
    FooterComponent,
    HeaderComponent,
    CommonModule,
    Carousel,
    ButtonModule,
    ServiceQualityComponent,
    RouterModule
],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
})
export class HomeComponent {



  categories = [
    {
      name: 'Lighting',
      image: 'assets/images/categories/lighting.jpg',
    },
    {
      name: 'Power Tools',
      image: 'assets/images/categories/power-tools.jpg',
    },
    {
      name: 'Accessories',
      image: 'assets/images/categories/accessories.jpg',
    },
  ];

  

  

    
    

    featuredProducts = [
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
  // Add more products...
];

responsiveOptions = [
  {
    breakpoint: '1024px',
    numVisible: 3,
    numScroll: 1
  },
  {
    breakpoint: '768px',
    numVisible: 2,
    numScroll: 1
  },
  {
    breakpoint: '560px',
    numVisible: 1,
    numScroll: 1
  }
];



}
