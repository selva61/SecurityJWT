package com.selva.securityjwt.repository;

import com.selva.securityjwt.model.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookmarkRepository extends JpaRepository<com.selva.securityjwt.model.Bookmark, Long> {
  List<Bookmark> findAllByOrderByCreatedAtDesc();
}