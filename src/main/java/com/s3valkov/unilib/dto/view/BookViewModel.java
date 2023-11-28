package com.s3valkov.unilib.dto.view;

import java.util.List;

public class BookViewModel {

    private Long id;
    private String title;
    private CategoryViewModel categoryViewModel;
    private List<AuthorViewModel> authorViewModels;
    private int copies;
    private LanguageViewModel languageViewModel;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CategoryViewModel getCategoryViewModel() {
        return categoryViewModel;
    }

    public void setCategoryViewModel(CategoryViewModel categoryViewModel) {
        this.categoryViewModel = categoryViewModel;
    }

    public List<AuthorViewModel> getAuthorViewModels() {
        return authorViewModels;
    }

    public void setAuthorViewModels(List<AuthorViewModel> authorViewModels) {
        this.authorViewModels = authorViewModels;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public LanguageViewModel getLanguageViewModel() {
        return languageViewModel;
    }

    public void setLanguageViewModel(LanguageViewModel languageViewModel) {
        this.languageViewModel = languageViewModel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
