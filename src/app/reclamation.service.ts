import { Injectable } from '@angular/core';
import { Reclamation } from './reclamation';
import { Product } from './product';
import { HttpClient , HttpRequest, HttpEvent} from '@angular/common/http';
import { Observable } from 'rxjs';
import { FormBuilder, FormGroup, FormControl, ReactiveFormsModule,Validators }
from '@angular/forms';



@Injectable({
  providedIn: 'root'
})
export class ReclamationService {


  private baseURL = "http://localhost:9000/api/auth/reclamations";
  private urlTraiterRec = "http://localhost:9000/api/auth/traiter-reclamation";
  
  constructor(private httpClient: HttpClient) { }
  
  getEmployeesList(): Observable<Reclamation[]>{
    return this.httpClient.get<Reclamation[]>(`${this.baseURL}`);
  }
 
  createEmployee(employee: Reclamation): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, employee);
  }

  getEmployeeById(id: number): Observable<Reclamation>{
    return this.httpClient.get<Reclamation>(`${this.baseURL}/${id}`);
  }

  updateEmployee(id: number, employee: Reclamation): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, employee);
  }
  
  traiterRec(id: number, employee: Reclamation): Observable<Object>{
    return this.httpClient.put(`${this.urlTraiterRec}/${id}`, employee);
  }
  deleteEmployee(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }
//*********************
choixmenu : string  = 'A';
listData : Reclamation[];
public dataForm:  FormGroup; 
private baseUrl = '/api/auth/reclamations';
private baseUrl1 = '/api/saveUserServer';
host :string = "http://localhost:9000";
RetrieveRecs="http://localhost:9000/api/auth/reclamations";

getRecs():Observable<Reclamation[]>{
  return this.httpClient.get<Reclamation[]>(this.RetrieveRecs);}

getData(id: number): Observable<Object> {
  return this.httpClient.get(`${this.baseUrl}/${id}`);
}

createData(formData: FormData): Observable<any> {
  return this.httpClient.post(`${this.baseUrl}`, formData);
}

updatedata(id: number, value: any): Observable<Object> {
  return this.httpClient.put(`${this.baseUrl}/${id}`, value);
}

deleteData(id: number): Observable<any> {
 
  return this.httpClient.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
}

getAll(): Observable<any> {
 
  return this.httpClient.get(`${this.baseUrl}`);
}


uploadFile(file: File): Observable<HttpEvent<{}>> {
  const formdata: FormData = new FormData();
  formdata.append('file', file);
  const req = new HttpRequest('POST', '<Server URL of the file upload>', formdata, {
      reportProgress: true,
      responseType: 'text'
  });

  return this.httpClient.request(req);
 }



}
