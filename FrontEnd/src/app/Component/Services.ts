import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Form } from './Entity/form';
import { User } from './Entity/user';

@Injectable({
    providedIn: 'root'
})

export class Services {
    headers = new HttpHeaders({
        'Content-Type': 'application/json',
      });

      constructor(private http: HttpClient){}



        submitRequestFrom(subForm: Form): Observable<Form> {
            return this.http.post<Form>(
                'http://localhost:5001/registration/api/v1/requestForm', subForm,
                {
                    headers: this.headers,
                }
            );
        }

        registerUser(regUser: User): Observable<User> {
            return this.http.post<User>(
                'http://localhost:5001/registration/api/v1/registerUser', regUser,
                {
                    headers: this.headers,
                }
            );
        }

        fetchUserById(userId: number): Observable<User> {
          return this.http.get<User>(
            `http://localhost:5001/registration/api/v1/user/${userId}`,
          );
        }

        getRegisteredUsers(): Observable<User[]> {
            return this.http.get<User[]>(
                'http://localhost:5001/registration/api/v1/users',{
                    headers: this.headers,
                }
            );
        }

         approveUser(user : User):Observable<User>{
             return this.http.put<User>(
                 `http://localhost:5001/registration/api/v1/userWith/${user.id}`, user,
                 {
                     headers:this.headers,
                 }
            );
         }

         rejectUser(user : User):Observable<User>{
             return this.http.put<User>(
                 `http://localhost:5001/registration/api/v1/userWith`, user,
               {
                     headers:this.headers,
                 }
             );
         }


}
