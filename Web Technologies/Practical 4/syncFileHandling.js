// Demonstrating basic file handling

const fs = require("fs");
const path = require("path");

// Define file path
const filepath = path.join(__dirname, 'example.txt');

// create and write to a file
fs.writeFileSync(filepath, "This is a demonstration of basic file path operations", "utf-8");
console.log("File Created and writte successfully");

// Read the file
const read = fs.readFileSync(filepath, "utf-8",);
console.log(read);

//Append data to the file
fs.appendFileSync(filepath, '\n Appending some more content');
console.log("Content appended to the file");

//Read the updated file
const appendRead = fs.readFileSync(filepath, "utf-8",);
console.log(appendRead);

// Rename the file
const newFilePath = path.join(__dirname, 'rename_example.txt' );
fs.renameSync(filepath, newFilePath);
console.log("File Renamed");

//Delete the file
fs.unlinkSync(newFilePath);
console.log("File deleted Successfully");
console.log('File Handling operation completed');
