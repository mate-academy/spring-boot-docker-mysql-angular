import {Component, Input} from "@angular/core";
import {Product} from "../../model/product";

@Component({
  selector: 'app-product-card',
  templateUrl: 'product-card.component.html',
  styleUrls: ['product-card.component.scss']
})
export class ProductCardComponent {
  @Input() product: Product;
}
