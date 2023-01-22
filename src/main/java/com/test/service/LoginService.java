package com.test.service;

import com.test.dao.AdministradorDAO;
import com.test.dao.PersonaDAO;
import com.test.dto.AdminDTO;
import com.test.entity.Administrador;
import com.test.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
    @Autowired
    private AdministradorDAO administradorDAO;
    
    @Autowired
    private PersonaDAO personaDAO;

    public Persona getLogin(AdminDTO adminDTO){
        System.out.println("Correo: " + adminDTO.getCorreo() + " - Password:" + adminDTO.getPassword());
        Persona person = personaDAO.getPersonByEmail(adminDTO.getCorreo());
        if(person != null){
            Administrador admin = administradorDAO.getLogin(person.getIdPersona(), adminDTO.getPassword());
            if(admin != null){
                return person;
            }
        }
        return null;
    }
}
