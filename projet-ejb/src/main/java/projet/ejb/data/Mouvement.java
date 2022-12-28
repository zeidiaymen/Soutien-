package projet.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Mouvement implements Serializable {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idmvt")
	private int id;
	private double montant;
	private Date date = new Date();
	@ManyToOne
	@JoinColumn(name="idcompte")
	private Compte cpt;
}
