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
  atualizar(cliente: any): Observable<any> {
    return this.http.put<any>(`http://localhost:8080/api/clientes/${cliente.id}`, cliente);
  }
  getClientes(): Observable<[]> {
    return this.http.get<[]>('http://localhost:8080/api/clientes');
  }
  getClienteById(id: number): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/api/clientes/${id}`);
  }
  deletar(cliente: Cliente): Observable<any> {
    return this.http.delete<any>(`http://localhost:8080/api/clientes/${cliente.id}`);
  }
}
