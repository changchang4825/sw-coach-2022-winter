package com.swcoaching.example1.user.jpa;

import com.swcoaching.example1.board.jpa.CommentEntity;
import com.swcoaching.example1.board.jpa.PostEntity;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
@Entity
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 100, nullable = false)
  private String username;

  @Column(length = 100, nullable = false)
  private String password;

  @Column(length = 100, nullable = false)
  private String name;

  @Column(columnDefinition = "text")
  private String bio;

  @CreatedDate
  @Column(updatable = false, nullable = false)
  private LocalDateTime createdAt;

  @LastModifiedDate
  @Column(nullable = false)
  private LocalDateTime modifiedAt;

  @OneToMany(mappedBy = "user")
  private List<PostEntity> posts = new ArrayList<>();

  @OneToMany(mappedBy = "user")
  private List<CommentEntity> comments = new ArrayList<>();
}
