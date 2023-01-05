package com.swcoaching.example1.board.jpa;

import com.swcoaching.example1.member.jpa.MemberEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Table(name = "comment")
@Entity
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String contents;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private MemberEntity member;

    @ManyToOne
    @JoinColumn(name = "postId")
    private PostEntity post;
}
