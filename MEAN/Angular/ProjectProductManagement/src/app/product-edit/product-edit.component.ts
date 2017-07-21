import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';
import { Routes, RouterModule  } from '@angular/router';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import {Router, ActivatedRoute} from '@angular/router';
import { Product } from '../product';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  moreproducts: Array<Product>;
  product: Product
  constructor(private router: Router, private _route: ActivatedRoute, private _httpService: HttpService) { 
    this._httpService.observedProducts.subscribe(
      (moreproducts) => {
      this.moreproducts = moreproducts;
    });
    this._route.params.subscribe(
      param => {
        for(var i =0; i < this.moreproducts.length; i++){
          if(this.moreproducts[i].id == param.id){
            this.product = this.moreproducts[i];
            break;
          }
        }
      }
    )  
  }

  ngOnInit() {
    
    
  }




  editingProduct(){
    this._httpService.updateProducts(this.moreproducts)
    this.router.navigate(['/products']);
  }

  delete(product){
    var gettheindex = this.moreproducts.indexOf(product)
    if(gettheindex > -1){
      this.moreproducts.splice(gettheindex, 1)
    }
  }

}
