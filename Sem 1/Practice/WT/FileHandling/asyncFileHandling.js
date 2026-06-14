const fs = require("fs");
const filepath = "example.txt"

fs.writeFile(filepath, "This is a demonstration of basic file path operations", (err)=>{
    if(err){
        console.error("Error occured while creating a file")
    }
    console.log("File created and written successfully");
})

fs.readFile(filepath, 'utf-8', (err,data)=>{
    if(err){
        console.error("Error occured while reading a file")
    }
    console.log("Reading File: " + data);
})

fs.appendFile(filepath, '\nAppending Some more content', (err)=>{
    if(err){
        console.error("Error occured while appending a file")
    }
    console.log("File appended successfully");
})

fs.readFile(filepath, 'utf-8', (err,data)=>{
    if(err){
        console.error("Error occured while reading a file")
    }
    console.log("Reading File: " + data);
})

const newFilePath = "rename_example.txt"
fs.rename(filepath, newFilePath, (err)=>{
    if(err){
        console.error("Error occured while renaming a file")
    }
    console.log("File renamed successfully");
})

fs.unlink(newFilePath, (err)=>{
    if(err){
        console.error("Error occured while deleting a file")
    }
    console.log("File Deleted successfully");
})