let s1= "Wissen";
let s2="Technology";
var promise=new Promise(function(resolved,rejected){
    if((s1+s2)==="WissenTechnology"){
        resolved("Employee Object"); 
    }
    else{
        rejected();
    }
});
promise
    .then(
        (val)=>{
            console.log("Best place to work 1");
            console.log("Got : "+val);
            return "Staff feedback"; //returning value to next then block else it will be undefined
        },  //if resolved
        ()=>{
            console.log("There is some spelling mistake");
            throw new Error("'o' is missing in 'Technology'");
        }  //if rejected
    )  //you can have multiple then blocks
    .then(
        (val)=>{
            console.log("Best place to work 2");
            console.log("Got : "+val); //'Staff feedback' is the value returned from previous then block
        },  //if resolved
        ()=>{
            console.log("There is some spelling mistake");
            throw new Error("'o' is missing in 'Technology'");
        }  //if rejected
    )
    .catch(
        (err)=>{
            console.log("Error handling is done here..");
            console.log("Reason: "+err.message);
        }  //if error
    )
    .finally(
        ()=>{
            console.log("Thank you :)");
        }  //finally block
    );

