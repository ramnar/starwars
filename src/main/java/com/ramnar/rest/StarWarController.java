package com.ramnar.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramnar.model.SWElement;
import com.ramnar.service.StarWarService;

@RestController
@RequestMapping("/starwars")
public class StarWarController {

	@Autowired
	StarWarService starWarService;

	@GetMapping("/element/{type}/{name}")
	public List<SWElement> getSWElements(@PathVariable(value = "type") String type,
			@PathVariable(value = "name") String name) throws Exception {

		List<SWElement> result = null;

		result = starWarService.getSWElements(type, name);

		return result;
	}

}
