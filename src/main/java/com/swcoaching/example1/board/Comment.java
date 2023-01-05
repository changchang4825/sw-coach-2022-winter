package com.swcoaching.example1.board;

import com.swcoaching.example1.board.jpa.CommentEntity;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Comment {
    private final Long id;

    private final String contents;

    public Comment(Long id, String contents) {
        this.id = id;
        this.contents = contents;
    }

    public static Comment of(CommentEntity commentEntity) {
        return new Comment(commentEntity.getId(), commentEntity.getContents());
    }
}
