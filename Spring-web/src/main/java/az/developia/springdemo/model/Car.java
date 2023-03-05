package az.developia.springdemo.model;

import java.sql.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import az.developia.springdemo.validation.MustNumber;

public class Car {
private Integer id;
@Size(min=2,message="Marka min 2 sinvol olmalididr")
@Size(max=20,message="Marka max 20 sinvol olmalididr")
@NotBlank(message="Bos qoymaq olmaz")
private String brand;

//@Min(value = 100, message="Suret min 100 olmalidir")
//@Max(value = 500, message="Suret max 500 olmalidir")
//@NotNull(message="Bos qoymaq olmaz")
@MustNumber
private Integer speed;
private String color;
private Integer price;
@Past
private Date madeDate;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public Integer getSpeed() {
	return speed;
}
public void setSpeed(Integer speed) {
	this.speed = speed;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public Integer getPrice() {
	return price;
}
public void setPrice(Integer price) {
	this.price = price;
}

public Car(Integer id, String brand, Integer speed, String color, Integer price) {
	super();
	this.id = id;
	this.brand = brand;
	this.speed = speed;
	this.color = color;
	this.price = price;
}
public Car(){
	
}
@Override
public String toString() {
	return "Car [id=" + id + ", brand=" + brand + ", speed=" + speed + ", color=" + color + ", price=" + price + "]";
}

public Date getMadeDate() {
	return madeDate;
}
public void setMadeDate(Date madeDate) {
	this.madeDate = madeDate;
}



}
