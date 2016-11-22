package com.lqa.common.util;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.lqa.common.controller.IndexController;
import com.lqa.common.controller.LoginController;
import com.lqa.ucenter.model.User;

public class AppConfig extends JFinalConfig{

	/**
	 * 配置项目全局变量
	 */
	public void configConstant(Constants constants) {
		loadPropertyFile("config/db.properties");
		constants.setDevMode(getPropertyToBoolean("devMode", true));
//		constants.setViewType(ViewType.FREE_MARKER);
	}
	
	/**
	 * 配置项目路由
	 */
	public void configRoute(Routes routes) {
//		me.add("/", IndexController.class, "/index");	
//		me.add("/login", LoginController.class);			
		routes.add(new BackRoutes());//管理端路由
		routes.add(new FrontRoutes());//前端路由
	}
	
	/**
	 * 配置项目插件
	 */
	public void configPlugin(Plugins me) {
		C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty("jdbcUrl"), getProperty("user"), getProperty("password").trim());
		me.add(c3p0Plugin);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		me.add(arp);
		arp.addMapping("t_ucenter_user", "usrId",User.class);	
	}
	
	
	public void configInterceptor(Interceptors me) {
	
	}
	
	/**
	 * 为freemarker提供全局的环境变量${base}
	 */
	public void configHandler(Handlers me) {
		me.add(new ContextPathHandler("base"));
	}
}
