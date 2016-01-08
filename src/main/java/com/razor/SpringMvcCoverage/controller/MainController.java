package com.razor.SpringMvcCoverage.controller;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;


/**
 * The main controller.
 */

@Controller
public class MainController {

    /**
     * Process http request.
     * @param request
     * @param response
     */

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public final HttpEntity<String> processRequest(final HttpServletRequest request,
                                             final HttpServletResponse response)
    {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("text", "html", Charset.forName("UTF-8")));

        String responseBody = "<html><body>Main Page</body></html>";
        return new HttpEntity<String>(responseBody, headers);
    }	
}