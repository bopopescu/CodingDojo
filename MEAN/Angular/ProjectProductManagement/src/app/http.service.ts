import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { Product } from './product';

@Injectable()
export class HttpService {
  observedProducts = new BehaviorSubject(null);

  constructor() { }
  
  updateProducts(products: Array<Product>) {
    this.observedProducts.next(products);
  }
  

  

}
