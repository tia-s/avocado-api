/**
 * Configuration class for setting up SOAP API endpoints using Apache CXF.
 * 
 * Responsibilities:
 * - Registers the CXF servlet to handle SOAP requests under the `/soap` path.
 * - Configures the SpringBus for managing CXF infrastructure.
 * 
 * Annotations:
 * - @Configuration: Marks this as a Spring configuration class.
 * - @Bean: Defines beans for CXF servlet, SpringBus, and SOAP endpoint.
 */

package edu.unb.tiashack.avocado_api.api.soap;

import edu.unb.tiashack.avocado_api.service.AvocadoSaleService;
import jakarta.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AvocadoSoapApiConfig {
    private final AvocadoSaleService avocadoSaleService;

    public AvocadoSoapApiConfig(AvocadoSaleService avocadoSaleService) {this.avocadoSaleService = avocadoSaleService;}

    @Bean
    public ServletRegistrationBean<CXFServlet> cxfServlet() {
        return new ServletRegistrationBean<>(new CXFServlet(), "/soap");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), new AvocadoSoapApi(this.avocadoSaleService));
        endpoint.publish("/");
        return endpoint;
    }

}
