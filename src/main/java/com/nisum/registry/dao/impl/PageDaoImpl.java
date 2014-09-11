package com.nisum.registry.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.nisum.registry.dao.PageDao;
import com.nisum.registry.model.Page;

public class PageDaoImpl implements PageDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public String save(String name, String path) {
		String sql = "INSERT INTO page (name, path) VALUES (?, ?) on duplicate key update path = values(path)";
		int r = 0;
		try {
			r = jdbcTemplate.update(sql, new Object[] { name, path });
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return String.valueOf(r);
	}

	@Override
	public List<Page> getPageByName(String name) {
		String sql = "SELECT * FROM page WHERE name = ?";
		List<Page> pages = jdbcTemplate.query(sql, new Object[] { name },
				new PageRowMapper());
		return pages;
	}

	@Override
	public List<Page> getPages() {
		String sql = "SELECT * FROM page";
		List<Page> pages = jdbcTemplate.query(sql, new PageRowMapper());
		return pages;
	}

}