package com.ramnar.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.ramnar.model.Results;
import com.ramnar.model.SWElement;
import com.ramnar.model.SWModel;
import com.ramnar.service.StarWarService;

@Service
public class StarWarServiceImpl implements StarWarService {

	private static final String HTTPS_SWAPI_CO_API_URL = "https://swapi.co/api/";

	@Override
	public List<SWElement> getSWElements(String type, String name) {

		List<SWElement> list = new ArrayList<SWElement>();
		if (type != null && type.trim().length() > 0 && name != null && name.trim().length() > 0) {
			
			
			
			//read the data from other service
			String urlOverHttps = HTTPS_SWAPI_CO_API_URL + type;

			CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier())
					.build();
			HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
			requestFactory.setHttpClient(httpClient);

			ResponseEntity<String> response = new RestTemplate(requestFactory).exchange(urlOverHttps, HttpMethod.GET,
					null, String.class);

			// convert body to model

			SWModel model = new Gson().fromJson(response.getBody(), SWModel.class);

			// Filter the model
			for (Results result : model.getResults()) {
				if (result.getName().equals(name)) {
					SWElement element = new SWElement(type, name);
					List<String> films = result.getFilms();
					element.setFilms(films);
					element.setCount(films.size());
					list.add(element);

				}

			}
		}

		return list;
	}

}
