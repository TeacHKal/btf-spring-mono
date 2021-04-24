package com.teachkal.btf.spring.mono.repository;

import com.teachkal.btf.spring.mono.model.AppUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);

    @Query("" +
            "SELECT CASE WHEN COUNT(s) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM AppUser s " +
            "WHERE s.email = ?1"
    )
    Boolean isEmailExist(String email);
}
