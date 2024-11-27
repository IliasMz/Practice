import { Component } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-products',
  standalone: false,

  templateUrl: './products.component.html',
  styleUrl: './products.component.css'
})
export class ProductsComponent {
  constructor(private http: HttpClient) {
  }
/*  ngOnInit() {
    this.http.get('https://api.example.com/products').subscribe(data => {
      this.products = data;
    });*/
  }

}
