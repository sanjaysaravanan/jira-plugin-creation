package com.atlassian.connect;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import com.atlassian.connect.spring.AtlassianHostRestClients;

@RestController
@RequestMapping("api")
public class ApiController {
	
	@Autowired
	private AtlassianHostRestClients atlassianHostRestClients;
	
	@RequestMapping(value="/project", produces={"application/json"})
    public String project() throws RestClientException, JSONException {
        return atlassianHostRestClients.authenticatedAsAddon().getForObject("/rest/api/2/project", String.class);
    }
	
	@RequestMapping(value="/board", produces={"application/json"})
    public String board() throws RestClientException, JSONException {
        return atlassianHostRestClients.authenticatedAsAddon().getForObject("/rest/agile/1.0/board", String.class);
    }
}