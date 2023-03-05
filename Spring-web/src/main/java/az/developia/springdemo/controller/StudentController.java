package az.developia.springdemo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import az.developia.springdemo.model.Student;
import az.developia.springdemo.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/list")
	//@PreAuthorize(value="hasAuthority('list:students')")
	public String showStudentPage(Model model) {
		model.addAttribute("students", studentService.getALLStudents());
		return "students";
	}

	@GetMapping("/show-save-page")
	@PreAuthorize(value="hasAuthority('show-save-page:students')")
	public String showSavePage(Model model) {
		Student s = new Student();
		model.addAttribute("student", s);
		model.addAttribute("header", "Yeni qeydiyyat");
		return "student-save";
	}

	@PostMapping("/save")
	@PreAuthorize(value="hasAuthority('save:students')")
	public String studentSave(@Valid @ModelAttribute(name = "student") Student s,
			BindingResult br) {
		if (br.hasErrors()) {
			return"student-save";
		}
		
		if (s.getId() == null) {
			studentService.save(s);
		}else {
			studentService.edit(s);
		}
		return "redirect:/students/list";
	}
	
	@GetMapping("/delete/{id}")
	@PreAuthorize(value="hasAuthority('delete:students')")
	public String delete(@PathVariable Integer id, Model model) {
		studentService.deleteById(id);
		return "redirect:/students/list";
	}
	
	@GetMapping("/edit/{id}")
	@PreAuthorize(value="hasAuthority('edit:students')")
	public String showEditPage(@PathVariable Integer id, Model model) {
		Student s = studentService.findById(id);
		model.addAttribute("student", s);
		model.addAttribute("header", "Telebe Redaktesi");
		return "student-save";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam(name="name")String name, Model model) {
		model.addAttribute("students", studentService.searchStudents(name));
		return "students";
	}
	
	@InitBinder
	private void initBinder(WebDataBinder editor) {
		StringTrimmerEditor e =new StringTrimmerEditor(false);
		editor.registerCustomEditor(String.class, e);
	}


}
