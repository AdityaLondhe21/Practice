var increment = function incr(){
    var a=0;
    var plus = function(){
        console.log(++a);
    }
    return plus;
}();  //self invoking function
increment(); //1
increment(); //2
increment(); //3
increment(); //4
increment(); //5

console.log("====================================");

