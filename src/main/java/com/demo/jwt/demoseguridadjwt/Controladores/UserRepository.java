package com.demo.jwt.demoseguridadjwt.Controladores;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.jwt.demoseguridadjwt.Entidades.User;

//Interface que tiene el querymetodo para buscar un username

public interface UserRepository extends JpaRepository<User, Integer> {

   // Optional<User> findByUsername(String username);
    public User findByUsername(String username);

}


