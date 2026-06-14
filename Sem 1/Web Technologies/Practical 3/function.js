// Create an application to demostrate node js function

function simpleFunction(){
    console.log("This is a simple function");
};

function nameFunction(name){
    console.log(`Hello, ${name}`);
};

function addFunction(x , y){
    return console.log(x + y);
};

function swapValues(a, b){
    let temp = a;
    a = b;
    b = temp;
    console.log("A", a);
    console.log("B", b);
};

function storeValues(value){
    return value
};

const arrowFunction = () => {
    return console.log("Arrow Function")
}

let functionValue = storeValues("Practical 3");

async function asyncFunction(){
    let waitValue = await arrowFunction();
    return console.log("arrow function received")
}

function callbackFunction(callback) {
  return console.log("Callback Function")
}


simpleFunction();
nameFunction("Alice");
addFunction(1,2);
swapValues("A", "B");
console.log(functionValue);
asyncFunction();
callbackFunction(asyncFunction);