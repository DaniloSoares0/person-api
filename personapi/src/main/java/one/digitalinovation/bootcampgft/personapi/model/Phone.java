package one.digitalinovation.bootcampgft.personapi.model;


import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinovation.bootcampgft.personapi.enums.PhoneTypes;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "phone")
public class Phone implements Serializable{

	private static final long serialVersionUID = 5481386270777483354L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="number")
	private String number;
	
	@Column(name="type")
    @Enumerated(EnumType.STRING)
	private PhoneTypes phoneType;
	
	@CreatedDate
	@Column(name = "created_at")
	private LocalDate createdAt;
}
