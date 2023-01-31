package com.chanakya.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chanakya.springboot.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long>{

}
