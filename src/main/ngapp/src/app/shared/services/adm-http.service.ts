import { Injectable }    from '@angular/core';
import { Headers, Http , RequestOptions, URLSearchParams} from '@angular/http';

import 'rxjs/add/operator/toPromise';

import {User} from "../models/User";
import {AdmSideBarTreeItem} from "../models/AdmSideBarTreeItem";
 
@Injectable()
export class AdmService {
 
  
  private usernameUrl = '/Plataforma/restresources/info/username';
  private menuJsonUrl = '/Plataforma/restresources/menu/jsonMenu';  
  private menuPersonalUrl = '/Plataforma/restresources/menu/jsonMenuPersonal';  
  private consultMenuUrl = '/Plataforma/restresources/menu/consultMenu';
 
  constructor(private http: Http) { }

 
  getUserInfo(): Promise<User> {  	
    return this.http.get(this.usernameUrl)
               .toPromise()
               .then(response => response.json() as User)
               .catch(this.handleError);
  }
  
  constructMenu(): Promise<AdmSideBarTreeItem[]> {
      return this.http.get(this.menuJsonUrl)
                 .toPromise()
                 .then(response => response.json() as AdmSideBarTreeItem[])
                 .catch(this.handleError);
  }
  
  constructMenuPersonal(): Promise<AdmSideBarTreeItem[]> {
      return this.http.get(this.menuPersonalUrl)
                 .toPromise()
                 .then(response => response.json() as AdmSideBarTreeItem[])
                 .catch(this.handleError);
  }
  
  consultarMenu(menu:number): void {
  let headers = new Headers({ 'Content-Type': 'application/x-www-form-urlencoded' });
  let params = new URLSearchParams();
  params.append('menu', menu.toString());  
    this.http.post(this.consultMenuUrl, params, {headers:headers})
        .toPromise()
        .then(response => { console.log(response);}, error => {console.log(error);})
        .catch(this.handleError);
  }
 
  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}
