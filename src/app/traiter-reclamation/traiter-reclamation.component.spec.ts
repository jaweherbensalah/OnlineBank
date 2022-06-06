import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TraiterReclamationComponent } from './traiter-reclamation.component';

describe('TraiterReclamationComponent', () => {
  let component: TraiterReclamationComponent;
  let fixture: ComponentFixture<TraiterReclamationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TraiterReclamationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TraiterReclamationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
