package org.peraza.librosdemo.controllers;

import org.peraza.librosdemo.models.dtos.AuthDTO;
import org.peraza.librosdemo.models.dtos.LoginDTO;
import org.peraza.librosdemo.models.entity.User;
import org.peraza.librosdemo.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/login")
    public ResponseEntity<LoginDTO> login(AuthDTO authDTO)
    {
        if(authDTO.getUsername()==  null || authDTO.getPassword()== null)
        {
            return null;
        }

        Optional<User> user = authService.login(authDTO.getUsername(), authDTO.getPassword());
        if(user.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        LoginDTO loginDTO = new LoginDTO(user.get().getFullName(), user.get().getState());
        return new ResponseEntity<>(loginDTO, HttpStatus.OK);


    }
}
