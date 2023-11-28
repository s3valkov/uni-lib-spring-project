package com.s3valkov.unilib.database.entity;

import com.s3valkov.unilib.database.entity.common.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @Column(name = "category", unique = true, nullable = false)
    private String category;

    @Column(name = "image_source", nullable = false, unique = true)
    private String imageSource;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }
}
