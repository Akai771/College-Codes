function simpleFunction(){
    console.log("This is a simple function!!!")
}

function nameFunction(name){
    console.log("Hello, " + name)
}

function addFunction(a,b){
    console.log(a + b)
}

function swapFunction(a,b){
    let temp = a;
    a = b;
    b = temp;
    console.log("A", a);
    console.log("B", b);
}

//Store Values Function
function storeValues(value){
    return value
}

let functionValue = storeValues("ABC");
console.log(functionValue)

const arrowFunction = () => {
    console.log("This is arrow function")
}

async function asyncFunction(){
    let wait = await arrowFunction();
    return console.log("arrow function received")
}

function callbackFunction(callback){
    return console.log("Callback Function")
}

// Anonymous Function
const number = function(num){
    console.log("num" + num)
}

simpleFunction();
nameFunction("Alice");
addFunction(1,2);
swapFunction("A", "B");
console.log(functionValue);
asyncFunction();
callbackFunction(asyncFunction);
