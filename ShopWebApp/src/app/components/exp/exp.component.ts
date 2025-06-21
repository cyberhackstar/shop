import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { FooterComponent } from "../footer/footer.component";
import { HeaderComponent } from "../header/header.component";
import { DropdownModule } from 'primeng/dropdown';
import { RouterModule } from '@angular/router';
import { InputTextModule } from 'primeng/inputtext';


interface Product {
  id:number;
  name: string;
  category: string;
  description: string;
  price: number;
  image: string;
}

@Component({
  selector: 'app-exp',
  standalone: true,
  imports: [CommonModule, FormsModule, FooterComponent, HeaderComponent, DropdownModule, RouterModule, InputTextModule],
  templateUrl: './exp.component.html',
  styleUrl: './exp.component.css',
})
export class ExpComponent {
  activeTab = 'tab-1';


  categories = [
    { id: 'tab-1', name: 'All Products' },
    { id: 'tab-2', name: 'Fans' },
    { id: 'tab-3', name: 'Lights' },
    { id: 'tab-4', name: 'Cables' },
    { id: 'tab-5', name: 'Switches' },
  ];

  products = [
    {
      id:1,
      name: 'Ceiling Fan',
      category: 'Fans',
      description: 'High-speed fan',
      price: 1499,
      image: 'assets/images/products/fan.webp',
    },
    {id:2,
      name: 'LED Bulb',
      category: 'Lights',
      description: 'Bright LED bulb',
      price: 199,
      image: 'assets/images/products/bulb.jpg',
    },
    {id:3,
      name: 'Copper Cable',
      category: 'Cables',
      description: 'Durable copper cable',
      price: 799,
      image: 'assets/images/products/extension-cord.png',
    },
    {id:4,
      name: 'Modular Switch',
      category: 'Switches',
      description: 'Stylish switch',
      price: 99,
      image: 'assets/images/products/switch.webp',
    },
    {id:5,
      name: 'Modular Switch',
      category: 'Switches',
      description: 'Stylish switch',
      price: 99,
      image: 'assets/images/products/switch.webp',
    },
    {id:6,
      name: 'Modular Switch',
      category: 'Cables',
      description: 'Stylish switch',
      price: 99,
      image: 'assets/images/products/switch.webp',
    }
    // Add more as needed
  ];

  searchQuery = '';
  selectedCategory = 'All';

  itemsPerPage = 4;

  currentPage: number = 1;
  totalPages: number = 1;

  goToPreviousPage(): void {
    if (this.currentPage > 1) {
      this.currentPage--;
    }
  }

  goToNextPage(): void {
    if (this.currentPage < this.totalPages) {
      this.currentPage++;
      // Optionally, add logic to fetch or display the next page of products
    }
  }

  getFilteredProducts(): Product[] {
  let filtered = this.products;

  if (this.selectedCategory !== 'All') {
    filtered = filtered.filter(p => p.category === this.selectedCategory);
  }

  if (this.searchQuery.trim()) {
    const query = this.searchQuery.toLowerCase();
    filtered = filtered.filter(
      p => p.name.toLowerCase().includes(query) || p.description.toLowerCase().includes(query)
    );
  }

  return filtered; // No slicing
}


  

}
