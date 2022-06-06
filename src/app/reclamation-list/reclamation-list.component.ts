
import { Component, OnInit } from '@angular/core';
import { Reclamation } from '../reclamation'
import { ReclamationService } from '../reclamation.service'
import { Router } from '@angular/router';

@Component({
  selector: 'app-reclamation-list',
  templateUrl: './reclamation-list.component.html',
  styleUrls: ['./reclamation-list.component.css']
})
export class ReclamationListComponent implements OnInit {
  url='../assets/images/capture.PNG'
  rec: Reclamation[];

  constructor(private recs: ReclamationService,
    private router: Router) { }

  ngOnInit(): void {
    this.getEmployees();
  }

  private getEmployees(){
    this.recs.getEmployeesList().subscribe(data => {
      this.rec = data;
    });
  }


  updateEmployee(id: number){
    this.router.navigate(['update-reclamation', id]);
  }
  employeeDetails(id: number){
    this.router.navigate(['reclamation-details', id]);
  }

  deleteEmployee(id: number){
    this.recs.deleteEmployee(id).subscribe( data => {
      console.log(data);
      this.getEmployees();
    })
  }
}
