package com.product.manage.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.manage.pojo.User;
@Service
@Transactional
public class UserService extends BaseService<User>{
	
}
