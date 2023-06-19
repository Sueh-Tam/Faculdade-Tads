use('db_books');  // (1)

let books = db.getCollection('books'); // (2)
books.drop();

const fs = require('fs');
let rawdata = fs.readFileSync('./codigos/books3.json'); // (3)
let data = JSON.parse(rawdata);
console.log('Total docs carregados do arquivo: ' + data.length);

console.log('Inserindo Documentos no cloud atlas...');
books.insertMany(data);
console.log('Total Documentos inseridos: ' + books.countDocuments());