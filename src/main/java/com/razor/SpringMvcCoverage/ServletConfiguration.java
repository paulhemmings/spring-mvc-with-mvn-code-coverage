package com.razor.SpringMvcCoverage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Spring servlet configuration
 * This configuration class sets up the view resolvers and environment configuration.
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.razor.SpringMvcCoverage")
public class ServletConfiguration extends WebMvcConfigurerAdapter
{
    private final static Logger LOG = LoggerFactory.getLogger(ServletConfiguration.class);

    /**
     * pass through for static content
     *
     * @param configurer
     */
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry configurer)
    {
        LOG.info("Added resource handlers");
        // configurer.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/static/");
        // configurer.addResourceHandler("/assets/**").addResourceLocations
        //    ("classpath:/META-INF/resources/webjars/").setCachePeriod(31556926);

        configurer
                .addResourceHandler("/app/**")
                .addResourceLocations("/app/").setCachePeriod(31556926);

        configurer
                .addResourceHandler("/public/**")
                .addResourceLocations("/public/").setCachePeriod(31556926);
    }

    /**
     * Resource bundle for error messages, etc.
     *
     * @return
     */
    @Bean
    public MessageSource messageSource()
    {
        ResourceBundleMessageSource result = new ResourceBundleMessageSource();

        String[] basenames = {"messages"};

        result.setBasenames(basenames);

        LOG.info("set Message Source");

        return result;
    }

    /**
     * Spring view resolver for multiple view types.
     */

    @Bean
    public ContentNegotiatingViewResolver viewResolver()
    {
        ContentNegotiatingViewResolver contentNegotiatingViewResolver =
                new ContentNegotiatingViewResolver();
        contentNegotiatingViewResolver.setOrder(1);
        contentNegotiatingViewResolver.setFavorPathExtension(true);
        contentNegotiatingViewResolver.setFavorParameter(true);
        contentNegotiatingViewResolver.setIgnoreAcceptHeader(false);
        contentNegotiatingViewResolver.setUseNotAcceptableStatusCode(true);

        // media types
        Map<String, String> mediaTypes = new HashMap<String, String>();
        mediaTypes.put("view", "application/x-view");
        mediaTypes.put("view", "text/view");
        mediaTypes.put("view", "text/x-view");
        mediaTypes.put("view", "application/view");
        contentNegotiatingViewResolver.setMediaTypes(mediaTypes);

        // default views
        List<View> defaultViews = new ArrayList<View>();
        contentNegotiatingViewResolver.setDefaultViews(defaultViews);

        // chained view resolvers
        List<ViewResolver> viewResolvers = new ArrayList<ViewResolver>();
        viewResolvers.add(jspView());
        contentNegotiatingViewResolver.setViewResolvers(viewResolvers);

        LOG.info("completed ContentNegotiatingViewResolver");

        return contentNegotiatingViewResolver;
    }

    /**
     * JSP view
     * or getInternalResourceViewResolver
     */

    @Bean
    public InternalResourceViewResolver jspView()
    {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/jsp/");
        viewResolver.setSuffix(".jsp");

        LOG.info("completed InternalResourceViewResolver");

        return viewResolver;
    }

    /**
     * Configure the default servlet handler
     * @param configurer
     */

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
    {
        LOG.info("configured default servlet handling");
        configurer.enable();
    }

}