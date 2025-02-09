package com.swcoaching.example1.board.jpa;

import com.swcoaching.example1.user.jpa.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 게시물
 */
@Getter
@Table(name = "post")
@EntityListeners(AuditingEntityListener.class)
@Entity
public class PostEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 1000)
  private String title;

  @Column(columnDefinition = "text")
  private String contents;

  @OneToMany(mappedBy = "post")
  private List<CommentEntity> comments = new ArrayList<>();

  @ManyToOne
  @JoinColumn(name = "boardId")
  private BoardEntity board;

  @ManyToOne
  @JoinColumn(name = "userId")
  private UserEntity user;

  @CreatedDate
  @Column(updatable = false, nullable = false)
  private LocalDateTime createdAt;

  @LastModifiedDate
  @Column(nullable = false)
  private LocalDateTime modifiedAt;

}
