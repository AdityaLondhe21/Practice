class Emp{
    private name: string;
    private age: number;
    constructor(name:string, age:number){
        this.name = name;
        this.age = age;
    }
    display():void{
        console.log(`Name: ${this.name} and Age: ${this.age}`);
    }
}
var e1 = new Emp("John", 30);
var e2 = new Emp("Doe", 40);
e1.display();
e2.display();

export class Clerk extends Emp{
    salary: number;
    designation: string;
    constructor(name:string,age:number,salary:number,designation:string){
        super(name,age);
        this.salary = salary;
        this.designation = designation;
    }
    display():void{
        super.display();
        console.log(`Salary: ${this.salary} and Designation: ${this.designation}`);
    }
}

var c1 = new Clerk("John", 30, 30000, "Manager");
var c2 = new Clerk("Doe", 40, 40000, "CEO");
c1.display();
c2.display();

console.log("-------------------");

class A{
    constructor(){
        console.log("A class constructor");
    }
}
class B extends A{
    constructor(){
        super();
        console.log("B class constructor");
    }
}
var a1=new B();

console.log("-------------------");

interface Car{
    speed: number;
    accelerate(): void;
    brake():void;
}
class Hatchback implements Car{
    speed: number =0 ;
    accelerate(): void {
        console.log("Accelerator :"+ ++this.speed);
    }
    brake(): void {
        console.log("Brake :"+ --this.speed);
    }
}
let h1=new Hatchback();
h1.accelerate();
h1.accelerate();
h1.brake();

console.log("-------------------");

interface CarProperties{
    company: string;
    model: string;
    price: number;
    gear?:boolean;
}
let m1: CarProperties = {"company":"Maruti","model":"Swift","price":500000};
let m2: CarProperties = {"company":"Hyundai","model":"i20","price":600000,"gear":true};

console.log("-------------------");

let arr1:number[] = [1,2,3,4,5];
let arr2:Array<number> = [1,2,3,4,5]; //Preferred

console.log("-------------------");

var a=10;
var b=20;
console.log(`The sum of ${a} and ${b} is ${a+b}`);

console.log("-------------------");

function add(a=0,b=0){
    console.log(`The sum of ${a} and ${b} is ${a+b}`);
}

add(10,20);
add(10);
add();

console.log("-------------------");

class Person{
    name: string;
    constructor(name:string){
        console.log("Start of Person class constructor");
        this.name = name;
        setTimeout(()=>console.log(`Person class constructor ${this.name}`),5000);
        console.log("End of Person class constructor");
    }
}
new Person("John");
console.log("End of Person class object creation");

console.log("-------------------");








