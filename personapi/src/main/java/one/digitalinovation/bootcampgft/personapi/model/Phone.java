package one.digitalinovation.bootcampgft.personapi.model;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import one.digitalinovation.bootcampgft.personapi.enums.PhoneTypes;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "phone")
@EqualsAndHashCode(of = "id")
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="number")
	private String number;
	
	@Column(name="type")
	private PhoneTypes phoneType;
	
	@CreatedDate
	@Column(name = "created_at")
	private LocalDate createdAt;
}
