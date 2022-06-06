
  import { Component, OnInit } from '@angular/core';
  import { ReclamationService } from '../reclamation.service';
  import { Reclamation } from '../reclamation';
  import { ActivatedRoute, Router } from '@angular/router';
import { Product } from '../product';
import { ProductService } from '../product.service';
  
@Component({
  selector: 'app-update-reclamation',
  templateUrl: './update-reclamation.component.html',
  styleUrls: ['./update-reclamation.component.css']
})
export class UpdateReclamationComponent implements OnInit {
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
    this.employeeService.updateEmployee(this.id, this.employee).subscribe( data =>{
      this.goToEmployeeList();
    }
    , error => console.log(error));
  }

  goToEmployeeList(){
    this.router.navigate(['/reclamations']);
  }
}
