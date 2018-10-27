package com.ramnar.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ramnar.model.SWElement;
import com.ramnar.service.StarWarService;

@Service
public class StarWarServiceImpl implements StarWarService{

	@Override
	public List<SWElement> getSWElements(String type, String name) {
		SWElement element = new SWElement("Planet", "Venus");
		element.setFilms(Arrays.asList("http://google.com", "http://github.com"));
		element.setCount(2);
		return Arrays.asList(element);
	}

}
