import { Component, OnInit, Input } from '@angular/core';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { HttpService } from '../http.service';
import {Router, ActivatedRoute} from '@angular/router';
import { Product } from '../product'
@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  moreproducts: Array<Product> = [];
  title = "Products List"
  constructor(private _httpService: HttpService) {
      
   }

   

  ngOnInit() {
    this._httpService.observedProducts.subscribe(
      (moreproducts) => {
      this.moreproducts = moreproducts;
    });
  }

  delete(product){
    var gettheindex = this.moreproducts.indexOf(product)
    if(gettheindex > -1){
      this.moreproducts.splice(gettheindex, 1)
    }
     this._httpService.updateProducts(this.moreproducts);
  }


}
