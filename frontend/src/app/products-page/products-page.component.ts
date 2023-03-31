import {Component, OnInit} from "@angular/core";
import {Product} from "../model/product";
import {map, mergeMap, Observable} from "rxjs";
import {ProductService} from "./product.service";
import {ActivatedRoute } from "@angular/router";
import {URL} from "../../constants/URL";

@Component({
  selector: 'app-products-page',
  templateUrl: 'products-page.component.html',
  styleUrls: ['products-page.component.scss']
})
export class ProductsPageComponent implements OnInit {
  products$: Observable<Product[]>;

  constructor(
    private activatedRoute: ActivatedRoute,
    private productService: ProductService,
  ) {
  }

  ngOnInit(): void {
    this.products$ = this.loadProductsByCategoryIdFromUrlParams();
  }

  private loadProductsByCategoryIdFromUrlParams() {
    return this.activatedRoute.params.pipe(
      map(params => params[URL.categoryId]),
      mergeMap((categoryId) => this.productService.getProductsByCategoryId(categoryId))
    )
  }
}
