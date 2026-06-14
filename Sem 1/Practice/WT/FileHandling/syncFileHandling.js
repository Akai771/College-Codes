const fs = require("fs");
const filePath = "example2.txt";

// fs.writeFileSync(filePath, "This is a demonstration of basic file path operations", 'utf-8');
// console.log("File Created Successfully");

// const read = fs.readFileSync(filePath, "utf-8");
// console.log(read);

// fs.appendFileSync(filePath, '\nAppending some more content');
// console.log("file appended successfully");

// const appendRead = fs.readFileSync(filePath,"utf-8");
// console.log(appendRead);

const newFilePath = 'rename_example2.txt'
// fs.renameSync(filePath, newFilePath);
// console.log("File renamed")

fs.unlinkSync(newFilePath);
console.log("File deleted Successfully");