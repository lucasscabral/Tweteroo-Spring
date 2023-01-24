package com.tweteroospring.api.model;

import com.tweteroospring.api.dto.twetDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "twet")
@NoArgsConstructor
public class twetModel {

  public twetModel(twetDTO twet, userModel user) {
    this.twet = twet.twet();
    this.userName = twet.userName();
    this.avatar = user.getAvatar();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false)
  private String twet;

  @Column(nullable = false)
  private String userName;

  @Column(nullable = false)
  private String avatar;

}
