package one.digitalinovation.bootcampgft.personapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import one.digitalinovation.bootcampgft.personapi.dto.PersonDTO;
import one.digitalinovation.bootcampgft.personapi.model.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {

	PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
	
	@Mappings({
		@Mapping(source="birthDate", target = "birthDate", dateFormat = "dd-MM-yyyy")
	})
	Person toModel(PersonDTO personDTO);
	
	PersonDTO toDTO(Person person);
}
