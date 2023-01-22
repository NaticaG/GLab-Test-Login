package com.test.controller;

import com.test.dto.AdminDTO;
import com.test.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping(value="/login")
    public ResponseEntity<?> loginUsuario(@RequestBody AdminDTO adminDTO){
        return ResponseEntity.status(HttpStatus.OK).body(loginService.getLogin(adminDTO));
    }
}
