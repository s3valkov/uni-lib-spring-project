package com.s3valkov.unilib.database.entity;

import com.s3valkov.unilib.database.entity.common.BaseEntity;
import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "books")
public class Book extends BaseEntity {

    @Column(name = "title", nullable = false)
    private String title;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ManyToMany(targetEntity = Author.class, fetch = FetchType.EAGER)
    @JoinTable(
            name = "author_books",
            joinColumns = @JoinColumn(
                    name = "author_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "book_id",
                    referencedColumnName = "id"
            )
    )
    private List<Author> author;

    @Column(name = "copies", nullable = false)
    private int copies;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "language_id", referencedColumnName = "id")
    private Language language;

    @Column(name = "description", nullable = false)
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
