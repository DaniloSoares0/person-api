package one.digitalinovation.bootcampgft.personapi.service;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import one.digitalinovation.bootcampgft.personapi.model.Person;
import one.digitalinovation.bootcampgft.personapi.repository.PersonRepository;

@AllArgsConstructor
@Service("PersonService")
public class PersonService {

	private PersonRepository personRepository;

	public Person createPerson(Person person) {
		return personRepository.save(person);
	}
	
}
