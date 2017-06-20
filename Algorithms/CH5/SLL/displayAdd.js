 /**
 * Created by sushmamangalapally on 6/14/17.
 */

//object constructor -> created the instance object
function SLL(){
    this.head = null;
}


function Node(val) {
    this.val = val;
    this.next = null;
}




//"this"
//the particular instance of that object
//that is utilizing that attributes
//or method

// MAKING INSTANCES

var firstlist = new SLL();
console.log(firstlist.head)
firstlist.head = new Node(5)
console.log("firstlist.head", firstlist.head)
console.log(firstlist)
firstlist.head.next = new Node(6)
console.log("firstlist.head.next", firstlist.head.next)
console.log(firstlist)
 firstlist.head.next.next = new Node(7)
 firstlist.head.next.next.next = new Node(8)
 console.log("firstlist.head.next.next", firstlist.head.next.next)
console.log(firstlist)


//standalone functions

 function displayList(list){
    if(!list.head){
        return "Empty list";
    }
    var valuestring = "";
    var current = list.head;

    while(current){ //as long it's not null
        valuestring += current.val + ", ";
        current = current.next
    }

    return valuestring
 }

 console.log("Display!: ", displayList(firstlist))

 function addFronttoList(list, value){
     var newnode = new Node(value);
     if(!list.head){
         list.head = newnode
         return list
     }
     else{
         newnode.next = list.head;
         list.head = newnode;
     }
     return list
 }

 addFronttoList(firstlist, 1)
  console.log(displayList(firstlist))

 function getNodeBeforeLast(list){

         var current = list.head;
         while(current.next.next != null) {
             current = current.next;
         }
     return current;
 }

 function addBackLecture(list, value){

     if(!list.head){
         var temp = new Node(value);
         list.head = temp;
         return;
     }
     else{
        var current = getNodeBeforeLast(list);
        var newnode = new Node(value);
         current = current.next;
         current.next = newnode;
     }

 }


 function addBacktoList(list, value){
     var newnode = new Node(value);
     if(!list.head){
         list.head = newnode
         return list
     }
     else{
         var current = list.head;
         //newnode.next = current;
         while(current.next != null){
             //console.log(current.val);
             current = current.next;
         }
         //console.log("oh", current.val)
         current.next = newnode
     }
     return list
 }


  console.log(addBacktoList(firstlist, 9))
 addBacktoList(firstlist, 10)
  console.log(displayList(firstlist))

  var secondList = new SLL();
 addBackLecture(secondList, 40)
 console.log(displayList(secondList))


 function SLLlecture(){
    this.head = null;
    this.addFronttothisList = function(value){
        var temporary = new Node(value)
        temporary.next = this.head;
        this.head = temporary;
    }
    this.addBacktothisList = function(value){
        var temporary = new Node(value)
         var current = this.head;
        if(!this.head){
            this.head = temporary
        }
        else{
             while(current.next != null){
                 current = current.next;
             }
             //console.log("oh", current.val)
             current.next = temporary
         }
         return this

     }
}

var newlist = new SLLlecture()
 newlist.addFronttothisList("Joe")
 newlist.addFronttothisList("Bob")
 newlist.addBacktothisList("Kat")

 console.log(displayList(newlist))