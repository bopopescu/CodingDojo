import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';

@Injectable()
export class CommunicateService {
  observedUsers = new BehaviorSubject(null);
  updateUsers(users) {
    this.observedUsers.next(users);
  }

  constructor() { }

}
