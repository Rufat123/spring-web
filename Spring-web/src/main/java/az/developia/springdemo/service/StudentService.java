package az.developia.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.springdemo.model.Student;
import az.developia.springdemo.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getALLStudents() {
		return studentRepository.getStudents();
	}

	public void save(Student s) {
		studentRepository.save(s);
	}

	public void deleteById(Integer id) {
		studentRepository.deletById(id);
		
	}

	public Student findById(Integer id) {
		return studentRepository.findById(id);
	}

	public void edit(Student s) {
		studentRepository.edit(s);
	}

	public Object searchStudents(String name) {
		return studentRepository.searchStudents(name);
	}

}
