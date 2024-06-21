package com.cuong.springbootweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.concurrent.Flow;

public interface PublisherRepository extends JpaRepository<Flow.Publisher, Integer> {
}
