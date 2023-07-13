package com.madhav.SpringBoot;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student {
	
	//to show that the value below the annotation in case of this example "rollID" is the primary key of the database;
	@Id
	@Column(name = "rollID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rollID;
	
	@Column(name = "name")
	private String name;
}
