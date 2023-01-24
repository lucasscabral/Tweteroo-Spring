package com.tweteroospring.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroospring.api.dto.twetDTO;
import com.tweteroospring.api.model.twetModel;
import com.tweteroospring.api.model.userModel;
import com.tweteroospring.api.service.twetService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/tweets")
@CrossOrigin(origins = "*")
public class twetController {

  @Autowired
  private twetService service;

  @GetMapping
  public ResponseEntity<Page<twetModel>> getTwets(@PageableDefault(size = 5) Pageable pageable) {
    return ResponseEntity.ok(service.getTwets(pageable));
  }

  @PostMapping
  public ResponseEntity<String> createTwet(@RequestBody twetDTO req) {
    String existsUser = service.createTwet(req);
    if (existsUser.equals("não existe")) {
      return ResponseEntity.status(404).body("Esse usuário não existe");
    }

    return ResponseEntity.status(201).body("Criado com sucesso");

  }

}
