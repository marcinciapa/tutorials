Codebase for [YouTube course](https://www.youtube.com/playlist?list=PLXy8DQl3058OoJqGLFdqoBkBKm2T0kS9B) for Spring Data
Elasticsearch tutorial.
This tutorial (and codebase) uses Spring 2.5.0. In latest releases some classes were deprecates.

# Scope
Lesson 1: Indexing document using Spring Data Repository, index create by annotation
Lesson 2: Indexing document using RestHighLevelClient, index created by RestHighLevelClient on startup

# Running

Running the application requires local Elasticsearch instance running in Docker:
`docker-compose up -d`

Run the class `SpringDataElasticSearchApplication` in IntelliJ

# What I learned

- Document can be mapped to Elasticsearch document using annotations (Person) or using mapping JSON file (
  resources/mappings/vehicle.json).
- Mappings JSON file must have the same name as index.