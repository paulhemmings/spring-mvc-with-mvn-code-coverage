package com.razor.SpringMvcCoverage.controller;

import org.junit.Test;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainControllerTest {

    @Test
    public void getRequestedFormatShouldReturnXmlForXmlRequests() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        MainController mainController = new MainController();
        mainController.processRequest(request, response);
    }
}
