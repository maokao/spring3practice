package org.iii.web.viz;

import java.util.List;

import javax.inject.Inject;

import org.iii.web.login.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import javax.inject.Inject;
import org.springframework.stereotype.Service;

@Service("VizService")
public class VizService {
	
	@Inject
	private VizRepository vizRepository;
	
	public String getUserName(String username) {
		
		return "";
		
	}
	
}
