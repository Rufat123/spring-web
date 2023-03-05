package az.developia.springdemo.model;

import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import az.developia.springdemo.validation.java3;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
	private Integer id;
	
	@Size(min = 2, message = "Ad min 2 sinvol olmalididr")
	@Size(max = 20, message = "Ad max 20 sinvol olmalididr")
	@NotBlank(message = "Bos qoymaq olmaz")
	@java3
	private String name;
	@Size(min = 2, message = "Soyad min 2 sinvol olmalididr")
	@Size(max = 20, message = "Soyad max 25 sinvol olmalididr")
	@NotBlank(message = "Bos qoymaq olmaz")
	private String surname;
	@Past
	private Date brithday;
	@Pattern(regexp = "[a-z0-9A-Z._-]+@[a-z]+\\.[a-z]{2,4}", message="Emaili duz yazin")
	private String email;
	@Pattern(regexp = "\\+[0-9]{3}-[0-9]{2}-[0-9]{3}-[0-9]{4}", message="Telefon nomresini duzgun yazin")
	private String phone;
	
	
	
	
}
