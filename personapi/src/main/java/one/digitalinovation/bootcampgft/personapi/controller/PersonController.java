package one.digitalinovation.bootcampgft.personapi.controller;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import one.digitalinovation.bootcampgft.personapi.dto.PersonDTO;
import one.digitalinovation.bootcampgft.personapi.exception.PersonNotFoundException;
import one.digitalinovation.bootcampgft.personapi.service.PersonService;

@RestController
@AllArgsConstructor
@Api(value = "Person")
@RequestMapping("/api/v1/people")
public class PersonController {

	private PersonService personService;
	
	@ApiOperation(value = "Cria uma pessoa.")
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

	@GetMapping("{id}")
	@ApiOperation(value = "Busca uma pessoa por id.")
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

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta uma pessoa")
	public ResponseEntity<Serializable> deleteById(@PathVariable Long id) {
		try {
			personService.deleteById(id);
			return ResponseEntity.ok(HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Usuario não econtrado");
		}
	}	

	@PutMapping
	@ApiOperation(value = "Atualiza uma pessoa.")
	public ResponseEntity<Serializable> update(@RequestBody @Valid PersonDTO personDTO){
		try {
			return ResponseEntity.status(HttpStatus.OK)
					.body(personService.update(personDTO));
		}catch (SQLException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("O cpf já existe");
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Usuario não encontrado");
		}

	}

	@GetMapping
	@ApiOperation(value = "Lista pessoas.")
	public ResponseEntity<List<PersonDTO>> listAll(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(personService.listAll());
	}

	@GetMapping("/pesquisa")
	@ApiOperation(value = "Lista pessoas com filtros e com paginação.")
	public Page<PersonDTO> findPerson(@RequestBody PersonDTO personExample,
			@RequestParam(name = "page" , defaultValue = "0") Integer page,
			@RequestParam(name = "size" , defaultValue = "10") Integer size,
			@RequestParam(name = "sortDirection" , defaultValue = "ASC") String sortDirection){

		return personService.findByExample(personExample,
				PageRequest.of(page, size, Sort.Direction.valueOf(sortDirection), "createdAt"));
	}
}
