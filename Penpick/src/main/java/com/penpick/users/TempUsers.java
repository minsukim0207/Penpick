package com.penpick.users;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TempUsers {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE/*, generator="unuser_seq"*/)
	//@SequenceGenerator(name="unuser_seq",	sequenceName="unuser_seq", allocationSize=1)
	private int tempuserNum;
	private String tempuserPhone;
	private String tempuserPw;
	
}
