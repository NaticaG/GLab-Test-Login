package com.test.dao;

import com.test.entity.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdministradorDAO  extends JpaRepository<Administrador, Integer> {
    @Query(value = "SELECT * FROM administrador WHERE id_persona = :idPersona AND contrasenia = :password", nativeQuery=true)
    Administrador getLogin(int idPersona, String password);
}
