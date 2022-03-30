package com.cg.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
@Entity
public class Tests implements Serializable{
	@Id
	private long id;

	private String name;

	@Enumerated(EnumType.STRING)
	private State state = State.FREE;

	public enum State {
		FREE, RESERVED, OCCUPIED
	}

	public Tests() {
		// TODO Auto-generated constructor stub
	}

	public Tests(long id, String name, State state) {
		super();
		this.id = id;
		this.name = name;
		this.state = state;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Beds [id=" + id + ", name=" + name + ", state=" + state + "]";
	}

}
