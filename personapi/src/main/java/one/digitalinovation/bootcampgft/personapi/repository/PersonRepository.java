package one.digitalinovation.bootcampgft.personapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import one.digitalinovation.bootcampgft.personapi.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
