package com.selva.securityjwt.service;

import com.selva.securityjwt.model.Bookmark;
import com.selva.securityjwt.repository.BookmarkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookmarkService {

    public final BookmarkRepository bookmarkRepository;

    public BookmarkService(BookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }

    public List<Bookmark> getAllBookmarks() {
        return bookmarkRepository.findAllByOrderByCreatedAtDesc();
    }
}
