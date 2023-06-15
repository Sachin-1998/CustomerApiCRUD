package com.it.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.it.validation.DateOfBirthValid;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformationDto 
{
	private Integer id;
	@Size(min = 1, max = 1)
    @Pattern(regexp = "^(M|F)$", message = "Sex should be either 'M' or 'F'")    
	private String gender;
    @Past(message = "DOB should be in the past and before 01-01-2002")    
    @DateOfBirthValid("2002-01-01")	
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private LocalDate dob;
	private String nativePlace;
	

}
