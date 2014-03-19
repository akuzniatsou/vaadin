package my.vaadin.web.impl;

import my.vaadin.domain.Person;
import my.vaadin.service.api.IPersonService;
import my.vaadin.web.api.IWebController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WebController implements IWebController {

    @Autowired
    private transient IPersonService personService;

    @Override
    public void savePerson(Person person) {
        personService.save(person);
    }

    @Override
    public Person findPerson(String id) {
        return personService.find(id);
    }
}
