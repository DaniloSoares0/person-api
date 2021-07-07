package one.digitalinovation.bootcampgft.personapi.controller;

import java.io.Serializable;
import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import one.digitalinovation.bootcampgft.personapi.dto.PersonDTO;
import one.digitalinovation.bootcampgft.personapi.exception.PersonNotFoundException;
import one.digitalinovation.bootcampgft.personapi.service.PersonService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/people")
public class PersonController {

	private PersonService personService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Serializable> createPerson(@RequestBody @Valid PersonDTO personDTO) {

		try {

			return ResponseEntity.status(HttpStatus.CREATED)
					.body(personService.createPerson(personDTO));

		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("O cliente já se encontra cadastrado na base");

		} catch (ConstraintViolationException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Digite um cpf válido ");

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Um erro ocorreu ao processar a solicitação");
		}
	}

	@GetMapping
	public ResponseEntity<List<PersonDTO>> listAll(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(personService.listAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Serializable> findById(@PathVariable Long id){
		
		try {
			return ResponseEntity.status(HttpStatus.OK)
					.body(personService.findById(id));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new PersonNotFoundException().getMessage());
					
		}
		
	}

	
}
