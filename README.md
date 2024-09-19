## Play with the code
### Run
1. Run Elasticsearch docker image
```docker run -d --name elasticsearch -p 9200:9200 -e "discovery.type=single-node" elasticsearch:7.6.2```
2. Run the code
```./mvnw spring-boot:run```

### 
1. Java 17
2. Maven 3.6

### Test
1. Create index
```curl -X POST -H "Content-Type: application/json" -d '{"title": "Dreams 2", "authors": ["Robin", "John"], "releaseDate": "2024-09-19"}' http://localhost:8080/books"```
2. Get by id
```curl -X GET -H "Content-Type: application/json" http://localhost:8080/books/{id}```
3. Search by title
```curl -X GET -H "Content-Type: application/json" http://localhost:8080/books/search?title={title}```