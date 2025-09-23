// create a application to demonstrate various nodejs events

const EventEmitter = require("events");
const eventEmitter = new EventEmitter();

eventEmitter.on("greet", (name) =>{
    console.log(`Hello ${name}`)
});

eventEmitter.on("data_received", ()=>{
    console.log("Data has been successfully received")
});

eventEmitter.once('start', ()=>{
    console.log("Application has started")
});

eventEmitter.emit('start');
eventEmitter.emit('greet','alice');
eventEmitter.emit('greet','bob');
eventEmitter.emit('data_received');
eventEmitter.emit('data_received');

//Demonstrating Remove Listener
const farewell=(name)=>{
    console.log(`Goodbye, ${name}`)
}

eventEmitter.on("farewell",farewell);
eventEmitter.emit("farewell", 'alice');

// Removing Listener for farewell
eventEmitter.removeListener("farewell", farewell);
eventEmitter.emit("farewell",'bob')

// error handling
eventEmitter.on("error", (err) =>{
    console.error(`An error has occured`)
})

// emiting an error
try{
    eventEmitter.emit("error", new error("Something went wrong"))
}
catch(err){
    console.error(`Unhandled Error: ${err.message}`)
}

console.log("Node.js Event demonstration has completed");