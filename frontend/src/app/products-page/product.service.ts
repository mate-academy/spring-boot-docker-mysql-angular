import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../model/product";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private readonly apiUrl = environment.apiUrl;

  private readonly productsPrefix = '/products';

  constructor(
    private httpClient: HttpClient,
  ) {
  }

  getProductsByCategoryId(categoryId: string): Observable<Product[]> {
    return this.httpClient
      .get<Product[]>(
        `${this.apiUrl}${this.productsPrefix}`,
        {
          params: new HttpParams().set('categoryId', `${categoryId}`)
        }
        );
  }
}
