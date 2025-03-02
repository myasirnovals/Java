package programmer.zaman.now.test.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import programmer.zaman.now.test.data.Person;
import programmer.zaman.now.test.repository.PersonRepository;

@Extensions({@ExtendWith(MockitoExtension.class)})

public class PersonServiceTest {
    @Mock
    private PersonRepository personRepository;

    private PersonService personService;

    @BeforeEach
    void setup() {
        personService = new PersonService(personRepository);
    }

    @Test
    void testGetPersonNotFound() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            personService.get("not found");
        });
    }

    @Test
    void testGetPersonSuccess() {
        // menambah behavior ke mock object
        Mockito.when(personRepository.selectById("yasir")).thenReturn(new Person("yasir", "Yasir"));

        var person = personService.get("yasir");

        Assertions.assertNotNull(person);
        Assertions.assertEquals("yasir", person.getId());
        Assertions.assertEquals("Yasir", person.getName());
    }

    @Test
    void testRegisterSuccess() {
        var person = personService.register("Yasir");

        Assertions.assertNotNull(person);
        Assertions.assertEquals("Yasir", person.getName());
        Assertions.assertNotNull(person.getId());

        Mockito.verify(personRepository, Mockito.times(1)).insert(new Person(person.getId(), "Yasir"));
    }
}
