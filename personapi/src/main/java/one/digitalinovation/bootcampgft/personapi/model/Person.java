package one.digitalinovation.bootcampgft.personapi.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person")
public class Person implements Serializable{
	
	private static final long serialVersionUID = 7358912459265900699L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name ="first_name", nullable = false)
	private String firstName;
	
	@Column(name ="last_name", nullable = false)
	private String lastName;
	
	@Column(name ="cpf",nullable = false, unique = true)
	private String cpf;
	
	@Column(name ="data_nascimento")
	private LocalDate birthDate;
	
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH})
    private List<Phone> phones = new ArrayList<>();
	
	@CreatedDate
	@Column(name = "created_at")
	private LocalDate createdAt;
}
