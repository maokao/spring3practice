package org.iii.web.student;

import java.util.List;

import javax.inject.Inject;

import org.iii.web.login.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import javax.inject.Inject;
import org.springframework.stereotype.Service;

@Service("StudentService")
public class StudentService {
	
	@Inject
	private StudentRepository studentRepository;
	
	public String getUserName(String username) {
		
		return "";
		
	}

	public void insertUser(String name, int score) {
		// TODO Auto-generated method stub
		int updateCount = studentRepository.insertUser(name, score);
	}

	public List getallUserinfo() {
		// TODO Auto-generated method stub
		List alluserinfo = studentRepository.selectallUsers();
		return alluserinfo;
	}
	
}
