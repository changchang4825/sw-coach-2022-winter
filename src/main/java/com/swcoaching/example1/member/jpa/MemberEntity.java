package com.swcoaching.example1.member.jpa;

import com.swcoaching.example1.board.jpa.CommentEntity;
import com.swcoaching.example1.board.jpa.PostEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Table(name = "member")
@Entity
public class MemberEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String username;
  private String password;
  private String name;
  private String remark;

  @OneToMany(mappedBy = "member")
  private List<PostEntity> posts = new ArrayList<>();

  @OneToMany(mappedBy = "member")
  private List<CommentEntity> comments = new ArrayList<>();

  /*public Long getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getName() {
    return name;
  }

  public String getRemark() {
    return remark;
  }*/
}
