import {Component, OnInit} from "@angular/core";
import {Observable} from "rxjs";
import {Category} from "../model/category";
import {FormBuilder, FormControl, Validators} from "@angular/forms";
import {CategoryStorage} from "./category.storage";

@Component({
  selector: 'app-categories-page',
  templateUrl: 'categories-page.component.html',
  styleUrls: ['categories-page.component.scss']
})
export class CategoriesPageComponent implements OnInit {
  readonly categories$: Observable<Category[]>;

  categoryNameFormControl: FormControl;

  constructor(
    private formBuilder: FormBuilder,
    private categoryStorage: CategoryStorage,
  ) {
    this.categories$ = this.categoryStorage.loadAndGetAll()
  }

  ngOnInit(): void {
    this.categoryNameFormControl = this.getCategoryNameFormControl();
  }

  private getCategoryNameFormControl(): FormControl {
    // Since we are using a form control, we can easily customize the input as we need it.
    // For example, we can add validation functions and set an initial value.
    return this.formBuilder
      .control(null, [
        Validators.required
      ]);
  }

  addCategory() {
    if (this.categoryNameFormControl.invalid) {
      return;
    }

    const categoryName = this.categoryNameFormControl.value;

    this.categoryStorage.add({ name: categoryName })
      .subscribe(() => this.categoryNameFormControl.setValue(''));
  }

  deleteCategory(event: Event, category: Category): void {
    event.preventDefault();
    event.stopPropagation();

    this.categoryStorage.delete(category).subscribe();
  }
}
