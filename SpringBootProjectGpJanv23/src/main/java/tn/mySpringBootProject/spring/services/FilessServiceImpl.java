package tn.mySpringBootProject.spring.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tn.mySpringBootProject.spring.entities.Filess;
import tn.mySpringBootProject.spring.repository.FilessRepository;

@Service
public class FilessServiceImpl implements IFilessService {

	@Autowired
	FilessRepository fileRepo;
	
	@Override
	public Filess addFile(MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		
		//System.out.println("file size"+ file.getSize());
		System.out.println("origin file size second meth"+ file.getBytes().length);
		
		Filess filee= new Filess(file.getOriginalFilename(), file.getContentType(),compressBytes(file.getBytes()));
		
		String pathf ="D:/Works/fullStackDev/FrontEnd/MyAngularProjects/formationAngularGrpJanv/src/assets/FilesFront/";
		
		Path path =	Paths.get(pathf+file.getOriginalFilename());
		
		Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		
	
		
		return fileRepo.save(filee);
	}

	// compress the image bytes before storing it in the database
				public static byte[] compressBytes(byte[] data) {
					Deflater deflater = new Deflater();
					deflater.setInput(data);
					deflater.finish();
					ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
					byte[] buffer = new byte[1024];
					while (!deflater.finished()) {
						int count = deflater.deflate(buffer);
						outputStream.write(buffer, 0, count);
					}
					try {
						outputStream.close();
					} catch (IOException e) {
					}
					System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
					return outputStream.toByteArray();
				}
				// uncompress the image bytes before returning it to the angular application
				public static byte[] decompressBytes(byte[] data) {
					Inflater inflater = new Inflater();
					inflater.setInput(data);
					ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
					byte[] buffer = new byte[1024];
					try {
						while (!inflater.finished()) {
							int count = inflater.inflate(buffer);
							outputStream.write(buffer, 0, count);
						}
						outputStream.close();
					} catch (IOException ioe) {
					} catch (DataFormatException e) {
					}
					return outputStream.toByteArray();
				}
	
}
