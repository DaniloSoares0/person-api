package one.digitalinovation.bootcampgft.personapi.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinovation.bootcampgft.personapi.enums.PhoneTypes;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDTO {

	private Long id;
	
	@NotEmpty
	@Size(min = 13, max=14)
	private String number;

	@Enumerated(EnumType.STRING)
	private PhoneTypes phoneType;

}
