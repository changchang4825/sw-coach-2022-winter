package com.swcoaching.example1.user;

import com.swcoaching.example1.board.Comment;
import com.swcoaching.example1.board.Post;
import com.swcoaching.example1.user.jpa.UserEntity;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@ToString
@Getter
public class User {
  private final Long id;

  private final String username;

  private final String password;

  private final String name;

  private final String bio;

  private final List<Post> posts;

  private final List<Comment> comments;

  public User(Long id, String username, String password, String name, String bio, List<Post> posts, List<Comment> comments) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.name = name;
    this.bio = bio;
    this.posts = posts;
    this.comments = comments;
  }

  public static User of(UserEntity userEntity) {
    List<Post> posts = userEntity.getPosts()
            .stream().map(Post::of).collect(Collectors.toList());
    List<Comment> comments = userEntity.getComments()
            .stream().map(Comment::of).collect(Collectors.toList());
    return new User(userEntity.getId(), userEntity.getUsername(), userEntity.getPassword(),
            userEntity.getName(), userEntity.getBio(), posts, comments);
  }

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
