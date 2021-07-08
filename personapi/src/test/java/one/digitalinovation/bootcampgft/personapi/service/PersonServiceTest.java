package one.digitalinovation.bootcampgft.personapi.service;

import static one.digitalinovation.bootcampgft.personapi.utils.PersonUtils.createFakeDTO;
import static one.digitalinovation.bootcampgft.personapi.utils.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import one.digitalinovation.bootcampgft.personapi.dto.PersonDTO;
import one.digitalinovation.bootcampgft.personapi.mapper.PersonMapper;
import one.digitalinovation.bootcampgft.personapi.model.Person;
import one.digitalinovation.bootcampgft.personapi.repository.PersonRepository;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnPersonSaved() throws Exception {
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        when(personMapper.toModel(personDTO)).thenReturn(expectedSavedPerson);
        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        Person personSaved = personService.createPerson(personDTO);

        assertEquals(expectedSavedPerson, personSaved);
    }



}
