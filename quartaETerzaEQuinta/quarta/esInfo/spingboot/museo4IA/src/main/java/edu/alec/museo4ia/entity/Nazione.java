package edu.alec.museo4ia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Alessandro Cazziolato
 */
@Entity
@Data
@Table(name = "tblNazione")
public class Nazione {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idNazione;
	@Column(nullable = false)
	private String nazione;

}
