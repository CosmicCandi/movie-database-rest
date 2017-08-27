package com.libertymutual.goforcode.ironyardmoviedatabase.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class ActorAward extends Award {
	
	@ManyToOne
	private Actor actor;
	
	@JsonIgnore
	public Actor getActor() {
		return actor;
	}
	
	@JsonProperty("actor")
	public void setActor(Actor actor) {
		this.actor = actor;
	}

}
