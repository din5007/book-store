package com.bnpp.bookstore.repository;

import com.bnpp.bookstore.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
  @Query(
    nativeQuery = true,
    value = "select * from books " +
    "where (:#{@queryUtil.checkNull(#title)} = true or title like :title)"
  )
  Page<Book> findByTitle(@Param("title") String title, Pageable pageable);
}
