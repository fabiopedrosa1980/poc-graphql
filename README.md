# POC GRAPPQL

## Stack
- Java 8
- Graphql
- JPA
- h2

## Comandos para teste

### findById
{
  book(id:1) {
    title
  }
}

### list all
{
  books {
   id
   title
   pageCount 
  }
}
### save
mutation{
  saveBook(book:{title:"Kotlin",isbn:"kotlin",pageCount:800}){
    id
    title
    isbn
    pageCount
  }
}
### update
mutation{
  saveBook(book:{id:3,title:"Kotlin update",isbn:"kotlin",pageCount:800}){
    id
    title
    isbn
    pageCount
  }
}

## delete
mutation{
  deleteBook(id:1)
}

