import { Component, OnInit } from '@angular/core';
import { Reclamation } from '../reclamation';
import { ActivatedRoute } from '@angular/router';
import { ReclamationService } from '../reclamation.service';


@Component({
  selector: 'app-reclamation-details',
  templateUrl: './reclamation-details.component.html',
  styleUrls: ['./reclamation-details.component.css']
})
export class ReclamationDetailsComponent implements OnInit {
  url='../assets/images/capture.PNG'
  id: number
  employee: Reclamation
  constructor(private route: ActivatedRoute, private employeService: ReclamationService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.employee = new Reclamation();
    this.employeService.getEmployeeById(this.id).subscribe( data => {
      this.employee = data;
    });
  }
 
}
