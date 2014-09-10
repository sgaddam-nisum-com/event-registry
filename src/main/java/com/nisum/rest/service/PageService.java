package com.nisum.rest.service;

public interface PageService {

	String save(String name, String code);

	String getPages();

	String getPageByName(String name);

}
