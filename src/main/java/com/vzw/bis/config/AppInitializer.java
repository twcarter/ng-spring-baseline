package com.vzw.bis.config;

import com.vzw.bis.config.root.SpringConfig;
import com.vzw.bis.config.web.WebMvcConfig;
import org.springframework.util.StringUtils;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        configureAppContextInitializers(container, SpringApplicationContextInitializer.class.getName());
        createRootAppContext(container, SpringConfig.class);
        createDispatcherServlet(container, WebMvcConfig.class);
    }

    private void configureAppContextInitializers(ServletContext container, String... initClassNames) {
        String initializerClasses = container.getInitParameter(ContextLoader.CONTEXT_INITIALIZER_CLASSES_PARAM);

        String delimitedClassNames = StringUtils.arrayToDelimitedString(initClassNames, " ");

        if (StringUtils.hasText(initializerClasses)) {
            initializerClasses += " " + delimitedClassNames;
        } else {
            initializerClasses = delimitedClassNames;
        }

        container.setInitParameter(ContextLoader.CONTEXT_INITIALIZER_CLASSES_PARAM, initializerClasses);
    }

    private void createRootAppContext(ServletContext container, Class<?>... configClasses) {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(configClasses);
        container.addListener(new ContextLoaderListener(rootContext));
        container.setAttribute("applicationContext", rootContext);
    }

    private void createDispatcherServlet(ServletContext container, Class<?>... configClasses) {
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(configClasses);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(webContext);
        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", dispatcherServlet);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
