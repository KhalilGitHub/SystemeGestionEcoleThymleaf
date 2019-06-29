package com.objis.cam.sgethymleaf.service;

import java.util.List;

import com.objis.cam.sgethymleaf.model.App_User;


public interface UserService {

	App_User save(App_User user);

	List<App_User> findAll();

	App_User getUserByEmail(String email);

}