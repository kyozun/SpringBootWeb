package com.cuong.springbootweb.repository;

import com.cuong.springbootweb.model.BookPublisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BookPublisherRepository extends JpaRepository<BookPublisher, Integer> {
}
