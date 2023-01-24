package com.tweteroospring.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroospring.api.model.twetModel;

public interface twetRepository extends JpaRepository<twetModel, Long> {
  List<twetModel> findByUserName(String userName);
}
