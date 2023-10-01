Codebase for [YouTube course](https://www.youtube.com/playlist?list=PLXy8DQl3058OoJqGLFdqoBkBKm2T0kS9B) for Spring Data
Elasticsearch tutorial.
This tutorial (and codebase) uses Spring 2.5.0. In latest releases some classes were deprecates.

# Scope

Lesson 1: Indexing document using Spring Data Repository, index create by annotation
Lesson 2: Indexing document using RestHighLevelClient, index created by RestHighLevelClient on startup
Lesson 3: Executing match query
Lesson 4: Applying sort order
Lesson 5: Applying range query
Lesson 6: Combining queries with bool query

# Running

Running the application requires local Elasticsearch instance running in Docker:
`docker-compose up -d`

Run the class `SpringDataElasticSearchApplication` in IntelliJ

# Testing

There is a file named `requests.txt` containing example HTTP requests to interact with application.

# What I learned

- Document can be mapped to Elasticsearch document using annotations (Person) or using mapping JSON file (
  resources/mappings/vehicle.json).
- Mappings JSON file must have the same name as index.
- While composing a query with Elasticsearch library, we can define which fields should match the search term. But
  should it be defined in the code, or should it be defined in the Elasticsearch config? Probably no. We should define a
  query in a code. But match _score should be configured in Elastic. Or not?
- We can provide org.springframework.format.annotation.DateTimeFormat annotation for path param to parse it to date.
- There are three factors influencing document matching score: term frequency (more the term appears in a field, the
  more important it is), inverse document frequency (the more documents contains the term, the less important it is),
  field length (shorter fields are more likely to be relevant).
- There are four types for boolean query: must (term must appear in matching document and will contribute to the score),
  must not (term must not appear in matching document), should (term optionally appears in matching document, will
  contribute to the score), filter (term must appear in the matching document, will not contribute to the score).
- In a query we can influence match score of each term by setting the `minimumShouldMatch` property (how many should
  queries should match, allows building more precise query.
- If there are multiple should queries, at lest one must match. If none of them matches, there will be no results.
