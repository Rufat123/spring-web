package az.developia.springdemo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import az.developia.springdemo.model.Book;

@Transactional
public interface BookRepository extends JpaRepository<Book, Integer> {

	public List<Book> findByName(String name);
	
	@Query(value="select * from books where concat (name ,publish_date) like %?1%",nativeQuery = true)
	public List<Book> findByNameNative(String name);
	
	@Query(value="delete from books where name=?1",nativeQuery = true)
	@Modifying
	public void deleteByNameNative(String name);
	
}
