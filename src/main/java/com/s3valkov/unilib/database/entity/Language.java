package com.s3valkov.unilib.database.entity;

import com.s3valkov.unilib.database.entity.common.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "languages")
public class Language extends BaseEntity {

    @Column(name = "language", nullable = false, unique = true)
    private String language;
}
