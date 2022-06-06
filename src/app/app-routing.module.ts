import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { BoardUserComponent } from './board-user/board-user.component';
import { BoardModeratorComponent } from './board-moderator/board-moderator.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { PasswordComponent } from './password/password.component';
import { ReclamationListComponent } from './reclamation-list/reclamation-list.component';
import { CreateReclamationComponent } from './create-reclamation/create-reclamation.component';
import { UpdateReclamationComponent } from './update-reclamation/update-reclamation.component';
import { ReclamationDetailsComponent } from './reclamation-details/reclamation-details.component';
import { ReclamationAdminComponent } from './reclamation-admin/reclamation-admin.component';
import { TraiterReclamationComponent } from './traiter-reclamation/traiter-reclamation.component';

const routes: Routes = [
  {path: 'reclamations', component: ReclamationListComponent},
  {path: 'create-reclamation', component: CreateReclamationComponent},
  {path: 'update-reclamation/:id', component: UpdateReclamationComponent},
  {path: 'reclamation-details/:id', component: ReclamationDetailsComponent},
  {path: 'update-reclamation/:id', component: UpdateReclamationComponent},
  {path: 'reclamation-admin', component: ReclamationAdminComponent},
  {path: 'traiter-reclamation/:id', component: TraiterReclamationComponent},
  { path: 'home', component: HomeComponent },
  { path: 'password', component: PasswordComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'user', component: BoardUserComponent },
  { path: 'mod', component: BoardModeratorComponent },
  { path: 'admin', component: BoardAdminComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
