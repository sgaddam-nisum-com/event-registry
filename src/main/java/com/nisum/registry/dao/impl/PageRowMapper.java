package com.nisum.registry.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nisum.registry.model.Page;

public class PageRowMapper implements RowMapper<Page> {
	public Page mapRow(ResultSet rs, int rowNum) throws SQLException {
		Page page = new Page();
		page.setName(rs.getString("name"));
		page.setPath(rs.getString("path"));
		page.setId(rs.getInt("id"));
		return page;
	}
}
