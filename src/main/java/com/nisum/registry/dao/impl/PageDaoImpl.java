package com.nisum.registry.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.nisum.registry.dao.PageDao;
import com.nisum.registry.model.Page;

public class PageDaoImpl implements PageDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final Logger logger = Logger.getLogger(PageDaoImpl.class);

	@Override
	public boolean save(String username, String name, String path) {
		boolean status = false;
		String sql = "INSERT INTO page (username, name, path) VALUES (?, ?, ?) on duplicate key update path = values(path)";
		int r = 0;
		try {
			r = jdbcTemplate.update(sql, new Object[] { username, name, path });
			status = true;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return status;
		}

		return status;
	}

	@Override
	public List<Page> getPageByName(String username, String name) {
		String sql = "SELECT * FROM page WHERE username = ? and name = ?";
		List<Page> pages = jdbcTemplate.query(sql, new Object[] { username,
				name }, new PageRowMapper());
		return pages;
	}

	@Override
	public List<Page> getPages(String username) {
		String sql = "SELECT * FROM page where username = ?";
		List<Page> pages = jdbcTemplate.query(sql, new Object[] { username },
				new PageRowMapper());
		return pages;
	}

}