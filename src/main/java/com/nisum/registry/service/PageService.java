package com.nisum.registry.service;

public interface PageService {

	boolean save(String username, String name, String source);

	String getPages();

	String getPageByName(String name);

}
