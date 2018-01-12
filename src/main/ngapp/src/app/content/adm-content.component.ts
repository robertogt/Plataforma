/**
 * Created by zml on 2016/9/4.
 */

import {Component, ViewEncapsulation, Input} from "@angular/core";

@Component({
  selector: 'adm-content',
  templateUrl: './adm-content.component.html',
  encapsulation: ViewEncapsulation.None
})
export class AdmContentComponent {
	@Input() stringUrl: any;
}
