// Demonstrating basic file handling

const fs = require("fs");
const path = require("path");

// Define file path
const filepath = path.join(__dirname, 'example2.txt');

// create and write to a file
fs.writeFile(filepath, "This is a demonstration of basic file path operations", (err) => {
    if(err){
        console.error("Error occured while writing file");
    }
    console.log("File Created and written successfully");
});


// Read the file
fs.readFile(filepath, 'utf-8', (err,data)=>{
    if(err){
        console.error("Error occured while reading file:" + err);
        return;
    };
    console.log("Reading File:" + data);
});


//Append data to the file
fs.appendFile(filepath, '\n Appending some more content',(err) => {
    if(err){
        console.error("Error occured while appending file");
    }
    console.log("File Created and written successfully");
});

//Read the updated file
fs.readFile(filepath, 'utf-8', (err,data)=>{
    if(err){
        console.error("Error occured while reading file:" + err);
        return;
    };
    console.log("Reading File:" + data);
});

// Rename the file
const newFilePath = path.join(__dirname, 'rename_example2.txt' );
fs.rename(filepath, newFilePath, (err)=>{
    if(err){
        console.log("Error while renaming:" + err)
    }
});
console.log("File Renamed");

//Delete the file
fs.unlink(newFilePath, (err)=>{
    if(err){
        console.error("Error while deleting file")
    }
});
console.log("File deleted Successfully");
console.log('File Handling operation completed');