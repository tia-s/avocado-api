package edu.unb.tiashack.avocado_api.api.soap;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

// Define the SOAP service
@WebService
public interface HelloService {

    @WebMethod
    String sayHello(String name);
}
