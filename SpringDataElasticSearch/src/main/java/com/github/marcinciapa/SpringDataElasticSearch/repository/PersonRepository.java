package com.github.marcinciapa.SpringDataElasticSearch.repository;

import com.github.marcinciapa.SpringDataElasticSearch.document.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

// type parameters: document, idtype
public interface PersonRepository extends ElasticsearchRepository<Person, String> {
}
