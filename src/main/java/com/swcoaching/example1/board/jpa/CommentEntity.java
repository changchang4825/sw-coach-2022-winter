package com.swcoaching.example1.board.jpa;

import com.swcoaching.example1.user.jpa.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Table(name = "comment")
@EntityListeners(AuditingEntityListener.class)
@Entity
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String contents;

    @ManyToOne
    @JoinColumn(name = "postId")
    private PostEntity post;

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
