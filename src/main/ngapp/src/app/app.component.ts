import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {AdmStatusService} from './shared/services/adm-status.service';
import {AdmService} from './shared/services/adm-http.service';
import {User} from "./shared/models/User";
import {AdmSideBarTreeItem} from "./shared/models/AdmSideBarTreeItem";


@Component({
  selector: 'app',
  encapsulation: ViewEncapsulation.None,
  templateUrl: './app.component.html',
  styles: [
    './app.component.css'
  ]
})
export class AppComponent implements OnInit {
  showLoader : boolean;
  private loginUser:User;
  private treeViewItems:AdmSideBarTreeItem[];
  private personalTreeView:AdmSideBarTreeItem[];
   val : boolean;
   val2 : boolean;

  constructor(private statusService:AdmStatusService,
              private httpService: AdmService) {
  }

  getUser():void{
      this.httpService
      .getUserInfo()
      .then(user => this.loginUser = user);
  }

  getMenu():void{
    this.val = true;
    this.showLoader = true;
    this.httpService
    .constructMenu()
    .then(menu => {        
        this.treeViewItems = menu;
        this.val = false;
        if(!this.val2){
            this.showLoader = false;
        }        
    });
  }
  
  getMenuPersonal():void {  
    this.val2 = true;
    this.showLoader = true;
    this.httpService
    .constructMenuPersonal()
    .then(menu => {                
                this.personalTreeView = menu;
                this.val2 = false;
                if(!this.val){
                    this.showLoader = false;
                }
    })
  }

  ngOnInit():void {
    this.val = false;
    this.val2 = false;
    this.showLoader = false;
    this.loginUser = new User();
    this.getUser();
    this.getMenu();
    this.getMenuPersonal();
  }


}
