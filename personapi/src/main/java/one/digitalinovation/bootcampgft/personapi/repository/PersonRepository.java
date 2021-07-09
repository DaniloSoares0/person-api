package one.digitalinovation.bootcampgft.personapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import one.digitalinovation.bootcampgft.personapi.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	@Query("SELECT p FROM Person p INNER JOIN FETCH p.phones ph")
	public List<Person> listAll();
	
	@Query("SELECT p FROM Person p INNER JOIN FETCH p.phones ph WHERE p.id=:id")
	public Optional<Person> searchUserById(@Param("id") Long id);

}
