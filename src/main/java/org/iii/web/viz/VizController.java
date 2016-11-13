package org.iii.web.viz;

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
public class VizController {
	@Resource(name = "VizService")
	VizService VizService;
	
	@RequestMapping(value = "/viz", method = RequestMethod.GET)
	public ModelAndView commonPage(HttpServletRequest request,
			HttpServletResponse response) {
		
		ModelAndView model = new ModelAndView();

		//String tsvString = "letter\tfrequency\tA\t.08167\tB\t.01492\tC\t.02782";
		//model.addObject("tsvdata", tsvString);
		
		model.setViewName("d3example/example1");
		
		return model;

	}
		
	@RequestMapping(value = {"/JSON/accounts.tsv"}, method = RequestMethod.GET, produces = {"application/text;charset=UTF-8"})
	public @ResponseBody String report_json(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException,JSONException{

		String tsvString = "letter\tfrequency\nA\t.08167\nB\t.01492\nC\t.02782\n";
		return tsvString;
		
	}

}