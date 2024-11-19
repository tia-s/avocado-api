package edu.unb.tiashack.avocado_api.api.soap;

import jakarta.jws.WebService;
import org.springframework.stereotype.Service;

@WebService(endpointInterface = "edu.unb.tiashack.avocado_api.api.soap.HelloService")
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name){
        return "Hello, " + name + "!";
    }
}
