package com.swcoaching.example1.board.jpa;

import com.swcoaching.example1.member.jpa.MemberEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * 게시물
 */
@Getter
@Table(name = "post")
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
  @JoinColumn(name = "memberId")
  private MemberEntity member;

}
