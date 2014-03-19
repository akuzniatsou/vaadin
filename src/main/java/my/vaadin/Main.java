package my.vaadin;

import my.vaadin.config.AppConfig;
import my.vaadin.domain.Person;
import my.vaadin.repository.api.IPersonRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Mpak on 19.03.14.
 */
public class Main {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        IPersonRepository repository = ctx.getBean(IPersonRepository.class);
        /*
        Person person = preparePerson("0001", "Alena", "Kvetka", 20);
        repository.create(person);
        */
        System.out.println(repository.read("0001"));
    }

    private static Person preparePerson(String id, String name, String lastname, int age) {
        Person person = new Person();
        person.setId(id);
        person.setName(name);
        person.setLastname(lastname);
        person.setAge(age);
        return person;
    }
}
