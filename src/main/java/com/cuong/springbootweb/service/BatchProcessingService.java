package com.cuong.springbootweb.service;

import com.cuong.springbootweb.model.Book;
import com.cuong.springbootweb.model.Publisher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class BatchProcessingService {
    //Tùy biến JPA bằng cách sử dụng
    //EntityManager, JPARepository mặc định ko hỗ trợ BatchProcessing nếu muốn sử dụng thì cần tùy biến trong application

    @PersistenceContext
    private EntityManager entityManager;

    //Thực hiện 1 giao dịch kiểu ACID
    @Transactional
    public void batchInsertBooks() {
        Publisher publisher1 = entityManager.find(Publisher.class, 1L);
        Publisher publisher2 = entityManager.find(Publisher.class, 2L);
        Set<Publisher> publishers = new HashSet<>();

        publishers.add(publisher1);
        publishers.add(publisher2);

        for (int i = 0; i < 2000; i++) {
            Book book = new Book();
            book.setName("Book " + i);
            book.setPublishers(publishers);
            entityManager.persist(book);
            if (i % 1 == 0) {
                entityManager.flush(); //Release memory
            }
        }
    }

}
