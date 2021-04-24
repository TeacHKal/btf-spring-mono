package com.teachkal.btf.spring.mono.repository;

import com.teachkal.btf.spring.mono.auth.security.AppUserRole;
import com.teachkal.btf.spring.mono.model.AppUser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class AppUserRepositoryTest {

    @Autowired
    private AppUserRepository underTest;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    @Disabled
    void findByEmail() {
    }

    @Test
    void itShouldCheckWhenAppUserEmailExists() {
        // given
        String email = "email";
        AppUser user = AppUser.builder()
                .email(email)
                .firstName("first name")
                .lastName("last name")
                .password("password")
                .appUserRole(AppUserRole.USER_BASIC)
                .build();
        underTest.save(user);
        // when
        Boolean isEmailExist = underTest.isEmailExist(email);
        // then
        assertThat(isEmailExist).isTrue();
    }
    @Test
    void itShouldCheckWhenAppUserEmailDoesNotExists() {
        // given
        String email = "email";
        // when
        Boolean isEmailExist = underTest.isEmailExist(email);
        // then
        assertThat(isEmailExist).isFalse();
    }


}