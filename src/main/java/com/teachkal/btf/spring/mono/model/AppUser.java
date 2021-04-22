package com.teachkal.btf.spring.mono.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teachkal.btf.spring.mono.auth.security.AppUserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "users_email_unique", columnNames = "email")
        })
public class AppUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(
//            name = "users_sequence",
//            sequenceName = "users_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_sequence")
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "email", length = 50, nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;
    @Column(name = "last_name", length = 50,nullable = false)
    private String lastName;
    @Column(name = "is_locked")
    private Boolean isLocked;
    @Column(name = "is_expired")
    private Boolean isExpired;
    @Column(name = "is_enabled")
    private Boolean isEnabled;
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return appUserRole.getGrantedAuthorities();
    }

    @Override
    @Transient
    public String getPassword() {
        return password;
    }

    @JsonIgnore
    @Override
    public String getUsername() {
        return email;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return !isLocked;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return !isExpired;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return isEnabled;
    }

}
