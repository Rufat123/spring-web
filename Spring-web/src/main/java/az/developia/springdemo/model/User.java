package az.developia.springdemo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Size(min=2,message="Istifadeci adi minimum 3 sinvol olmalididr")
	@Size(max=20,message="Istifadeci adi maxsimum 20 sinvol olmalididr")
	@NotBlank(message="Bos qoymaq olmaz")
	private String username;
	
	@Size(min=2,message="Istifadeci parolu minimum 8 sinvol olmalididr")
	@Size(max=20,message="Istifadeci adi maxsimum 100 sinvol olmalididr")
	@NotBlank(message="Bos qoymaq olmaz")
	private String password;
}
