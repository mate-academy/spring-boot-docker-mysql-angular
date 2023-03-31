import {BehaviorSubject, mergeMap, Observable, tap} from "rxjs";
import {Category} from "../model/category";
import {Injectable} from "@angular/core";
import {CategoryService} from "./category.service";
import {CategoryCreationDto} from "../model/category-creation-dto";

@Injectable({
  providedIn: 'root'
})
export class CategoryStorage {
  // We need to create a BehaviorSubject to store loaded categories
  // and be able to control the value and share an event to subscribers when it changes
  private readonly categories = new BehaviorSubject<Category[]>([]);

  readonly categories$ = this.categories.asObservable();

  constructor(
    private categoryService: CategoryService,
  ) {
  }

  loadAndGetAll(): Observable<Category[]> {
    return this.categoryService.getAll().pipe(
      tap((categories) => this.categories.next(categories)),
      mergeMap(() => this.categories$),
      // The mergeMap function replaces the initial observable with the one which we return in callback function
    );
  }


  add(category: CategoryCreationDto): Observable<Category> {
    return this.categoryService.add(category)
      .pipe(
        tap((category) => this.addToStorage(category))
      );
  }

  delete(category: Category): Observable<Category> {
    return this.categoryService.delete(category.id)
      .pipe(
        tap(() => this.deleteFromStorage(category.id))
      );
  }

  private addToStorage(category: Category): void {
    const categories = this.categories.value.slice(0);
    // We need to make a copy of the value from BehaviorSubject to be able to update it

    categories.push(category)

    this.categories.next(categories)
  }

  private deleteFromStorage(categoryId: number): void {
    const categories = this.categories.value
      .filter((category) => category.id !== categoryId);
    // we use a double equal here to make a strict comparing;
    // Read more (here)[https://www.scaler.com/topics/javascript/difference-between-double-equals-and-triple-equals-in-javascript/]

    this.categories.next(categories)
  }
}
