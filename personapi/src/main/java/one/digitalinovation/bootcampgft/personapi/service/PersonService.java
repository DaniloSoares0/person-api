package one.digitalinovation.bootcampgft.personapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import one.digitalinovation.bootcampgft.personapi.dto.PersonDTO;
import one.digitalinovation.bootcampgft.personapi.exception.PersonNotFoundException;
import one.digitalinovation.bootcampgft.personapi.mapper.PersonMapper;
import one.digitalinovation.bootcampgft.personapi.model.Person;
import one.digitalinovation.bootcampgft.personapi.repository.PersonRepository;

@AllArgsConstructor
@Service("PersonService")
public class PersonService {

	private PersonRepository personRepository;
	
	private final PersonMapper personMapper ;
	
	public Person createPerson(PersonDTO personDTO) throws Exception {
		return personRepository.save(personMapper.toModel(personDTO));
	}

	public List<PersonDTO> listAll() {
		return personRepository.listAll()
				.stream()
				.map(personMapper::toDTO)
				.collect(Collectors.toList());
	}
	
	public PersonDTO findById(Long id) throws Exception{
		return personRepository.searchUserById(id)
				.map(personMapper::toDTO)
				.get();
	}

	public void deleteById(Long id) throws Exception {
		personRepository.deleteById(id);
	}

	public Person update(PersonDTO personDTO) throws Exception {
	
	  if(personRepository.findById(personDTO.getId()).isPresent()) 
		  return personRepository.save(personMapper.toModel(personDTO));
	  else
		  throw new PersonNotFoundException();
	}
	
	@Transactional
	public Page<PersonDTO> findByExample(PersonDTO personExample, PageRequest pageOptions) {
		return personRepository.findAll(Example.of(personMapper.toModel(personExample)), pageOptions)
				.map(personMapper::toDTO);
	}
}
