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

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Filee {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idfile;
	private String filetitle;
	private String filetype;
	
	@Column(length = 420000)
	private byte[] filesize;
	
	@OneToOne(mappedBy = "filee")
	private User user;

	public Filee(String filetitle, String filetype, byte[] filesize) {
		super();
		this.filetitle = filetitle;
		this.filetype = filetype;
		this.filesize = filesize;
	}
	
	
	
}
