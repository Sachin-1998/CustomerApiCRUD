package com.it.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Customer_Data")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Customer {
	@Id
	@SequenceGenerator(name="cust1",sequenceName = "Cust_Id_SEQ",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator = "cust1",strategy = GenerationType.SEQUENCE)
	private Integer customerId;
	@Column(name="Customer_Name")
	private String name;
	@Column(length = 15)
	private String accountType;
	private String businessRequirements[];
	@Column(length = 20)
	private String contractType;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id", referencedColumnName = "id")
   	private Information details;

}
