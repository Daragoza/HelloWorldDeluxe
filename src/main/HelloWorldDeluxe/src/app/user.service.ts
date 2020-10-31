import { Injectable } from '@angular/core';
import {User} from "./user";
import {Observable, of, Subject} from "rxjs";
import {catchError} from "rxjs/operators";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {
  }

  //The 'proxy' part of the URL is resolved by the proxy.conf.json file when starting the server in developer mode (using npm start)
  //this may need to be changed when the app is running in production mode
  private url = "proxy/registration/users";


  public addUserSource$: Subject<User> = new Subject();


  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };


  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.url).pipe(
        catchError(this.handleError<User[]>('getUsers', []))
      )
  }

  addUser(user: User): Observable<User> {
    return this.http.post<User>(this.url, user, this.httpOptions).pipe(
      catchError(this.handleError<User>('addUser'))
    )
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }

}
