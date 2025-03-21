let emp1 = {"name":"Prakash","age":35,"salary":60000,"designation":"Tester"};
let emp2 = ["Suman",25,50000,"Developer"];

//Destructuring
// of Object
let {name,age,salary,designation,address="Pune"} = emp1;  
// of array
let [a_name,a_age,a_salary,a_designation, a_address="Pune"] = emp2;

console.log("Name: "+ name);
console.log("Age: "+age);
console.log("Salary: "+salary);
console.log("Designation: "+designation);
console.log("Address: "+ address)

console.log("Name: "+ a_name);
console.log("Age: "+a_age);
console.log("Salary: "+a_salary);
console.log("Designation: "+a_designation);
console.log("Address: "+ a_address)

// Spread Operator / De-structuring of multiple arrays
let arr1 = [1,2,3];
let arr2 = [4,5,6,7];
let arr3 = [8,9,10];
let arr = [...arr1,...arr2,...arr3];
