package com.nisum.rest.dao;

import java.util.List;

import com.nisum.rest.model.Page;

public interface PageDao {

	String save(String name, String code);

	List<Page> getPageByName(String name);

	List<Page> getPages();

}