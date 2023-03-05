package tn.mySpringBootProject.spring.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import tn.mySpringBootProject.spring.entities.Filess;

public interface IFilessService {

	
	public Filess addFile(MultipartFile file) throws IOException;
}
