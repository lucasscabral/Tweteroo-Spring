package com.tweteroospring.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroospring.api.model.userModel;

public interface userRepository extends JpaRepository<userModel, Long> {
  List<userModel> findByUserName(String userName);
}
