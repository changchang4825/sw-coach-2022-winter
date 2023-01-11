package com.swcoaching.example1.user;

import com.swcoaching.example1.user.jpa.UserEntity;
import com.swcoaching.example1.user.jpa.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @DisplayName("ID로 회원 조회 한다")
    @Test
    void findByUsername() {
        // given
        UserEntity userEntity = mock(UserEntity.class);
        UserRepository userRepository = mock(UserRepository.class);

        long testMemberId = 1L;
        String testMemberUsername = "testUsername";
        String testMemberPassword = "testPassword";
        String testMemberName = "테스트 회원명";
        String testRemark = "회원 비고";

        when(userEntity.getId()).thenReturn(testMemberId);
        when(userEntity.getUsername()).thenReturn(testMemberUsername);
        when(userEntity.getPassword()).thenReturn(testMemberPassword);
        when(userEntity.getName()).thenReturn(testMemberName);
        when(userEntity.getRemark()).thenReturn(testRemark);

        when(userRepository.findByUsername(testMemberUsername)).thenReturn(userEntity);

        // when
        UserService userService = new UserServiceImpl(userRepository);
        User user = userService.findByUsername(testMemberUsername);

        // then
        assertEquals(user.getId(), testMemberId);
        assertEquals(user.getUsername(), testMemberUsername);
        assertEquals(user.getPassword(), testMemberPassword);
        assertEquals(user.getName(), testMemberName);
        assertEquals(user.getRemark(), testRemark);
    }
}
