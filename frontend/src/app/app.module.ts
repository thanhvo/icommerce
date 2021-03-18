import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { IcommerceComponent } from './icommerce/icommerce.component';
import { ProductsComponent } from './icommerce/products/products.component';
import { OrdersComponent } from './icommerce/orders/orders.component';
import { ShoppingCartComponent } from './icommerce/shopping-cart/shopping-cart.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    IcommerceComponent,
    ProductsComponent,
    OrdersComponent,
    ShoppingCartComponent
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
