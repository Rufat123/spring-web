package az.developia.springdemo.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import az.developia.springdemo.model.Car;

@Repository
public class CarRepository {

	@Autowired
	private DataSource dataSource;

	public List<Car> getCars() {
		List<Car> cars = new ArrayList<Car>();
		try {
			Connection conn = dataSource.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from cars");
			while (rs.next()) {
				Car c = new Car(rs.getInt("id"), rs.getString("brand"), rs.getInt("speed"), rs.getString("color"),
						rs.getInt("price"));
				c.setMadeDate(rs.getDate("made_date"));
				cars.add(c);

			}
			rs.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cars;
	}

	public void save(Car c) {
		try {
			Connection conn = dataSource.getConnection();
			Statement st = conn.createStatement();

			st.executeUpdate("insert into cars (brand,speed,color,price,made_date)" + "values('" + c.getBrand() + "',"
					+ c.getSpeed() + ",'" + c.getColor() + "'," + c.getPrice() + ",'"+c.getMadeDate()+"');");
			st.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteById(Integer id) {

		try {
			Connection conn = dataSource.getConnection();
			Statement st = conn.createStatement();

			st.executeUpdate("delete from cars where id =" + id);
			st.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Car findById(Integer id) {
		Car car = null;
		try {
			Connection conn = dataSource.getConnection();
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("select * from cars where id=" + id);
			if (rs.next()) {
				car = new Car(rs.getInt("id"), rs.getString("brand"), rs.getInt("speed"), rs.getString("color"),
						rs.getInt("price"));
				car.setMadeDate(rs.getDate("made_date"));
			}
			rs.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return car;
	}

	public void edit(Car c) {
		try {
			Connection conn = dataSource.getConnection();
			Statement st = conn.createStatement();

			st.executeUpdate("update cars set brand='" + c.getBrand() + "',speed='" + c.getSpeed() + "',color='"
					+ c.getColor() + "',price='" + c.getPrice() + "', made_date='"+c.getMadeDate()+"' where id=" + c.getId());
			st.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Car> searchCars(String brand) {

		List<Car> cars = new ArrayList<Car>();
		try {
			Connection conn = dataSource.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from cars where brand= '"+brand+"'");
			while (rs.next()) {
				Car c = new Car(rs.getInt("id"), rs.getString("brand"), rs.getInt("speed"), rs.getString("color"),
						rs.getInt("price"));
				c.setMadeDate(rs.getDate("made_date"));
				cars.add(c);

			}
			rs.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cars;
	
	}

}
