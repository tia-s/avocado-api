package edu.unb.tiashack.avocado_api.api.soap;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.WebParam;

// Define the SOAP service with interfaces for every method
@WebService
public interface HelloService {
    @WebMethod
    String sayHello(@WebParam(name = "name") String name);
}
