package com.swcoaching.example1;

import com.swcoaching.example1.board.jpa.BoardEntity;
import com.swcoaching.example1.board.jpa.BoardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SwCoachingApplication {

  public static void main(String[] args) {
    SpringApplication.run(SwCoachingApplication.class, args);
  }

  /*@Bean
  public CommandLineRunner init(BoardRepository boardRepository) {
    return args -> {
      BoardEntity entity = new BoardEntity();
      entity.setRemark("비고");
      entity.setTitle("제목");
      PostEntity postEntity = new PostEntity();
      postEntity.setTitle("post 제목");
      postEntity.setContents("post 내용");
      entity.setPosts(List.of(postEntity));
      boardRepository.save(entity);
      System.out.println("Hello World!");
    };
  }*/
}
