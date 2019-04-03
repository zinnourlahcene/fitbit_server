package com.fitbitml.service.user;

import com.fitbitml.domain.Auth;
import com.fitbitml.domain.User;
import com.fitbitml.service.IService;
import org.springframework.data.repository.CrudRepository;

public interface UserService extends IService<User, Integer> {

    User getUserByFirstNameAndLastName(String firstName, String lastName);

    int deleteByFirstNameAndLastName(String firstName, String lastName);

}
