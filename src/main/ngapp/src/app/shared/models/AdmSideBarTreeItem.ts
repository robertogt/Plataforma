/**
 * Created by zml on 2017/3/20.
 */

/**
 * The model for side bar item.
 */
export class AdmSideBarTreeItem {

  // possible type value.
 // static readonly TYPE_HEADER:string = 'header';
  //static readonly TYPE_TREEVIEW:string = 'treeview';

  /*menu:number;
  etiqueta: string;
  path:string;
  nombreFisico:string;
  hoja:number;
  leftIcon:string;
  leftActiveIcon:string;
  rightIcon:string;
  rightActiveIcon:string;
  type:string; 
  isActive:boolean;  
  data:AdmSideBarTreeItem[];*/


  
  
  // icons.
  leftIcon:string;
  leftActiveIcon:string;
  rightIcon:string;
  rightActiveIcon:string;

  // item text.
  menu:number;
  etiqueta:string;

  // TYPE_HEADER or TYPE_TREEVIEW.
  type:string;

  // Indicate if is active status.
  isActive:boolean;

  // item children to support multilevel.
  data:AdmSideBarTreeItem[];

  hoja:number;

  path:string;
  
  nombreFisico:string;
  // clicked callback.
  clickFn:(item:AdmSideBarTreeItem)=>void;

}
