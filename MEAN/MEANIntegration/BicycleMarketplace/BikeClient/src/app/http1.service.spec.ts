import { TestBed, inject } from '@angular/core/testing';

import { Http1Service } from './http1.service';

describe('Http1Service', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [Http1Service]
    });
  });

  it('should be created', inject([Http1Service], (service: Http1Service) => {
    expect(service).toBeTruthy();
  }));
});
