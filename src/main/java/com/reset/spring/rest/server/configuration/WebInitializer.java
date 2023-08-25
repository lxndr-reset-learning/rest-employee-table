package com.reset.spring.rest.server.configuration;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null; // у нас нет root config class
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ServerConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() { //url pattern
        return new String[]{"/"};
    } // класс, ответственный за DispatcherServlet
}
