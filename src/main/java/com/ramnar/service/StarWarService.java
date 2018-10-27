package com.ramnar.service;

import java.util.List;

import com.ramnar.model.SWElement;

public interface StarWarService {

	List<SWElement> getSWElements(String type, String name);

}
