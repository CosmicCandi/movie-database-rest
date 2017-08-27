package com.libertymutual.goforcode.ironyardmoviedatabase.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class ActorAward extends Award {
	
	@ManyToOne
	@JsonIgnore
	private Actor actor;
	
	public Actor getActor() {
		return actor;
	}
	
	public void setActor(Actor actor) {
		this.actor = actor;
	}

}
