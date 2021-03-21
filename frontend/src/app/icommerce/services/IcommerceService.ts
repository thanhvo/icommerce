import { ProductOrder } from '../models/product-order.model';
import { Subject } from 'rxjs/internal/Subject';
import { ProductOrders } from '../models/product-orders.model';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from '../models/product.model';

@Injectable()
export class IcommerceService {
  private productsUrl = '/api/products';
  private ordersUrl = '/api/orders';

  private productOrder: ProductOrder;
  private orders: ProductOrders = new ProductOrders();

  private productOrderSubject = new Subject();
  private ordersSubject = new Subject();
  private totalSubject = new Subject();

  private total: number;

  ProductOrderChanged = this.productOrderSubject.asObservable();
  OrdersChanged = this.ordersSubject.asObservable();
  TotalChanged = this.totalSubject.asObservable();

  constructor(private http: HttpClient) {
    this.productOrder = new ProductOrder(
      new Product(0, '', 0, 'image.local'),
      0
    );
    this.total = 0;
  }

  getAllProducts() {
    return this.http.get(this.productsUrl);
  }

  search(keyword: string) {
    return this.http.get(`${this.productsUrl}?keyword=${keyword}`);
  }

  saveProduct (product: Product) {
    return this.http.post(this.productsUrl, product);
  }

  saveOrder(order: ProductOrders) {
    return this.http.post(this.ordersUrl, order);
  }

  set SelectedProductOrder(value: ProductOrder) {
    this.productOrder = value;
    this.productOrderSubject.next();
  }

  get SelectedProductOrder() {
    return this.productOrder;
  }

  set ProductOrders(value: ProductOrders) {
    this.orders = value;
    this.ordersSubject.next();
  }

  get ProductOrders() {
    return this.orders;
  }

  get Total() {
    return this.total;
  }

  set Total(value: number) {
    this.total = value;
    this.totalSubject.next();
  }
}
