package com.tweteroospring.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroospring.api.dto.userDTO;
import com.tweteroospring.api.model.userModel;
import com.tweteroospring.api.service.userService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/sign-up")
@CrossOrigin(origins = "*")
public class userController {

  @Autowired
  private userService service;

  @GetMapping
  public List<userModel> getUser() {
    return service.getUser();
  }

  @PostMapping
  public ResponseEntity<String> createUser(@RequestBody @Valid userDTO req) {
    String existsUser = service.createUser(req);
    if (existsUser.equals("existe")) {
      System.out.println("ENTREI AQUI");
      return ResponseEntity.status(404).body("Esse usuário já existe");
    }
    return ResponseEntity.ok("Criado com sucesso");
  }
}