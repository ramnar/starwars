package com.ramnar.model;

import java.util.List;

/**
 * Model class for Starwars elements like planets, spaceship, vehicles, people, films and species
 * @author indiahiring
 *
 */
public class SWElement {
	
	private String type;
	
	private String name;
	
	private int count;
	
	private List<String> films;
	
	public SWElement(String type, String name) {
		this.type = type;
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<String> getFilms() {
		return films;
	}

	public void setFilms(List<String> films) {
		this.films = films;
	}
	

}
