const http = require('http');

http.createServer((req, res) => {
    res.writeHead(200, { 'Content-Type': 'text/plain' });
    
    const responses = {
        GET: "This is a GET request!",
        PUT: "This is a PUT request!",
        DELETE: "This is a DELETE request!"
    };

    if (req.method === "POST") {
        let body = "";
        req.on("data", chunk => body += chunk.toString());
        req.on("end", () => res.end("Received POST data: " + body));
    } else {
        res.end(responses[req.method] || "Unsupported request method: " + req.method);
    }
}).listen(3000, () => console.log("Server running at http://localhost:3000"));