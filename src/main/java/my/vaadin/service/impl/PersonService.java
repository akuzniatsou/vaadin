package my.vaadin.service.impl;

import my.vaadin.domain.Person;
import my.vaadin.repository.api.IPersonRepository;
import my.vaadin.service.api.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("person.service")
public class PersonService implements IPersonService {

    @Autowired
    private IPersonRepository personRepository;

    @Override
    public void save(Person person) {
        personRepository.create(person);
    }

    @Override
    public Person find(String id) {
        return personRepository.read(id);
    }
}
