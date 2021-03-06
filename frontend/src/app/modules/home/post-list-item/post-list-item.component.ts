import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-post-list-item',
  templateUrl: './post-list-item.component.html',
  styleUrls: ['./post-list-item.component.scss']
})
export class PostListItemComponent implements OnInit {

  @Input() postLink: string;
  @Input() title: string;
  @Input() votesCount: number;
  @Input() addedDate: Date;
  @Input() subtitle = '';

  constructor() { }

  ngOnInit(): void {
  }

}
