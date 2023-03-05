package az.developia.springdemo.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
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

import az.developia.springdemo.model.Car;
import az.developia.springdemo.service.CarService;

@Controller
@RequestMapping("/cars")
public class CarController {

	@Autowired
	private CarService carService;

	@GetMapping("/list")
	@PreAuthorize(value="hasAuthority('list:cars')")
	public String showCarsPage(Model model) {
		model.addAttribute("cars", carService.getAllCars());
		
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		model.addAttribute("username", name);
		return "cars";
	}
	@GetMapping("/show-save-page")
	public String showSavePage(Model model) {
		Car c = new Car();
		model.addAttribute("car",c);
		model.addAttribute("header","Yeni qeydiyyat");
		return"car-save";
	}
	
	@PostMapping("/save")
	public String carSave(
			@Valid @ModelAttribute(name = "car") Car c,
			BindingResult br
			) {
		if (br.hasErrors()) {
			return "car-save";
		}
		
		if (c.getId()==null) { 
			carService.save(c);
		} else {
			carService.edit(c);
		} 
		return "redirect:/cars/list";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		carService.deleteById(id);
		return"redirect:/cars/list";
	}
	
	@GetMapping("/edit/{id}")
	public String showEditPage(@PathVariable Integer id,Model model) {
		Car c = carService.findById(id);
		model.addAttribute("car",c);
		model.addAttribute("header","Mashin Redaktesi");
		return"car-save";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam(name="brand")String brand,Model model) {
		model.addAttribute("cars", carService.searchCars(brand));
		return "cars";
	}
	
	
	@InitBinder
	private void initBinder(WebDataBinder editor) {
		StringTrimmerEditor e =new StringTrimmerEditor(false);
		editor.registerCustomEditor(String.class, e);
	}
	
	
}
