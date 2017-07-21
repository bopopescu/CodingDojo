import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { Routes, RouterModule  } from '@angular/router';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { HttpService } from '../http.service';
import {Router, ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-product-creation',
  templateUrl: './product-creation.component.html',
  styleUrls: ['./product-creation.component.css']
})
export class ProductCreationComponent implements OnInit {
  title = "Create a New Product"
  product: Product = new Product();
  moreproducts: Array<Product>;
  


  constructor(private router: Router, private _route: ActivatedRoute, private _httpService: HttpService){
    this._httpService.observedProducts.subscribe( (moreproducts) => {
      this.moreproducts = moreproducts;
    })
  }

  ngOnInit() {
    this.product = new Product()
  }


  onSubmit(){
    if(this.product.image_url == ""){
      this.product.image_url = "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/No_image_available.svg/1024px-No_image_available.svg.png"
    }
    this.moreproducts.push(this.product)
    console.log(this.moreproducts)
    this._httpService.updateProducts(this.moreproducts)
    this.product = new Product();
    this.router.navigate(['/products']);
  }




}
