package com.tweteroospring.api.model;

import com.tweteroospring.api.dto.twetDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "twet")
@NoArgsConstructor
public class twetModel {

  public twetModel(twetDTO twet) {
    this.twet = twet.twet();
    this.userName = twet.userName();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false)
  private String twet;

  @Column(nullable = false)
  private String userName;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private userModel user;

}
