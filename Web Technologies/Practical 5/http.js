const http = require('http');
const port = 3000;

const server = http.createServer((req, res) => {
    // Set response header
    res.writeHead(200, { 'Content-Type': 'text/plain' });

    // Handle GET request
    if (req.method === "GET") {
        res.end("This is a GET request!");
    }

    // Handle POST request
    else if (req.method === "POST") {
        let body = "";

        // Collect POST data
        req.on("data", chunk => {
            body += chunk.toString();
        });

        req.on("end", () => {
            res.end("Received POST data: " + body);
        });
    }

    // Handle PUT request
    else if (req.method === "PUT") {
        res.end("This is a PUT request!");
    }

    // Handle DELETE request
    else if (req.method === "DELETE") {
        res.end("This is a DELETE request!");
    }

    // Default response
    else {
        res.end("Unsupported request method: " + req.method);
    }
});

server.listen(port, () => {
    console.log("Server running at http://localhost:" + port);
});