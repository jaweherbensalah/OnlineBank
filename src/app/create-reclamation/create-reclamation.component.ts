import { Component, OnInit } from '@angular/core';
import { Reclamation } from '../reclamation';
import { ReclamationService } from '../reclamation.service';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';
import { Product } from '../product';

@Component({
  selector: 'app-create-reclamation',
  templateUrl: './create-reclamation.component.html',
  styleUrls: ['./create-reclamation.component.css']
})
export class CreateReclamationComponent implements OnInit {

employee: Reclamation = new Reclamation();
  constructor(private employeeService: ReclamationService,
    private prodService: ProductService,
  private router: Router)
   { }
  userFile;
  public imagePath;
  imgURL: any;
  public message: string;
  products: Product[];
  private getProductslist(){
    this.prodService.getProducts().subscribe(data => {
      this.products = data;
    });
  }

  ngOnInit(): void {
    this.getProductslist();
   
  }

  saveEmployee(){
    this.employeeService.createEmployee(this.employee).subscribe( data =>{
      console.log(data);
      this.goToEmployeeList();
    },
    error => console.log(error));
  }

  goToEmployeeList(){
    this.router.navigate(['/reclamations']);
  }
  
  onSubmit(){
    console.log(this.employee);
    this.saveEmployee();
  }
  onSelectFile(event){
    if(event.target.files.length >0){
      const file =event.target.files[0];
      this.userFile=file;
      //this.
      var mimeType=event.target.files[0].type;
      if (mimeType.match(/image\/*/)==null){
        this.message="only images are suppported";

      }
      var reader =new FileReader();
      this.imagePath=file;
      reader.readAsDataURL(file);
      reader.onload=(event) =>
      {
        this.imgURL=reader.result;
        
      }
    }
  }

}
