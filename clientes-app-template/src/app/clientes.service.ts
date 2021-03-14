import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ClientesService {
  constructor(private http: HttpClient) {

  }
  salvar(cliente: any): Observable<any> {
    return this.http.post<any>("http://localhost:8080/api/clientes", cliente);
  }
}
