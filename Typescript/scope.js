function abc()
{
    {
        a = 10;     // a is global
        var b = 20; // var is function scoped
        let c = 30; // let is block scoped
        console.log("From inside inner block abc() - c: "+c);
    }
    console.log("From inside abc() - a: "+a);
    console.log("From inside abc() - b: "+b);
    console.log("From inside abc() - c: "+c);

}
abc();
console.log("From outside abc() - a: "+a);
console.log("From outside abc() - b: "+b);
console.log("From outside abc() - c: "+c);

//Output 
//From inside inner block abc() - c: 30
//From inside abc() - a: 10
//From inside abc() - b: 20
//From inside abc() - c: undefined
//From outside abc() - a: 10
//From outside abc() - b: undefined
//From outside abc() - c: undefined