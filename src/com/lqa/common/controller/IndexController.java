package com.lqa.common.controller;

import com.jfinal.core.Controller;

/**
 * IndexController
 */
public class IndexController extends Controller {
	
	public void index() {
		renderFreeMarker("admin.ftl");
	}
	
	
}





