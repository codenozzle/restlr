package com.codenozzle.api;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.wordnik.swagger.config.ScannerFactory;
import com.wordnik.swagger.jaxrs.config.BeanConfig;

public class Bootstrap extends HttpServlet {
    private static final long serialVersionUID = -6010624267305756085L;

	@Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setDescription("RESTful API");
        beanConfig.setVersion("1.0");
        beanConfig.setBasePath("/restlr/api");
        beanConfig.setResourcePackage(App.class.getPackage().getName());
        beanConfig.setScan(true);
        ScannerFactory.setScanner(beanConfig);
    }
}
