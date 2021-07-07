package one.digitalinovation.bootcampgft.personapi.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotEmpty
	@Size(min=2, max = 100)
	private String firstName;
	
	@NotEmpty
	@Size(min=2, max = 100)
	private String lastName;
	
	@CPF
	@NotEmpty
	private String cpf;
	
	private LocalDate birthDate;
	
	@Valid
	@NotEmpty
	private List<PhoneDTO> phones;

	private LocalDate createdAt;

}
