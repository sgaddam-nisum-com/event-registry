package com.nisum.rest.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nisum.rest.model.Page;

public class PageRowMapper implements RowMapper<Page> {
	public Page mapRow(ResultSet rs, int rowNum) throws SQLException {
		Page page = new Page();
		page.setName(rs.getString("name"));
		page.setCode(rs.getString("path"));
		page.setId(rs.getInt("id"));
		return page;
	}
}
