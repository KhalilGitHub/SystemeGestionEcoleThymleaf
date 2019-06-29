package com.objis.cam.sgethymleaf.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.objis.cam.sgethymleaf.model.App_User;



@Repository
public interface UserRepository extends CrudRepository<App_User, Long>{

	App_User findByEmailIgnoreCase(String username);

}
