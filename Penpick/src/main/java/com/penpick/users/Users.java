package com.penpick.users;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.penpick.qna.question.Question;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Users {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_seq")
	@SequenceGenerator(name="user_seq",	sequenceName="user_seq", allocationSize=1)
	private int userNum;
	
	private String userEmail;
	
	private String userPw;

	private String userNickname;

	private String userBirth;

	private String userPhone;

	private Date userDate;

	private String userGender;

	private String point;

	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Question> questions = new ArrayList<>();

	@Builder
	public Users(String userEmail, String userPw, String userNickname, String userBirth, String userPhone, Date userDate, String userGender, String point) {
		this.userEmail = userEmail;
		this.userPw = userPw;
		this.userNickname = userNickname;
		this.userBirth = userBirth;
		this.userPhone = userPhone;
		this.userDate = userDate;
		this.userGender = userGender;
		this.point = point;
	}
}
