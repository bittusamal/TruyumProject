import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { AuthenticationService } from 'src/app/authentication.service';

@Component({
  selector: 'app-food-item',
  templateUrl: './food-item.component.html',
  styleUrls: ['./food-item.component.css']
})
export class FoodItemComponent implements OnInit {
  @Input() data: any;
  @Input() status: boolean;
  @Input() id: number;
  @Input() cartId: number;
  @Output() editEmitter: any;
  @Output() addEmitter: any;
  userRole: string = '';
  constructor(private authService: AuthenticationService) {
    this.editEmitter = new EventEmitter();
    this.addEmitter = new EventEmitter();
    this.userRole = this.authService.getUserRole();
  }

  ngOnInit() {
  }

  addtoCart(id) {
    this.addEmitter.emit(id);
  }
  editItem(id) {
    this.editEmitter.emit(id);
  }

}
