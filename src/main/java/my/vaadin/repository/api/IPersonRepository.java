package my.vaadin.repository.api;

import my.vaadin.domain.Person;

/**
 * Created by Mpak on 19.03.14.
 */
public interface IPersonRepository {

    void create(Person person);

    Person read(String id);
}
