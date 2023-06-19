use('db_books');

    let res = db.getCollection('books'); 

    let a = res.aggregate([
    {
      $project: {
        "tittle": 1,
        "pageCount": 1,
        "_id": 0
      }
    },
    {
      $limit: 5
    }
  ]);
  
  console.log(JSON.stringify(a.toArray(), null, 2));