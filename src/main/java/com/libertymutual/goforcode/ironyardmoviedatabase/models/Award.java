package com.libertymutual.goforcode.ironyardmoviedatabase.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Award {
	
	//Instance Variables
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="award_id_seq")
	@SequenceGenerator(name="award_id_seq", sequenceName="award_id_seq")
	private Long id;
	
	private Accolade accolade;
	private int year;
	private AccoladeCategory category;
	
	public Award() {
		
	}
	
	//Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Accolade getAccolade() {
		return accolade;
	}
	public void setAccolade(Accolade accolade) {
		this.accolade = accolade;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public AccoladeCategory getCategory() {
		return category;
	}
	public void setCategory(AccoladeCategory category) {
		this.category = category;
	}
}
