import { Component, OnInit } from '@angular/core';
import { ProductOrder } from '../models/product-order.model';
import { IcommerceService } from '../services/IcommerceService';
import { Subscription } from 'rxjs/internal/Subscription';
import { ProductOrders } from '../models/product-orders.model';
import { Product } from '../models/product.model';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {
  productOrders: ProductOrder[] = [];
  products: Product[] = [];
  selectedProductOrder: ProductOrder;
  private shoppingCartOrders: ProductOrders;
  sub: Subscription | undefined;
  productSelected: boolean = false;

  constructor(private ecommerceService: IcommerceService) {
    this.selectedProductOrder = new ProductOrder(
      new Product(0, '', 1.0, 'image.local'),
      0
    );
    this.shoppingCartOrders = new ProductOrders();
    //this.sub = new Subscription();
  }

  ngOnInit() {
    this.productOrders = [];
    this.loadProducts();
    this.loadOrders();
  }

  addToCart(order: ProductOrder) {
    this.ecommerceService.SelectedProductOrder = order;
    this.selectedProductOrder = this.ecommerceService.SelectedProductOrder;
    this.productSelected = true;
  }

  removeFromCart(productOrder: ProductOrder) {
    let index = this.getProductIndex(productOrder.product);
    if (index > -1) {
      this.shoppingCartOrders.productOrders.splice(
        this.getProductIndex(productOrder.product),
        1
      );
    }
    this.ecommerceService.ProductOrders = this.shoppingCartOrders;
    this.shoppingCartOrders = this.ecommerceService.ProductOrders;
    this.productSelected = false;
  }

  getProductIndex(product: Product): number {
    return this.ecommerceService.ProductOrders.productOrders.findIndex(
      value => value.product === product
    );
  }

  isProductSelected(product: Product): boolean {
    return this.getProductIndex(product) > -1;
  }

  loadProducts() {
    this.ecommerceService.getAllProducts().subscribe(
      (products: any[]) => {
        this.products = products;
        this.products.forEach(product => {
          this.productOrders.push(new ProductOrder(product, 0));
        });
      },
      (error: any) => console.log(error)
    );
  }

  loadOrders() {
    this.sub = this.ecommerceService.OrdersChanged.subscribe(() => {
      this.shoppingCartOrders = this.ecommerceService.ProductOrders;
    });
  }

  reset() {
    this.productOrders = [];
    this.loadProducts();
    this.ecommerceService.ProductOrders.productOrders = [];
    this.loadOrders();
    this.productSelected = false;
  }
}
