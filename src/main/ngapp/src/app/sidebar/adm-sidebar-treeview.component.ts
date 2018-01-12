/**
 * Created by zml on 2016/4/17.
 */

import {Component, OnInit,Input} from "@angular/core";
import {AdmSideBarTreeItem} from "../shared/models/AdmSideBarTreeItem";
import {User} from "../shared/models/User";
import {animate, state, style, transition, trigger} from '@angular/animations';
import {DomSanitizer} from '@angular/platform-browser';
import {AdmService} from '../shared/services/adm-http.service';

@Component({
  selector: 'adm-sidebar-treeview',
  templateUrl: './adm-sidebar-treeview.component.html',
  animations: [
    trigger('treeItemAnimation', [
      state('slideUp', style({opacity: 0, height: 0})),
      state('slideDown', style({opacity: 1, height: '*'})),
      transition('slideUp <=> slideDown', [animate('300ms ease-out')])
    ])
  ],
  styleUrls: [
    'adm-sidebar-treeview.component.css'
  ]
})
export class AdmSideBarTreeViewComponent implements OnInit{

  @Input('items')
  items:AdmSideBarTreeItem[];
  
  @Input('personalItems')
  personalItems:AdmSideBarTreeItem[];
  
  @Input('user')
  user:User;
  
  @Input('showLoader')
  showLoader:boolean;
  
  stringUrl:any;

  constructor(private domSanitizer : DomSanitizer,
              private httpService: AdmService) { }
              
  ngOnInit():void {
    this.stringUrl = this.domSanitizer.bypassSecurityTrustResourceUrl('/Plataforma/firstView.jsp'); 
  }            
              
  /**
   * Click action handler.
   * @param event The click event.
   * @param clickedItem The clicked item.
   */
  private onClick(event, clickedItem:AdmSideBarTreeItem):void {

    // here is the event terminal, stop propagating.
    event.stopPropagation();

    // 1. temp record current status.
    let currentStatus = clickedItem.isActive;

    // 2. deactive all items.
    this.deactiveAll(this.items);
    this.deactiveAll(this.personalItems);

    // 3. switch clicked item status.
    clickedItem.isActive = !currentStatus;

    // 4. active all parent of clicked item if it is not top item.
    if (clickedItem.type !== 'treeview') {
      for (let item of this.getAllParents(clickedItem)) {
        item.isActive = true;
      }
    }

    // 5. invoke callback function.
    if (clickedItem.clickFn) {
      clickedItem.clickFn(clickedItem);
    }
  }

  /**
   *  Deactive all specified items include their children.
   * @param allItems the items to be deactived.
   */
  private deactiveAll(allItems:AdmSideBarTreeItem[]):void {
    if (!allItems) {
      return;
    }
    for (let item of allItems) {
      item.isActive = false;
      this.deactiveAll(item.data);
    }
  }

  /**
   *  Return all parents of target item from whole defined items.
   * @param targetItem The target item.
   * @returns {Array} All parent items.
   */
  private getAllParents(targetItem:AdmSideBarTreeItem):AdmSideBarTreeItem[] {
    let parents = [];
    for (let possibleItem of this.items) {
      parents = this.getParents(targetItem, possibleItem);
      if (parents.length > 0) {
        break;
      }
    }
    return parents;
  }

  /**
   *  Recursively collect all parents of target item from the possible item.
   *
   * @param targetItem The target item.
   * @param possibleItem The possible parent item.
   * @returns {Array} All parents of target item.
   */
  private getParents(targetItem:AdmSideBarTreeItem, possibleItem:AdmSideBarTreeItem):AdmSideBarTreeItem[] {

    if (!possibleItem.data) {
      return [];
    }

    let parents = [];

    // Recursively collect parents!
    for (let child of possibleItem.data) {

      // Check direct child of possible item.
      if (child === targetItem) {
        parents.push(possibleItem);
        break;
      }

      // Recursively check all child's children of possible item.
      let parentsFromChild = this.getParents(targetItem, child);
      if (parentsFromChild.length > 0) { // Means find target item from child's children.
        parents.push(possibleItem);
        parents = parents.concat(parentsFromChild);
        break;
      }
    }

    return parents;
  }

