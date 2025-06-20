import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { RatingModule } from 'primeng/rating';
import { FormsModule } from '@angular/forms';
import { FooterComponent } from '../footer/footer.component';
import { HeaderComponent } from '../header/header.component';
import { CardModule } from 'primeng/card';
import { ButtonModule } from 'primeng/button';
import { InputNumberModule } from 'primeng/inputnumber';

interface Product {
  id: number;
  name: string;
  price: number;
  image: string;
}

@Component({
  selector: 'app-product-detail',
  standalone: true,
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    FooterComponent,
    HeaderComponent,
    RatingModule,
    CardModule,
    ButtonModule,
    InputNumberModule,
  ],
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css'],
})
export class ProductDetailComponent {
  productId: number | null = null;
  product: any;

  mockProducts = [
    {
      id: 1,
      name: 'LED Flood 50W',
      price: 29.99,
      image: 'assets/images/products/flood-light.png',
    },
    {
      id: 2,
      name: 'Cordless Drill Kit',
      price: 89.99,
      image: 'assets/images/products/drill-set.webp',
    },
    {
      id: 3,
      name: 'Light Switch Panel',
      price: 19.99,
      image: 'assets/images/products/switch.webp',
    },
    {
      id: 4,
      name: 'Extension Cord 5m',
      price: 14.99,
      image: 'assets/images/products/extension-cord.png',
    },
    {
      id: 5,
      name: 'Ceiling Fan with Remote',
      price: 129.99,
      image: 'assets/images/products/fan.webp',
    },
  ];

  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    this.productId = Number(this.route.snapshot.paramMap.get('id'));
    this.product = this.mockProducts.find((p) => p.id === this.productId);
  }

  quantity: number = 1;

  buyNow(product: Product, quantity: number) {
    console.log(`Buying ${quantity} of ${product.name}`); // Add your checkout logic here
  }
}
