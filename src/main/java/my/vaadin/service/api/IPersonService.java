package my.vaadin.service.api;

import my.vaadin.domain.Person;

/**
 * Created by Mpak on 19.03.14.
 */
public interface IPersonService {

    void save(Person person);

    Person find(String id);
}
