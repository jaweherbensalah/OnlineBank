import { Component, OnInit } from '@angular/core';
import { ReclamationService } from '../reclamation.service';
import { Reclamation } from '../reclamation';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from '../product';
import { ProductService } from '../product.service';
@Component({
  selector: 'app-traiter-reclamation',
  templateUrl: './traiter-reclamation.component.html',
  styleUrls: ['./traiter-reclamation.component.css']
})
export class TraiterReclamationComponent implements OnInit {
  url='../assets/images/capture.PNG'
  id: number;
  employee: Reclamation = new Reclamation();
  constructor(private employeeService: ReclamationService,
    private route: ActivatedRoute,
    private router: Router,
    private prodService: ProductService,) { }
    products: Product[];
    private getProductslist(){
      this.prodService.getProducts().subscribe(data => {
        this.products = data;
      });
    }

  ngOnInit(): void {
    this.getProductslist();
    this.id = this.route.snapshot.params['id'];

    this.employeeService.getEmployeeById(this.id).subscribe(data => {
      this.employee = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.employeeService.traiterRec(this.id, this.employee).subscribe( data =>{
      this.goToEmployeeList();
    }
    , error => console.log(error));
  }

  goToEmployeeList(){
    this.router.navigate(['/reclamation-admin']);
  }
}
