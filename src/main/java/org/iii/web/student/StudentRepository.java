package org.iii.web.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;






import javax.inject.Inject;
//import javax.inject.Inject;
import javax.sql.DataSource;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("StudentRepository")
@Transactional
public class StudentRepository {

	private JdbcTemplate jdbcTemplate;

	@Inject	
	public void init(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List selectallUsers() {
		String sql = "SELECT * FROM student_score";
		List<Map<String, Object>> list = this.jdbcTemplate.queryForList(sql);	
		return list;

	}
	
	
	public void deleteUser(String s_id){
		String sql = "DELETE FROM student_score WHERE s_id =?" ; 
		this.jdbcTemplate.update(sql,s_id);	

	}

	public int insertUser(String name, int score) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO student_score(s_name, s_score) VALUE(?,?) ";
		int updateCount = jdbcTemplate.update(sql,
				new Object[] { name, score });
		return updateCount;
	}
	
}
