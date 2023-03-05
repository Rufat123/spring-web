package az.developia.springdemo.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springdemo.model.Author;


public interface AuthorRepository extends JpaRepository<Author, Integer> {


}
