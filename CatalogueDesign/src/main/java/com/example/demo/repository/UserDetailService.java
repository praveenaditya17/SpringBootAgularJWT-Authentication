package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.UserDetail;

public interface UserDetailService extends CrudRepository<UserDetail,Integer>  {
	
	@Query(value="select * from userdetail where user_name=?1",nativeQuery = true)
	UserDetail findByUserName(String name);
}
