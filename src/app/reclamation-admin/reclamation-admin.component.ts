import { Component, OnInit } from '@angular/core';
import { Reclamation } from '../reclamation';
import { ReclamationService } from '../reclamation.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-reclamation-admin',
  templateUrl: './reclamation-admin.component.html',
  styleUrls: ['./reclamation-admin.component.css']
})
export class ReclamationAdminComponent implements OnInit {

  url='../assets/images/capture.PNG'
  Reclamations:Reclamation [];
  form: any = {};
  errorMessage = '';
  cols: any[];
  constructor(private recS: ReclamationService, private router: Router) { }

  ngOnInit(): void {
    this.getEmployees();
    this.recS.getRecs().subscribe(res=>{console.log(res);
      this.Reclamations=res});
      this.cols = [
        { field: 'id', header: 'Id' },
        { field: 'titre', header: 'Titre' },
        { field: 'contenu', header: 'Contenu' },
        { field: 'date_creation', header: 'Date de création' },
        { field: 'date_modif', header: 'Date de modification' },
        { field: 'status', header: 'Status' },
    ];
  }
  private getEmployees(){
    this.recS.getEmployeesList().subscribe(data => {
      this.Reclamations = data;
    });
  }
  onSubmit(): void {

  }
  employeeDetails(id: number){
    this.router.navigate(['reclamation-details', id]);
  }

  deleteEmployee(id: number){
    this.recS.deleteEmployee(id).subscribe( data => {
      console.log(data);
      this.getEmployees();
    })
  }
  updateEmployee(id: number){
    this.router.navigate(['traiter-reclamation', id]);
  }
}
