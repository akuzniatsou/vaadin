package my.vaadin.repository.impl;

import my.vaadin.domain.Person;
import my.vaadin.repository.api.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository("person.repository")
public class PersonRepository implements IPersonRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void create(Person person) {
        mongoTemplate.insert(person);
    }

    @Override
    public Person read(String id) {
        return mongoTemplate.findById(id, Person.class);
    }

}
