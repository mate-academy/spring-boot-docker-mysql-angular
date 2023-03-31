import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {ProductsPageComponent} from "./products-page/products-page.component";
import {HttpClientModule} from "@angular/common/http";
import {CategoriesPageComponent} from "./categories-page/categories-page.component";
import {CardComponent} from "./common/card/card.component";
import {ReactiveFormsModule} from "@angular/forms";
import {ProductCardComponent} from "./products-page/product-card/product-card.component";
import {AppIconsModule} from "./common/icons/app-icons.module";

@NgModule({
  declarations: [
    AppComponent,
    CardComponent,
    ProductCardComponent,
    ProductsPageComponent,
    CategoriesPageComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    AppIconsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
