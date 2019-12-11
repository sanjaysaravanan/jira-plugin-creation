package com.atlassian.connect.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;  
import org.springframework.security.core.annotation.AuthenticationPrincipal;  
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.ModelAndView;

import com.atlassian.connect.spring.AtlassianHostUser;
import com.atlassian.connect.spring.IgnoreJwt;

@IgnoreJwt
@Controller
public class IssueToDosPanelController {

    //private Logger log = Logger.getLogger(getClass());

    @RequestMapping(value="/issue-todos-panel", method = RequestMethod.GET)
    public ModelAndView myRest(@AuthenticationPrincipal AtlassianHostUser hostUser,
            HttpServletRequest request) {

        ModelAndView model = new ModelAndView();
        model.setViewName("issue-all-panel");

        model.addObject("issueKey", request.getParameter("issueKey"));

        return model;
    }
}