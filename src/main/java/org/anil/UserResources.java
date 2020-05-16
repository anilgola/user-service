package org.anil;

import java.util.Optional;

import org.anil.repository.UserRepository;
import org.anil.ui.ResponseBean;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResources {

	@Autowired
	UserRepository userRespository;
	
	
	@GetMapping("/")
	public String getRoot() {
		return "user-microservic-root";
	}
	
	
	@GetMapping("/user/{id}")
	public ResponseBean getUser(@PathVariable String id) {
		Optional<UserEntity> userEntity = userRespository.findById(Long.valueOf(id));
		ResponseBean responseBean = new ResponseBean();
		BeanUtils.copyProperties(userEntity.get(), responseBean);
		return responseBean;
	}
}
