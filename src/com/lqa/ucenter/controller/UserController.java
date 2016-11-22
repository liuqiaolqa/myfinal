package com.lqa.ucenter.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.lqa.ucenter.inteceptor.UserInterceptor;
import com.lqa.ucenter.model.User;


@Before(UserInterceptor.class)
public class UserController extends Controller {
	public void index() {
		setAttr("userPage", User.dao.paginate(getParaToInt(0, 1), 10));
		render("user-index.html");
	}
	
	public void add() {
	}
	
	@Before(UserInterceptor.class)
	public void save() {
		getModel(User.class).save();
		redirect("/user");
	}
	
	public void edit() {
		setAttr("user", User.dao.findById(getParaToInt()));
	}
	
	@Before(UserInterceptor.class)
	public void update() {
		getModel(User.class).update();
		redirect("/user");
	}
	
	public void delete() {
		User.dao.deleteById(getParaToInt());
		redirect("/user");
	}
}


