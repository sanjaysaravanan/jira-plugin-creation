package com.atlassian.connect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.atlassian.connect.spring.AtlassianHostRestClients;

@Controller
public class HelloWorld {
	
	@Value("${jsUrl}")
    private String localBaseUrl;
	
	@Autowired
	private AtlassianHostRestClients atlassianHostRestClients;
	
	@RequestMapping(value = "/projects")
    public ModelAndView helloWorld() {
		ModelAndView model = new ModelAndView();
		model.setViewName("hello");
		model.addObject("jsUrl", localBaseUrl);
		model.addObject("test", atlassianHostRestClients.authenticatedAsAddon().getForObject("/rest/api/2/project", String.class));
		return model;
    }
	
	@RequestMapping("/boards")
    public String greeting(Model model) {
        String response = atlassianHostRestClients.authenticatedAsAddon().getForObject("/rest/agile/1.0/board", String.class);
		model.addAttribute("jsUrl", localBaseUrl);
		model.addAttribute("test", response);
		return "greeting";
    }
}