package com.teachkal.btf.spring.mono.repository;

import com.teachkal.btf.spring.mono.model.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {

}
