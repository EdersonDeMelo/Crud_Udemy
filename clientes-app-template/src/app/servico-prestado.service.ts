import { Injectable } from '@angular/core';
import { environment } from '../environments/environment'
import { HttpClient } from '@angular/common/http';
import { ServicoPrestado } from './servico-prestado/servico-prestado';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ServicoPrestadoService {
  apiURL: string = environment.apiURLBase + "api/servicos-prestados"
  constructor(private http: HttpClient) { }

  salvar(servicoPrestado: ServicoPrestado): Observable<any> {
    return this.http.post<ServicoPrestado>(this.apiURL, servicoPrestado);
  }
}
