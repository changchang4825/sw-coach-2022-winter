package com.swcoaching.example1.board;

import com.swcoaching.example1.board.jpa.PostEntity;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 게시물
 */
@ToString
@Getter
public class Post {
  private final Long id;

  private final String title;

  private final String contents;

  private final List<Comment> comments;

  public Post(Long id, String title, String contents, List<Comment> comments) {
    this.id = id;
    this.title = title;
    this.contents = contents;
    this.comments = comments;
  }

  public static Post of(PostEntity postEntity) {
    List<Comment> comments = postEntity.getComments()
            .stream().map(Comment::of).collect(Collectors.toList());
    return new Post(
            postEntity.getId(),
            postEntity.getTitle(),
            postEntity.getContents(),
            comments
    );
  }
}
