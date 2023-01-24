package com.tweteroospring.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tweteroospring.api.dto.twetDTO;
import com.tweteroospring.api.model.twetModel;
import com.tweteroospring.api.model.userModel;
import com.tweteroospring.api.repository.twetRepository;
import com.tweteroospring.api.repository.userRepository;

@Service
public class twetService {

  @Autowired
  private twetRepository repository;
  @Autowired
  private userRepository userRepository;

  public Page<twetModel> getAllTwets(Pageable pageable) {
    return repository.findAll(pageable);
  }

  public String createTwet(twetDTO twet) {
    List<userModel> user = userRepository.findByUserName(twet.userName());
    if (user.isEmpty()) {
      return "não existe";
    } else {
      repository.save(new twetModel(twet, user.get(0)));
      return "existe";
    }
  }

  public Object getTwetByUserName(String userName) {
    List<userModel> user = userRepository.findByUserName(userName);
    if (user.isEmpty()) {
      return "usuario nao existe";
    } else {
      return repository.findByUserName(userName);
    }
  }

}
