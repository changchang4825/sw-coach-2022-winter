package com.swcoaching.example1.controller;

import com.swcoaching.example1.board.Comment;
import com.swcoaching.example1.board.Post;
import com.swcoaching.example1.user.User;
import com.swcoaching.example1.user.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(UserController.class)
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @DisplayName("회원을 조회 테스트를 한다")
    @Test
    void testMember() throws Exception {

        // given
        long id = 1L;
        String username = "test_user";
        String password = "password";
        String name = "테스트유저";
        String remark = "비고";
        List<Post> posts = null;
        List<Comment> comments = null;
        when(userService.findByUsername(username)).thenReturn(new User(id, username, password, name, remark, posts, comments));

        // when
        ResultActions resultActions = mockMvc.perform(get("/member?username=" + username)).andDo(print());

        // then
        resultActions
                .andExpect(jsonPath("$.id").value(is((int) id)))
                .andExpect(jsonPath("$.username").value(is(username)))
                .andExpect(jsonPath("$.password").value(is(password)))
                .andExpect(jsonPath("$.name").value(is(name)))
                .andExpect(jsonPath("$.remark").value(is(remark)));
    }
}
