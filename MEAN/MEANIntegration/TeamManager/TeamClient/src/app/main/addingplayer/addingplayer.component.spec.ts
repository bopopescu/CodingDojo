import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddingplayerComponent } from './addingplayer.component';

describe('AddingplayerComponent', () => {
  let component: AddingplayerComponent;
  let fixture: ComponentFixture<AddingplayerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddingplayerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddingplayerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