  /**
   *  Return left icon.
   *  If item.isActive and item.leftActiveIcon is available return item.leftActiveIcon,
   *  otherwise default return item.leftIcon.
   * @param item The target item.
   * @returns {string} The left icon.
   */
  private getLeftIcon(item:AdmSideBarTreeItem) {
    if (item.isActive && item.leftActiveIcon) {
      return item.leftActiveIcon;
    }
    return item.leftIcon;
  }

  /**
   *  Return right icon.
   *  If item.isActive and item.rightActiveIcon is available return item.rightActiveIcon,
   *  otherwise default return item.rightIcon.
   * @param item The target item.
   * @returns {string} The right icon.
   */
  private getRightIcon(item:AdmSideBarTreeItem):string {
    if (item.isActive && item.rightActiveIcon) {
      return item.rightActiveIcon;
    }

    if (item.rightIcon) {
      return item.rightIcon;
    }

    if (item.data && item.data.length > 0) {
      return 'fa fa-angle-left pull-right';
    }

    return "";
  }

  private viewUrl(item:AdmSideBarTreeItem){    
    //console.log('menu: '+item.menu+ ' path: '+ item.path+item.nombreFisico);   
    this.stringUrl = this.domSanitizer.bypassSecurityTrustResourceUrl(item.path+item.nombreFisico); 
    this.httpService
    .consultarMenu(item.menu);    
  }
  
  private onClickPersonal(event, clickedItem:AdmSideBarTreeItem):void {

    // here is the event terminal, stop propagating.
    event.stopPropagation();

    // 1. temp record current status.
    let currentStatus = clickedItem.isActive;

    // 2. deactive all items.
    this.deactiveAll(this.personalItems);
    this.deactiveAll(this.items);

    // 3. switch clicked item status.
    clickedItem.isActive = !currentStatus;

    // 4. active all parent of clicked item if it is not top item.
    if (clickedItem.type !== 'treeview') {
      for (let item of this.getAllParentsPersonal(clickedItem)) {
        item.isActive = true;
      }
    }

    // 5. invoke callback function.
    if (clickedItem.clickFn) {
      clickedItem.clickFn(clickedItem);
    }
  }

  /**
   *  Return all parents of target item from whole defined items.
   * @param targetItem The target item.
   * @returns {Array} All parent items.
   */
  private getAllParentsPersonal(targetItem:AdmSideBarTreeItem):AdmSideBarTreeItem[] {
    let parents = [];
    for (let possibleItem of this.personalItems) {
      parents = this.getParentsPersonal(targetItem, possibleItem);
      if (parents.length > 0) {
        break;
      }
    }
    return parents;
  }

  /**
   *  Recursively collect all parents of target item from the possible item.
   *
   * @param targetItem The target item.
   * @param possibleItem The possible parent item.
   * @returns {Array} All parents of target item.
   */
  private getParentsPersonal(targetItem:AdmSideBarTreeItem, possibleItem:AdmSideBarTreeItem):AdmSideBarTreeItem[] {

    if (!possibleItem.data) {
      return [];
    }

    let parents = [];

    // Recursively collect parents!
    for (let child of possibleItem.data) {

      // Check direct child of possible item.
      if (child === targetItem) {
        parents.push(possibleItem);
        break;
      }

      // Recursively check all child's children of possible item.
      let parentsFromChild = this.getParentsPersonal(targetItem, child);
      if (parentsFromChild.length > 0) { // Means find target item from child's children.
        parents.push(possibleItem);
        parents = parents.concat(parentsFromChild);
        break;
      }
    }

    return parents;
  }
}
