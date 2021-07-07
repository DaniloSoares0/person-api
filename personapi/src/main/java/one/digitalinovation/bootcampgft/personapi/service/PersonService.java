package one.digitalinovation.bootcampgft.personapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import one.digitalinovation.bootcampgft.personapi.dto.PersonDTO;
import one.digitalinovation.bootcampgft.personapi.mapper.PersonMapper;
import one.digitalinovation.bootcampgft.personapi.model.Person;
import one.digitalinovation.bootcampgft.personapi.repository.PersonRepository;

@Service("PersonService")
public class PersonService {

	private PersonRepository personRepository;
	
	private final PersonMapper personMapper = PersonMapper.INSTANCE;
	
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	
	public Person createPerson(PersonDTO personDTO) throws Exception {
		return personRepository.save(personMapper.toModel(personDTO));
	}

	public List<PersonDTO> listAll() {
		return personRepository.findAll()
				.stream()
				.map(personMapper::toDTO)
				.collect(Collectors.toList());
	}
	
	public PersonDTO findById(Long id) throws Exception{
		return personRepository.findById(id)
				.map(personMapper::toDTO)
				.get();
	}


	
	public void deleteById(Long id) throws Exception {
		personRepository.deleteById(id);
	}
}
