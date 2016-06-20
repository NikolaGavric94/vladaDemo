package com.demo.vlada.dto;

import com.demo.vlada.entities.FileE;

public class FileEDto {
	private Float grossSalary;
	private FileE file;
	
	public Float getGrossSalary() {
		return grossSalary;
	}
	public void setGrossSalary(Float grossSalary) {
		this.grossSalary = grossSalary;
	}
	public FileE getFile() {
		return file;
	}
	public void setFile(FileE file) {
		this.file = file;
	}
}
