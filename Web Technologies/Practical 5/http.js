const http = require('http');
const url = require('url');
const fs = require('fs');
const path = require('path');

const port = 3000;

const server = http.createServer((req,res)=>{
    const parsedUrl = url.parse(req.url, true);
    const pathname = parsedUrl.pathname;
    console.log(req.method);
    if (pathname === "/" && req.method === "GET"){
        res.writeHead(200, { 'Content-Type': 'text/plain' });
        res.end('Welcome to node.js HTTP Server!!!')
    }
    else if (pathname === "/create" && req.method === "POST") {
        const filepath = path.join(__dirname, 'serverFile.txt');
        
        req.on('end', () => {
            fs.writeFileSync(filepath, body || `This file was created by HTTP Server and the server is running on port ${port}`, 'utf-8');
            
            res.writeHead(201, { 'Content-Type': 'text/plain' });
            if (fs.existsSync(filepath)) {
                res.end("File Created Successfully");
            } else {
                res.end("File Creation Unsuccessful");
            }
        });
        
        req.on('error', (err) => {
            res.writeHead(500, { 'Content-Type': 'text/plain' });
            res.end(`Error: ${err.message}`);
        });
    }
    else if (pathname === '/read' && req.method === 'GET'){
        const filepath = path.join(__dirname, 'serverFile.txt');
        if (fs.existsSync(filepath)){
            res.writeHead(200, { 'Content-Type': 'text/plain' });
            const fileText = fs.readFileSync(filepath, 'utf-8');
            res.end(fileText);
                
        }
        else{
            res.writeHead(200, { 'Content-Type': 'text/plain' });
            res.end('There is no file')
        }
    }
    else if (pathname === "/delete" && req.method === "DELETE") {
        const filepath = path.join(__dirname, 'serverFile.txt');
        if (fs.existsSync(filepath)){
            fs.unlinkSync(filepath);
            res.writeHead(200, { 'Content-Type': 'text/plain' });
            res.end("File Deleted successfully");
        }
    }
    else{
        res.writeHead(200, { 'Content-Type': 'text/plain' });
        res.end("No Results found");
    }
}).listen(port, () => {
    console.log(`Server started at http://localhost:${port}/`)
})