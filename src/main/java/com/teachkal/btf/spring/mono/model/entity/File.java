package com.teachkal.btf.spring.mono.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.teachkal.btf.spring.mono.config.AppSettings;
import com.teachkal.btf.spring.mono.model.FileType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(
        name = "files",
        uniqueConstraints = {
                @UniqueConstraint(name = "documents_name_unique", columnNames = "name")
        })
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Lob

    @Column(name = "data")
    private byte[] data;

    @Column(name = "size")
    private long size;

    @Enumerated(EnumType.STRING)
    private FileType fileType;

    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = AppSettings.DATE_TIME_FORMAT)
    @Column(name = "created_at", insertable = false, updatable = false,
            columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
    )
    private LocalDateTime createdAt;


}
