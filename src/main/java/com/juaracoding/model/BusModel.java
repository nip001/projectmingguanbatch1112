package com.juaracoding.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="bus")
public class BusModel {
	@Id
	@Column(length = 10)
	private	String noPolisi;
	private	int kapasitas;
	private	String namaSupir;
	private	String namaPerusahaan;
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private	long id;
//	@Column(unique = true,nullable = false)
//	private	String noPolisi;
//	private	int kapasitas;
//	private	String namaSupir;
//	private	String namaPerusahaan;

}
