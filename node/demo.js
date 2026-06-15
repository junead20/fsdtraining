const http = require('http');
const fs = require('fs');
const server = http.createServer((req, res) => {
    if (req.url === '/') {
        res.writeHead(200, { 'Content-Type': 'text/html' });
        res.end('<h1>Welcome to the Home Page</h1>');
    }
    else if (req.url === '/add') {
        res.writeHead(200, { 'Content-Type': 'text/html' });
        const student = JSON.stringify({
            name: 'Junead',
            age: 21
        }) + '\n';
        fs.appendFile('students.txt', student, (err) => {
            if (err) {
                res.end('<h1>Error writing file</h1>');
                return;
            }
            res.end('<h1>Data added to file</h1>');
        });
    }
    else if (req.url === '/read') {
        fs.readFile('students.txt', 'utf8', (err, data) => {
            res.writeHead(200, { 'Content-Type': 'text/html' });
            if (err) {
                res.end('<h1>File not found</h1>');
                return;
            }
            res.end(`<pre>${data}</pre>`);
        });
    }
    else if (req.url === '/delete') {
        fs.unlink('students.txt', (err) => {
            res.writeHead(200, { 'Content-Type': 'text/html' });
            if (err) {
                res.end('<h1>File not found</h1>');
                return;
            }
            res.end('<h1>File deleted</h1>');
        });
    }
    else {
        res.writeHead(404, { 'Content-Type': 'text/html' });
        res.end('<h1>404 - Page Not Found</h1>');
    }
});
server.listen(3000, () => {
    console.log('Server running at http://localhost:3000/');
});