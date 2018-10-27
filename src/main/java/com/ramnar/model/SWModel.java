package com.ramnar.model;

import java.util.List;

//{
//	"count": 61,
//	"next": "https://swapi.co/api/planets/?page=2",
//	"previous": null,
//	"results": [
//		{
//			"name": "Alderaan",
//			"rotation_period": "24",
//			"orbital_period": "364",
//			"diameter": "12500",
//			"climate": "temperate",
//			"gravity": "1 standard",
//			"terrain": "grasslands, mountains",
//			"surface_water": "40",
//			"population": "2000000000",
//			"residents": [
//				"https://swapi.co/api/people/5/",
//				"https://swapi.co/api/people/68/",
//				"https://swapi.co/api/people/81/"
//			],
//			"films": [
//				"https://swapi.co/api/films/6/",
//				"https://swapi.co/api/films/1/"
//			],
//			"created": "2014-12-10T11:35:48.479000Z",
//			"edited": "2014-12-20T20:58:18.420000Z",
//			"url": "https://swapi.co/api/planets/2/"
//		}]}



public class SWModel {
	private int count;
	private List<Results> results;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<Results> getResults() {
		return results;
	}
	public void setResults(List<Results> results) {
		this.results = results;
	}

	
	

}


