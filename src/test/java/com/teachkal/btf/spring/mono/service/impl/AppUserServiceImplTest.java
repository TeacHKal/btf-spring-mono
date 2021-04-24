package com.teachkal.btf.spring.mono.service.impl;

import com.teachkal.btf.spring.mono.auth.security.AppUserRole;
import com.teachkal.btf.spring.mono.model.AppUser;
import com.teachkal.btf.spring.mono.repository.AppUserRepository;
import com.teachkal.btf.spring.mono.service.AppUserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;

import java.text.MessageFormat;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
class AppUserServiceImplTest {

    @Mock
    private AppUserRepository appUserRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    private AppUserService underTest;

    @BeforeEach
    void setUp() {
        underTest = new AppUserServiceImpl(appUserRepository, passwordEncoder);
    }

    @Test
    void getAppUsers() {
        // when
        underTest.getAppUsers();
        // then
        verify(appUserRepository).findAll();

    }

    @Test
    void canAddAppUser() {
        // given
        String email = "email";
        AppUser appUser = AppUser.builder()
                .email(email)
                .firstName("first name")
                .lastName("last name")
                .password("password")
                .appUserRole(AppUserRole.USER_BASIC)
                .build();
        // when
        underTest.addAppUser(appUser);
        // then
        ArgumentCaptor<AppUser> appUserArgumentCaptor = ArgumentCaptor.forClass(AppUser.class);
        verify(appUserRepository).save(appUserArgumentCaptor.capture());

        AppUser appUserCaptured = appUserArgumentCaptor.getValue();

        assertThat(appUserCaptured).isEqualTo(appUser);

    }

    @Test
    void addAppUserThrowsWhenEmailIsTaken() {
        // given
        String email = "email";
        AppUser appUser = AppUser.builder()
                .email(email)
                .firstName("first name")
                .lastName("last name")
                .password("password")
                .appUserRole(AppUserRole.USER_BASIC)
                .build();
        // when
        // then
        given(appUserRepository.isEmailExist(anyString())).willReturn(true);
        assertThatThrownBy(() -> underTest.addAppUser(appUser))
                .isInstanceOf(ResponseStatusException.class)
                .hasMessageContaining(MessageFormat.format("Email  already exists: {0}", appUser.getEmail()));

        verify(appUserRepository, never()).save(any());

    }

    @Test
    @Disabled
    void getAppUser() {
    }

    @Test
    @Disabled
    void editAppUser() {
    }

    @Test
    @Disabled
    void deleteAppUser() {
    }

    @Test
    @Disabled
    void findByEmail() {
    }

    @Test
    @Disabled
    void isEmailExist() {
    }
}