import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { IcommerceComponent } from './icommerce/icommerce.component';
import { ProductsComponent } from './icommerce/products/products.component';
import { ShoppingCartComponent } from './icommerce/shopping-cart/shopping-cart.component';
import { OrdersComponent } from './icommerce/orders/orders.component';
import { IcommerceService } from './icommerce/services/IcommerceService';

@NgModule({
  declarations: [
    AppComponent,
    IcommerceComponent,
    ProductsComponent,
    ShoppingCartComponent,
    OrdersComponent
  ],
  imports: [BrowserModule, HttpClientModule, FormsModule, ReactiveFormsModule],
  providers: [IcommerceService],
  bootstrap: [AppComponent]
})
export class AppModule {}
