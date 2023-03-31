import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CategoriesPageComponent} from "./categories-page/categories-page.component";
import {ProductsPageComponent} from "./products-page/products-page.component";
import {URL} from "../constants/URL";

const routes: Routes = [
  {
    path: 'categories',
    component: CategoriesPageComponent,
    children: [
      {
        path: `:${URL.categoryId}`,
        children: [
          {
            path: 'products',
            component: ProductsPageComponent,
          },
        ],
      },
    ],
  },
  {
    path: '',
    redirectTo: 'categories',
    pathMatch: 'full',
  },
  {
    path: '**',
    redirectTo: 'categories',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
