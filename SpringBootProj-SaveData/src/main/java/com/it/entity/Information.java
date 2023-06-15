package com.it.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.it.validation.DateOfBirthValid;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Customer_Info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Information {
	@Id
	@SequenceGenerator(name="details1",sequenceName = "Info_Id_SEQ",initialValue = 500,allocationSize = 1)
	@GeneratedValue(generator = "details1",strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Column(name = "Gender_Type")
	@Size(min = 1, max = 1)
	@Pattern(regexp = "^(M|F)$", message = "Sex should be either 'M' or 'F'")
    private String gender;
	@DateOfBirthValid("2002-01-01")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "Date_Of_Birth")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate dob;
	@Column(name = "Native_Place", length = 15)
	private String nativePlace;

}
