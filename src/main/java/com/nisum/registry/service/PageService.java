package com.nisum.registry.service;

public interface PageService {

	String save(String username, String name, String code);

	String getPages();

	String getPageByName(String name);

}
