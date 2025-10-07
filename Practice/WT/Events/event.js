const EventEmitter = require("events");
const eventEmitter = new EventEmitter();

eventEmitter.once('start', ()=>{
    console.log("Application Started!!!")
})

eventEmitter.on("hello", (name)=>{
    console.log("Server started for " + name);
})

eventEmitter.emit('start');
eventEmitter.emit('hello', 'ABC')




const farewell=(name)=>{
    console.log(`Goodbye, ${name}`)
}

eventEmitter.on("farewell",farewell);
eventEmitter.emit("farewell", 'alice');

// Removing Listener for farewell
eventEmitter.removeListener("farewell", farewell);
eventEmitter.emit("farewell",'bob')