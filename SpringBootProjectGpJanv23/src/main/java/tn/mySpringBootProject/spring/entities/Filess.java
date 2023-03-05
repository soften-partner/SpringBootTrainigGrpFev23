package tn.mySpringBootProject.spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Filess {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idfile;
	private String filetitle;
	private String fileType;
	
	@Column(length = 420000)
	private byte[] filesize;
	
	@OneToOne(mappedBy ="file")
	private User user;

	public Filess(String filetitle, String fileType, byte[] filesize) {
		super();
		this.filetitle = filetitle;
		this.fileType = fileType;
		this.filesize = filesize;
	}
	

}
