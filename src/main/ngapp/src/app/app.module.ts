import {NgModule}      from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule}   from '@angular/forms';
import { HttpModule }    from '@angular/http';
import { SpinnerComponentModule } from 'ng2-component-spinner';

// App is our top level component

import {AppComponent}  from './app.component';
import {AdmFrameworkComponent} from "./framework/adm-framework.component";
import {AdmContentComponent} from "./content/adm-content.component";
import {AdmSideBarComponent} from "./sidebar/adm-sidebar.component";
import {AdmHeaderComponent} from "./header/adm-header.component";

import {AdmSideBarUserComponent} from "./sidebar/adm-sidebar-user.component";
import {AdmSidebarSwitchDirective} from "./shared/directives/adm-sidebar-switch.directive";
import {AdmStatusService} from "./shared/services/adm-status.service";
import {AdmService} from "./shared/services/adm-http.service";
import {RemoveHostDirective} from "./shared/directives/remove-host.directive";
import {AdmHeaderUserComponent} from "./header/adm-header-user.component";
import {AdmSideBarTreeViewComponent} from "./sidebar/adm-sidebar-treeview.component";
import {
  AdmDropDownDirective,
  AdmDropDownMenuDirective,
  AdmDropDownToggleDirective
} from "./shared/directives/adm-dropdown.directive";

// Application wide providers
const APP_PROVIDERS = [
  AdmStatusService,
  AdmService
];

/**
 * `AppModule` is the main entry point into Angular2's bootstraping process
 */
@NgModule({
  bootstrap: [AppComponent], // bootstrap component.
  declarations: [ // components and directives
    AppComponent,
    AdmContentComponent,
    AdmFrameworkComponent,

    AdmSideBarComponent,
    AdmSideBarUserComponent,
    AdmSideBarTreeViewComponent,


    AdmHeaderComponent,
    AdmHeaderUserComponent,



    AdmSidebarSwitchDirective,
    RemoveHostDirective,
    AdmDropDownDirective,
    AdmDropDownMenuDirective,
    AdmDropDownToggleDirective

  ],
  imports: [ // import Angular's modules
    BrowserModule,
    RouterModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpModule,
    SpinnerComponentModule
  ],
  exports: [ // exported components and directives
    AppComponent,
    AdmContentComponent,
    AdmFrameworkComponent,
    AdmHeaderComponent,
    AdmSideBarUserComponent,
    AdmSidebarSwitchDirective,
  ],
  providers: [ // expose our Services and Providers into Angular's dependency injection
    APP_PROVIDERS
  ]
})
export class AppModule {
}
