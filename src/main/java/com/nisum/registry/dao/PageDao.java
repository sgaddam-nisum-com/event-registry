package com.nisum.registry.dao;

import java.util.List;

import com.nisum.registry.model.Page;

public interface PageDao {

	boolean save(String username, String name, String path);

	List<Page> getPageByName(String username, String name);

	List<Page> getPages(String username);

}