import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormAndScoreComponent } from './form-and-score.component';

describe('FormAndScoreComponent', () => {
  let component: FormAndScoreComponent;
  let fixture: ComponentFixture<FormAndScoreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormAndScoreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormAndScoreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
