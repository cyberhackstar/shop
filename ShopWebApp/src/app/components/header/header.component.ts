import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { Router } from '@angular/router';
import { ButtonModule } from 'primeng/button';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [CommonModule, RouterModule, ButtonModule],
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent {

userRole:string= 'ROLE_USER';

  menuItems = [
    { label: 'Home', icon: 'pi pi-home', routerLink: '/' },
    { label: 'Shop', icon: 'pi pi-shopping-bag', routerLink: '/exp' },
    { label: 'About', icon: 'pi pi-info-circle', routerLink: '/about' },
    { label: 'Contact', icon: 'pi pi-envelope', routerLink: '/contact' },
    // { label: 'FAQ', icon: 'pi pi-question-circle', routerLink: '/faq' },
  ];

  constructor(private router:Router){}

  navigateTo(path: string): void {
    this.router.navigate([path]);
  }
}
