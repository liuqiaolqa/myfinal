package com.lqa.common.util;

import com.jfinal.config.Routes;
import com.lqa.common.controller.IndexController;
import com.lqa.common.controller.LoginController;
import com.lqa.ucenter.controller.UserController;

public class BackRoutes extends Routes {
	
	public void config() {
		add("/", IndexController.class, "/WEB-INF/view/back/index");	
		add("/login", LoginController.class,"/WEB-INF/view/back/login");		
		add("/user", UserController.class,"/WEB-INF/view/back/user");		
	}

}
