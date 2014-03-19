package my.vaadin.web.api;

import my.vaadin.domain.Person;

public interface IWebController {

    void savePerson(Person person);

    Person findPerson(String id);
}
