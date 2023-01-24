package com.tweteroospring.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroospring.api.dto.userDTO;
import com.tweteroospring.api.model.userModel;
import com.tweteroospring.api.repository.userRepository;

@Service
public class userService {

  @Autowired
  private userRepository repository;

  public List<userModel> getUser() {
    return repository.findAll();
  }

  public String createUser(userDTO req) {
    List<userModel> user = repository.findByUserName(req.userName());

    if (user.isEmpty()) {
      repository.save(new userModel(req));
      return "não existe";
    } else {
      return "existe";
    }
  }
}

// for (int i = 0; i < allUser.size(); i++) {
// if (allUser.get(i).getUserName().equals(req.userName())) {
// repository.save(new userModel(req));
// return true;
// }
// }
// return false;
// }