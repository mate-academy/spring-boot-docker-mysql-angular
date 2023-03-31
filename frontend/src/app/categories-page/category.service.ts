import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";
import {Category} from "../model/category";
import {Injectable} from "@angular/core";
import {CategoryCreationDto} from "../model/category-creation-dto";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private readonly apiUrl = environment.apiUrl;

  private readonly categoriesPrefix = '/categories';

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<Category[]> {
    return this.httpClient
      .get<Category[]>(`${this.apiUrl}${this.categoriesPrefix}`);
  }

  add(category: CategoryCreationDto): Observable<Category> {
    return this.httpClient
      .post<Category>(`${this.apiUrl}${this.categoriesPrefix}`, category);
  }

  delete(categoryId: number): Observable<Category> {
    return this.httpClient
      .delete<Category>(`${this.apiUrl}${this.categoriesPrefix}/${categoryId}`);
  }
}
