import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BrowsedashboardComponent } from './browsedashboard.component';

describe('BrowsedashboardComponent', () => {
  let component: BrowsedashboardComponent;
  let fixture: ComponentFixture<BrowsedashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BrowsedashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BrowsedashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
