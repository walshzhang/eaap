package iteach.eaap.architecturestyles.layer.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import iteach.eaap.architecturestyles.layer.domain.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
