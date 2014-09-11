package com.nisum.registry.dao;

import java.util.List;

import com.nisum.registry.model.Page;

public interface PageDao {

	String save(String name, String path);

	List<Page> getPageByName(String name);

	List<Page> getPages();

}