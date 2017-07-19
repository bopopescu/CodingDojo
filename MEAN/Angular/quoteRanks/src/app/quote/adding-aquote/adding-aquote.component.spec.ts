import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddingAQuoteComponent } from './adding-aquote.component';

describe('AddingAQuoteComponent', () => {
  let component: AddingAQuoteComponent;
  let fixture: ComponentFixture<AddingAQuoteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddingAQuoteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddingAQuoteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
