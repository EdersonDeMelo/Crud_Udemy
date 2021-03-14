import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Cliente } from './clientes/cliente';
@Injectable({
  providedIn: 'root'
})
export class ClientesService {
  constructor(private http: HttpClient) {

  }
  salvar(cliente: any): Observable<any> {
    return this.http.post<any>("http://localhost:8080/api/clientes", cliente);
  }
  getClientes(): Observable<[]> {
    return this.http.get<[]>('http://localhost:8080/api/clientes');
  }


}
