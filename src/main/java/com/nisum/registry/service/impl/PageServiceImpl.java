package com.nisum.registry.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

import com.nisum.registry.controller.RegistryController;
import com.nisum.registry.dao.PageDao;
import com.nisum.registry.model.Page;
import com.nisum.registry.service.PageService;

@SuppressWarnings("unchecked")
public class PageServiceImpl implements PageService {

	@Autowired
	PageDao pageDao;

	@Value("${output.folder}")
	private String outputFolder;

	private static final Logger logger = Logger
			.getLogger(PageServiceImpl.class);

	@Override
	public String save(String username, String name, String source) {
		System.out.println("PageServiceImpl.save()");
		System.out.println(outputFolder);
		String path = saveSourceToFile(username, name, source);
		return pageDao.save(name, path);
	}

	private String saveSourceToFile(String username, String name, String source) {

		String filePath = outputFolder + username + "/ " + name + ".html";
		try {
			FileUtils.writeStringToFile(new File(filePath), source);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filePath;
	}

	@Override
	public String getPages() {
		List<Page> pages = pageDao.getPages();

		JSONArray jsonArray = new JSONArray();
		for (Iterator<Page> iterator = pages.iterator(); iterator.hasNext();) {
			Page page = (Page) iterator.next();
			JSONObject json = new JSONObject();
			json.put("name", page.getName());
			json.put("source", page.getSource());
			json.put("id", page.getId());
			jsonArray.add(json);
		}

		return jsonArray.toJSONString();

	}

	@Override
	public String getPageByName(String name) {
		List<Page> pages = pageDao.getPageByName(name);

		JSONArray jsonArray = new JSONArray();
		for (Iterator<Page> iterator = pages.iterator(); iterator.hasNext();) {
			Page page = (Page) iterator.next();
			JSONObject json = new JSONObject();
			json.put("name", page.getName());
			json.put("source", page.getSource());
			json.put("id", page.getId());
			jsonArray.add(json);
		}
		return jsonArray.toJSONString();
	}

}
