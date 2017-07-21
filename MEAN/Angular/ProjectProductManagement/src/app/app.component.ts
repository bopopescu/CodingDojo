import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpService } from './http.service';
import { Product } from './product';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'PPM - Project Product Management';
  products = [
    new Product(1, 'DSLR Camera', 1499.99, 'https://www.bhphotovideo.com/images/images2000x2000/canon_eos_5d_mark_iv_1274706.jpg'),
    new Product(2, 'Mac Laptop', 1299.99, 'http://www8.pcmag.com/media/images/297548-apple-macbook-air-11-inch-mid-2012.jpg')
  ];

  constructor(private _productService: HttpService) {
    this._productService.updateProducts(this.products);
    this._productService.observedProducts.subscribe( (products) => {
      this.products = products;
    });
  }
}
