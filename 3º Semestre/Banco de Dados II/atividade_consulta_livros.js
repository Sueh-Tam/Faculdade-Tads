use('db_books'); 

let books = db.getCollection('books'); 

// 1) Livros com mais de 1092 (paginas)
 let pageCountQuery = books.find(
     { "pageCount": { $gt: 1092 } }
); 

//2) Listar todas as categorias existentes

    let todasCategoriasQuery = books.distinct("categories"); 
    console.log(JSON.stringify(todasCategoriasQuery, null, 2)); 

//3) Listar os tipos de status

    let todosStatusQuery = books.distinct("status");
    console.log(JSON.stringify(todosStatusQuery, null, 2)); 

//4) Listar os 5 livros com o maior número de páginas:

let livrosComMaiorQuantiaDePaginasQuery = books.find(
        {}, 
        {"title": 1, "pageCount": 1,"_id": 0}, 
    ).sort( 
        {"pageCount": -1} 
    ).limit(5); 
console.log(JSON.stringify(livrosComMaiorQuantiaDePaginasQuery.toArray(), null, 2)); 

//5) Encontrar livros sobre COBOL
    let livrosSobreCobolQuery = books.find(
        {"longDescription": {$regex: /cobol/i } },
        {"title": 1, "_id": 0} 
    );
    console.log(JSON.stringify(livrosSobreCobolQuery.toArray(), null, 2));

//6) Livros que contém no título a palavra "Development" com data de publicação a partir de 2000:

    let livrosComTituloDevelopmentPublicadosEm2000 = books.find(
        {"publishedDate.$date": { $gt: new Date("1999-12-31T23:59:59Z").toISOString() }, "title": {$regex: /development/i } },
        {"publishedDate": 1, "title": 1, "_id": 0}
    );
    console.log(JSON.stringify(livrosComTituloDevelopmentPublicadosEm2000.toArray(), null, 2));

//7) Livros publicados anteriores a 1995

    let livrosAnterioresA1995 = books.find(
        {"publishedDate.$date": { $lt: new Date("1995-01-01T00:00:00Z").toISOString() } },
        {"title": 1, "publishedDate": 1, "_id": 0}
    );
    console.log(JSON.stringify(livrosAnterioresA1995.toArray(), null, 2));

//8) Total de livros publicados no ano 2000

    let livrosPublicadosEm2000 = books.find(
        {"publishedDate.$date": { $gt: new Date("1999-12-31T23:59:59Z").toISOString(), $lt: new Date("2001-01-01T00:00:00Z").toISOString()}},
        {"publishedDate": 1, "title": 1, "_id": 0}
    );
    console.log(JSON.stringify(livrosPublicadosEm2000.toArray(), null, 2));

//9) Qual o livro publicado mais recentemente?

let livroPublicadoMaisRecentemente = books.find(
        {},
        {"title": 1, "publishedDate": 1, "_id": 1},
    ).sort(
        {"publishedDate": -1}
    ).limit(1);
    console.log(JSON.stringify(livroPublicadoMaisRecentemente.toArray(), null, 2));

//10) Contém a palavra "Debugger" na descrição

    let livrosComDebuggerQuery = books.find(
        {"longDescription": {$regex: /debugger/i } },
        {"title": 1, "_id": 0}
    );
    console.log(JSON.stringify(livrosComDebuggerQuery.toArray(), null, 2));

//11) Qual o livro com o menor número de páginas?

let livrosComMenorQuantiaDePaginasQuery = books.find(
        {}, 
        {"title": 1, "pageCount": 1,"_id": 0}, 
    ).sort( 
        {"pageCount": 1}
    ).limit(1);
    console.log(JSON.stringify(livrosComMenorQuantiaDePaginasQuery.toArray(), null, 2));

//12) Qual o livro publicado mais antigo?

let livroPublicadoMaisAntigamente = books.find(
        {"publishedDate.$date": { $gt: new Date("0000-01-01T00:00:00Z").toISOString() } },
        {"title": 1, "publishedDate": 1, "_id": 0},
    ).sort(
        {"publishedDate": 1}
    ).limit(1);
    console.log(JSON.stringify(livroPublicadoMaisAntigamente.toArray(), null, 2));

//13) Livros com 3 ou mais autores

let livrosComTresOuMaisAutores = books.find(
    { $expr: { $gte: [{ $size: "$authors" }, 3] } }, 
    { "title": 1, "authors": 1, "_id": 0 } 
  );
    console.log(JSON.stringify(livrosComTresOuMaisAutores.toArray(), null, 2));

//14) Contem o termo "Java" e foi publicado a partir de 2013.

    let contemTermoJavaApartirDe2013 = books.find(
        {"categories": {$regex: /java/i}, "publishedDate.$date": {$gt: new Date("2003-01-01T00:00:00Z").toISOString() } },
        {"title": 1, "categories": 1, "publishedDate": 1, "_id": 0}
    );
    console.log(JSON.stringify(contemTermoJavaApartirDe2013.toArray(), null, 2));

//15) Livros que contém a categoria "Networking"

    let livrosComCategoriaNetworking = books.find(
        {"categories": {$regex: /networking/i } },
        {"title": 1, "categories": 1, "_id": 0}
    );
    console.log(JSON.stringify(livrosComCategoriaNetworking.toArray(), null, 2));

//16) Livros que contém a categoria "Networking" publicados depois do ano 2000:

    let livrosComCategoriaNetworkingDepoisDe2000 = books.find(
        {"categories": {$regex: /networking/i }, "publishedDate.$date": { $gt: new Date("2000-01-01T00:00:00Z").toISOString()} },
        {"title": 1, "categories": 1,"publishedDate": 1, "_id": 0}
    );
    console.log(JSON.stringify(livrosComCategoriaNetworkingDepoisDe2000.toArray(), null, 2));
  
//17) Total de livros na categoria networking?

    let TotallivrosComCategoriaNetworking = books.find(
        {"categories": {$regex: /networking/i } },
        {"title": 1, "categories": 1, "_id": 0}
    ).count();
    console.log("Total de livros na categoria networking: " + TotallivrosComCategoriaNetworking);

//18) Sumarizar o total de livros por categoria

    let listaCategorias = books.distinct("categories");
    listaCategorias.forEach(e => {
        let quantiaLivrosNaCategoria = books.find(
            {"categories": { $regex: e } }
        ).count();
        console.log(e + ": " + quantiaLivrosNaCategoria);
    }); 