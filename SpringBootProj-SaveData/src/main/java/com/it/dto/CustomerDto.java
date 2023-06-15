package com.it.dto;

import com.it.entity.Information;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto 
{
	
	private Integer customerId;
	private String name;
	private String accountType;
	private String businessRequirements[];
    @Pattern(regexp = "fulltime|parttime", message = "Contract type must be either fulltime or parttime")
	private String contractType;
    @Valid
	private Information details;


}
