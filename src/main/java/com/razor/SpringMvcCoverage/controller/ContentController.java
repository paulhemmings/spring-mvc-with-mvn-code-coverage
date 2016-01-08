package com.razor.SpringMvcCoverage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ContentController {

    @RequestMapping(value="/content")
    public @ResponseBody
    String GetAboutContent(final HttpServletRequest request, final HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_OK);
        return "This is the content of the about page!";
    }
}
