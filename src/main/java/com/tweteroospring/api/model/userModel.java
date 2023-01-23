package com.tweteroospring.api.model;

import java.util.ArrayList;
import java.util.List;

import com.tweteroospring.api.dto.userDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
public class userModel {

  public userModel(userDTO user) {
    this.userName = user.userName();
    this.avatar = user.avatar();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 100, nullable = false)
  private String userName;

  @Column(nullable = false)
  private String avatar;

  @OneToMany(mappedBy = "user")
  private List<twetModel> twet = new ArrayList<>();

}
