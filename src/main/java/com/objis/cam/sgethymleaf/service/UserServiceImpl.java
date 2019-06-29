package com.objis.cam.sgethymleaf.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.objis.cam.sgethymleaf.model.App_User;
import com.objis.cam.sgethymleaf.repository.UserRepository;
import com.objis.cam.sgethymleaf.util.PasswordUtil;


@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public App_User save(App_User user) {

		String password = PasswordUtil.getPasswordHash(user.getEncrytedPassword());
		user.setEncrytedPassword(password);
		user.setDate(new Date());
		
		return userRepository.save(user);
	}

	@Override
	public List<App_User> findAll() {
		
		return (List<App_User>) userRepository.findAll();
	}

	@Override
	public App_User getUserByEmail(String email) {
		
		return userRepository.findByEmailIgnoreCase(email);
	}

}

