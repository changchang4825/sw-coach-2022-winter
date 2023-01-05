package com.swcoaching.example1.member;

import com.swcoaching.example1.board.Comment;
import com.swcoaching.example1.board.Post;
import com.swcoaching.example1.member.jpa.MemberEntity;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@ToString
@Getter
public class Member {
  private final Long id;

  private final String username;

  private final String password;

  private final String name;

  private final String remark;

  private final List<Post> posts;

  private final List<Comment> comments;

  public Member(Long id, String username, String password, String name, String remark, List<Post> posts, List<Comment> comments) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.name = name;
    this.remark = remark;
    this.posts = posts;
    this.comments = comments;
  }

  public static Member of(MemberEntity memberEntity) {
    List<Post> posts = memberEntity.getPosts()
            .stream().map(Post::of).collect(Collectors.toList());
    List<Comment> comments = memberEntity.getComments()
            .stream().map(Comment::of).collect(Collectors.toList());
    return new Member(memberEntity.getId(), memberEntity.getUsername(), memberEntity.getPassword(),
            memberEntity.getName(), memberEntity.getRemark(), posts, comments);
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
