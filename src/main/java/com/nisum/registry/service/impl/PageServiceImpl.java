package com.nisum.registry.service.impl;

import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.nisum.registry.dao.PageDao;
import com.nisum.registry.model.Page;
import com.nisum.registry.service.PageService;

@SuppressWarnings("unchecked")
public class PageServiceImpl implements PageService {

	@Autowired
	PageDao pageDao;

	@Override
	public String save(String name, String code) {
		return pageDao.save(name, code);
	}

	@Override
	public String getPages() {
		List<Page> pages = pageDao.getPages();

		JSONArray jsonArray = new JSONArray();
		for (Iterator<Page> iterator = pages.iterator(); iterator.hasNext();) {
			Page page = (Page) iterator.next();
			JSONObject json = new JSONObject();
			json.put("name", page.getName());
			json.put("code", page.getCode());
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
			json.put("code", page.getCode());
			json.put("id", page.getId());
			jsonArray.add(json);
		}
		return jsonArray.toJSONString();
	}

}
