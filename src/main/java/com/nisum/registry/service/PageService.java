package com.nisum.registry.service;

public interface PageService {

	String save(String username, String name, String source);

	String getPages();

	String getPageByName(String name);

}
