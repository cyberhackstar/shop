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
  userRole: string = 'ROLE_USER';

  menuItems = [
    { label: 'Home', icon: 'pi pi-home', routerLink: '/' },
    { label: 'Shop', icon: 'pi pi-shopping-bag', routerLink: '/exp' },
    { label: 'About', icon: 'pi pi-info-circle', routerLink: '/about' },
    { label: 'Contact', icon: 'pi pi-envelope', routerLink: '/contact' },
    // { label: 'FAQ', icon: 'pi pi-question-circle', routerLink: '/faq' },
  ];

  constructor(private router: Router) {}

  ngAfterViewInit() {
    this.router.events.subscribe(() => {
      const offcanvas = document.querySelector('.offcanvas') as HTMLElement;
      if (offcanvas && offcanvas.classList.contains('show')) {
        // @ts-ignore
        const bsOffcanvas = (window as any).bootstrap?.Offcanvas?.getInstance(offcanvas);
        bsOffcanvas?.hide();
      }
    });
  }

  navigateTo(path: string): void {
    this.router.navigate([path]);
  }
}
