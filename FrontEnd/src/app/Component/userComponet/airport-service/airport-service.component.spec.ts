import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AirportServiceComponent } from './airport-service.component';

describe('AirportServiceComponent', () => {
  let component: AirportServiceComponent;
  let fixture: ComponentFixture<AirportServiceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AirportServiceComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AirportServiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
