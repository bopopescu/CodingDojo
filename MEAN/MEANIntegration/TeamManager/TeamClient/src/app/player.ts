export class Player {
    constructor(
        public id: number =  Math.floor(Math.random() * 9999) + 1,
        public name: string = "",
        public preferred_position: string="",
        public gameone: string="",
        public gametwo: string="",
        public gamethree: string="" 
  ){}

}
