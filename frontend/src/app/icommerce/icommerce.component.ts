import { Component, OnInit, ViewChild } from '@angular/core';
import { ProductsComponent } from './products/products.component';
import { ShoppingCartComponent } from './shopping-cart/shopping-cart.component';
import { OrdersComponent } from './orders/orders.component';

@Component({
  selector: 'app-icommerce',
  templateUrl: './icommerce.component.html',
  styleUrls: ['./icommerce.component.scss']
})
export class IcommerceComponent implements OnInit {
  private collapsed = true;
  orderFinished = false;

  @ViewChild('productsC')
  productsC: ProductsComponent | undefined;

  @ViewChild('shoppingCartC')
  shoppingCartC: ShoppingCartComponent | undefined;

  @ViewChild('ordersC')
  ordersC: OrdersComponent | undefined;

  toggleCollapsed(): void {
    this.collapsed = !this.collapsed;
  }

  finishOrder(orderFinished: boolean) {
    this.orderFinished = orderFinished;
  }

  reset() {
    this.orderFinished = false;
    /*this.productsC.reset();
    this.shoppingCartC.reset();
    this.ordersC.paid = false;*/
  }

  constructor() {}

  ngOnInit(): void {}
}
