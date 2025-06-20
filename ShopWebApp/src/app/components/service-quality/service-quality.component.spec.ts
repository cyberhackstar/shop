import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceQualityComponent } from './service-quality.component';

describe('ServiceQualityComponent', () => {
  let component: ServiceQualityComponent;
  let fixture: ComponentFixture<ServiceQualityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ServiceQualityComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ServiceQualityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
