package com.demo.vlada.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.vlada.dto.FileEDto;
import com.demo.vlada.entities.FileE;
import com.demo.vlada.services.FileService;
import com.demo.vlada.util.UtilHelper;

@RestController
@RequestMapping(value="/rest")
public class IndexController {
	
	@Autowired
	private FileService fileService;
	
	@RequestMapping(method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<List<FileE>> allFiles() {
		return new ResponseEntity<List<FileE>>(fileService.getFiles(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/calculate", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public ResponseEntity<Float> calculateResult(@RequestBody FileEDto fileDto) {
		return new ResponseEntity<Float>(UtilHelper.calculateNetSalary(fileDto.getGrossSalary(), fileDto.getFile().getName()), HttpStatus.OK);
	}
	
}
