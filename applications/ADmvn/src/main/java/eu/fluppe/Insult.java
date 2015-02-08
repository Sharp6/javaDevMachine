package eu.fluppe;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="INSULTS")
public class Insult {
	public Insult() {
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "insults_seq_gen")
	@SequenceGenerator(name = "insults_seq_gen", sequenceName = "insults_id_seq")
	private Long id;
	private String insultString;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getInsultString() {
		return insultString;
	}
	public void setInsultString(String insultString) {
		this.insultString = insultString;
	}
}