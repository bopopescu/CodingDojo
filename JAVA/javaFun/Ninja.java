class Ninja extends Person{
    Ninja(){
        this.energy = 70;
        this.name = "Ninja";
    }
    void sayHello(){
        //super.sayHello();
        System.out.println("Hi from Ninja of Person");
    }
}