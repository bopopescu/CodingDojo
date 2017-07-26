import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MylistingsdashboardComponent } from './mylistingsdashboard.component';

describe('MylistingsdashboardComponent', () => {
  let component: MylistingsdashboardComponent;
  let fixture: ComponentFixture<MylistingsdashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MylistingsdashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MylistingsdashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
