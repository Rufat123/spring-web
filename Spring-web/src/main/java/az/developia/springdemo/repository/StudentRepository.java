package az.developia.springdemo.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import az.developia.springdemo.model.Student;
@Repository
public class StudentRepository {
	@Autowired
	private DataSource dataSource;

	public List<Student> getStudents(){
	List<Student> students = new ArrayList<Student>();
	try {
		Connection conn = dataSource.getConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from students");
		while(rs.next()) {
			Student s = new Student(rs.getInt("id"), rs.getString("name"),
					rs.getString("surname"), rs.getDate("brithday"), rs.getString("email"), rs.getString("phone"));
			students.add(s);
		}
		st.close();
		rs.close();
		conn.close();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return students;
	}
	
	public void save(Student s) {
		try {
			Connection conn = dataSource.getConnection();
			Statement st = conn.createStatement();
			st.executeUpdate("insert into students (name,surname,brithday,email,phone)"+ 
			"values('"+s.getName()+"','"+s.getSurname()+"','"+s.getBrithday()+"', '"+s.getEmail()+"','"+s.getPhone()+"')");
			st.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	


	public void deletById(Integer id) {
		try {
			Connection conn = dataSource.getConnection();
			Statement st = conn.createStatement();
			st.executeUpdate("delete from students where id =" + id);
			st.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public Student findById(Integer id) {
		Student student= null;
		try {
			Connection conn = dataSource.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from students where id="+id);
			if(rs.next()) {
				student = new Student(rs.getInt("id"),rs.getString("name"),
						rs.getString("surname"),rs.getDate("brithday"), rs.getString("email"),rs.getString("phone"));
			}
			rs.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	public void edit(Student s) {
		try {
			Connection conn = dataSource.getConnection();
			Statement st = conn.createStatement();
			st.executeUpdate("update students set name='"+s.getName()+"',surname='"+s.getSurname()+"',"
					+ "brithday='"+s.getBrithday()+"', email='"+s.getEmail()+"', phone='"+s.getPhone()+"' where id="+ s.getId());
			st.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Student> searchStudents(String name) {

		List<Student> students = new ArrayList<Student>();
		try {
			Connection conn = dataSource.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from students where name='"+name+"'");
			while(rs.next()) {
				Student s = new Student(rs.getInt("id"), rs.getString("name"),
						rs.getString("surname"), rs.getDate("brithday"), rs.getString("email"), rs.getString("phone"));
				students.add(s);
			}
			st.close();
			rs.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return students;
		
	}


}
