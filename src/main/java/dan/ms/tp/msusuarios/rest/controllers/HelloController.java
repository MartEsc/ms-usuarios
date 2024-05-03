package dan.ms.tp.msusuarios.rest.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello-1")
    @PreAuthorize("hasRole('administracion')")
    public String helloAdmin(){
        return "Hello Admin!";
    }
    @GetMapping("/hello-2")
    @PreAuthorize("hasRole('escritura') or hasRole('lectura')")
    public String helloUser(){
        return "Hello User!";
    }
}
