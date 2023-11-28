package com.s3valkov.unilib.dto.binding;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.List;

public class BookBindingModel {

    @NotNull(message = "Title cannot be null")
    private String title;

    @NotNull(message = "Category cannot be null")
    private CategoryBindingModel category;

    @NotNull(message = "Author cannot be null")
    private List<AuthorBingingModel> author;

    private int copies;

    @NotNull(message = "Language cannot be null")
    private LanguageBindingModel language;

    @NotEmpty(message = "Description cannot be blank")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CategoryBindingModel getCategory() {
        return category;
    }

    public void setCategory(CategoryBindingModel category) {
        this.category = category;
    }

    public List<AuthorBingingModel> getAuthor() {
        return author;
    }

    public void setAuthor(List<AuthorBingingModel> author) {
        this.author = author;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public LanguageBindingModel getLanguage() {
        return language;
    }

    public void setLanguage(LanguageBindingModel language) {
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
