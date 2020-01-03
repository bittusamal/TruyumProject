import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MenuItemService } from 'src/app/menu-item.service';

@Component({
  selector: 'app-item-edit',
  templateUrl: './item-edit.component.html',
  styleUrls: ['./item-edit.component.css']
})
export class ItemEditComponent implements OnInit {
  editItem: any;
  id: any;
  status: any = false;
  categoryArray: any[];
  editForm: FormGroup;
  constructor(private route: ActivatedRoute,
    private menuItemService: MenuItemService) {
    this.editForm = new FormGroup({
      'name': new FormControl(""),
      'price': new FormControl(""),
      'dateOfLaunch': new FormControl(""),
      'category': new FormControl(""),
      'active': new FormControl(""),
      'freeDelivery': new FormControl("")
    })
  }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.id = params.get('id');
      this.menuItemService.getEditItem(this.id).subscribe((response) => {
        this.editItem = response;
        let activeStatus = false;
        let freeDeliveryStatus = false;
      
        if(this.editItem.active == "Yes"){
          activeStatus = true;
        }
        if(this.editItem.freeDelivery == "Yes"){
          freeDeliveryStatus = true;
        }

        this.editForm = new FormGroup({
          'name': new FormControl(this.editItem.name, [Validators.required, Validators.minLength(3)]),
          'price': new FormControl(this.editItem.price, [Validators.required]),
          'dateOfLaunch': new FormControl(this.editItem.dateOfLaunch, [Validators.required]),
          'category': new FormControl(this.editItem.category),
          'active': new FormControl(activeStatus),
          'freeDelivery': new FormControl(freeDeliveryStatus)
        })
      })
    })

  }
  edit(formValue) {

    let activeStatus = "No";
    let freeDeliveryStatus = "No";
    
    if(formValue.active == true){
      activeStatus = "Yes";
    }
    if(formValue.freeDelivery == true){
      freeDeliveryStatus = "Yes";
    }

    let updateItem: any = {
      id: this.id,
      name: formValue.name,
      price: formValue.price,
      dateOfLaunch: formValue.dateOfLaunch,
      category: formValue.category,
      active: activeStatus,
      freeDelivery: freeDeliveryStatus,
      image: this.editItem.image
    }
    this.menuItemService.editMenuItem(updateItem).subscribe(response => {
      if(response != null){
        this.status = true;
      }
    })
  }


}
