import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from './product';
import { HttpClient , HttpRequest, HttpEvent} from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpClient: HttpClient) { }
  private baseURL1 = "http://localhost:9000/api/auth/products";
  getProducts(): Observable<Product[]>{
    return this.httpClient.get<Product[]>(`${this.baseURL1}`);
  }
}
