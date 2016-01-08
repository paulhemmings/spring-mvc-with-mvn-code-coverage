package com.razor.SpringMvcCoverage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FrontPageController {
    private final static Logger logger = LoggerFactory.getLogger(FrontPageController.class);

    @RequestMapping("/FrontPage")
    public ModelAndView hello(){
        logger.debug("In the controller.");
        return new ModelAndView("FrontPage", "message", "Hello world from Spring3.");
    }
}
