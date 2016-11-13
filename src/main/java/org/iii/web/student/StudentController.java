package org.iii.web.student;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
	@Resource(name = "StudentService")
	StudentService StudentService;
	

	@RequestMapping(value = "/show", method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
	public ModelAndView showstudent(HttpServletRequest request,
			HttpServletResponse response) {
		
		ModelAndView model = new ModelAndView();

		List alluserinfo = StudentService.getallUserinfo();
		model.addObject("alluserinfo", alluserinfo);
		
		model.setViewName("student/show");
		
		return model;

	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public ModelAndView commonPage(HttpServletRequest request,
			HttpServletResponse response) {
		
		ModelAndView model = new ModelAndView();

		model.setViewName("student/insert");
		
		return model;

	}
	
	@RequestMapping(value = "/insertpage", method = RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public ModelAndView insertPage(HttpServletRequest request,
			HttpServletResponse response) {
		
		ModelAndView model = new ModelAndView();
		
		String name = (String) request.getParameter("name");
		int score = Integer.valueOf(request.getParameter("score"));

		StudentService.insertUser(name,score);
		System.out.println("insert a student");
				
		List alluserinfo = StudentService.getallUserinfo();
		model.addObject("alluserinfo", alluserinfo);
		
		model.setViewName("student/show");
		
		return model;

	}
		
}