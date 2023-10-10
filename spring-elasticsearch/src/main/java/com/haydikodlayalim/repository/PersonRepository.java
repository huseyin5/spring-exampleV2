package com.haydikodlayalim.repository;

import com.haydikodlayalim.entity.Person;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PersonRepository extends ElasticsearchRepository<Person, String> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"ad\": \"?0\"}}]}}")
    List<Person> getByCustomerQuery(String search);

    List<Person> findByNameLikeOrLastNameLike(String name, String lastName);
}
