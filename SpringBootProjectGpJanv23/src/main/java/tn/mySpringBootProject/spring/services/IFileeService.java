package tn.mySpringBootProject.spring.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import tn.mySpringBootProject.spring.entities.Filee;

public interface IFileeService {

	public Filee addFile(MultipartFile file) throws IOException;
}
