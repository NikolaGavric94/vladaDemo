package com.demo.vlada.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.vlada.dto.FileEDto;
import com.demo.vlada.dto.TextAreaDto;
import com.demo.vlada.entities.FileE;
import com.demo.vlada.network.Response;
import com.demo.vlada.services.FileService;
import com.demo.vlada.util.UtilHelper;

@RestController
@RequestMapping(value="/rest")
public class IndexController {
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private Environment env;
	
	@RequestMapping(value="/files", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<List<FileE>> allFiles() {
		return new ResponseEntity<List<FileE>>(fileService.getFiles(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/calculate", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public ResponseEntity<Response> calculateResult(@RequestBody FileEDto fileDto) {
		FileE file = fileService.getFileById(fileDto.getFileId());
		return new ResponseEntity<Response>(new Response(UtilHelper.calculateNetSalary(fileDto.getGrossSalary(), file.getName())), HttpStatus.OK);
	}
	
	@RequestMapping(value="/executeTextArea", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public ResponseEntity<Response> executeTextArea(@RequestBody TextAreaDto text) {
		return new ResponseEntity<Response>(new Response(UtilHelper.executeTextArea(text)), HttpStatus.OK);
	}
	
	@RequestMapping(value="/executeFile/{id}", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public ResponseEntity<Response> executeFiles(@PathVariable(value="id") Integer fileId) {
		FileE file = fileService.getFileById(fileId);
		return new ResponseEntity<Response>(new Response(UtilHelper.executeFiles(file)), HttpStatus.OK);
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public ResponseEntity<Response> uploadFile(@RequestParam(name="file") MultipartFile file) {
		if (!file.isEmpty())
            return this.upload(file);
        return new ResponseEntity<Response>(new Response("Unable to upload. File is empty."), HttpStatus.EXPECTATION_FAILED);
	}
	
	@RequestMapping(value="/addFile", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public ResponseEntity<Response> addFile(@RequestBody FileE file) {
		if(!fileService.isFile(file)) {
			fileService.saveOrUpdate(file);
			return new ResponseEntity<Response>(new Response("File successfully added."), HttpStatus.OK);
		}
		return new ResponseEntity<Response>(new Response("File already exists with that name!"), HttpStatus.IM_USED);
	}
	
	@RequestMapping(value="/editFile", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public ResponseEntity<Response> editFile(@RequestBody FileE file) {
		fileService.saveOrUpdate(file);
		return new ResponseEntity<Response>(new Response("File successfully updated."), HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public ResponseEntity<Response> deleteFile(@PathVariable(value="id") Integer fileId) {
		FileE file = fileService.getFileById(fileId);
		fileService.remove(file);
		return new ResponseEntity<Response>(new Response("File successfully removed."), HttpStatus.OK);
	}
	
	private ResponseEntity<Response> upload(MultipartFile file) {
		try {
            String fileName = file.getOriginalFilename();
            byte[] bytes = file.getBytes();
            BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File(env.getProperty("upload.path")+fileName)));
            buffStream.write(bytes);
            buffStream.close();
            return new ResponseEntity<Response>(new Response("You have successfully uploaded " + fileName), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Response>(new Response("You failed to upload a file: " + e.getMessage()), HttpStatus.EXPECTATION_FAILED);
        }
	}
}
