package az.developia.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.springdemo.model.Car;
import az.developia.springdemo.repository.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;

	public List<Car> getAllCars() {
		return carRepository.getCars();
	}

	public void save(Car c) {
		carRepository.save(c);
	}

	public void deleteById(Integer id) {
		carRepository.deleteById(id); 
	}
	
	public Car findById(Integer id) {
		return carRepository.findById(id);
	}

	public void edit(Car c) {
		carRepository.edit(c);
		
	}

	public Object searchCars(String brand) {
		return carRepository.searchCars(brand);
	}
	
}
