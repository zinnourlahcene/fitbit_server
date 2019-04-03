package com.fitbitml.service.user;


import com.fitbitml.dao.UserRepository;
import com.fitbitml.domain.User;
import com.fitbitml.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractService<User, Integer> implements UserService {


    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByFirstNameAndLastName(String firstName, String lastName) {
        return userRepository.getUserByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public int deleteByFirstNameAndLastName(String firstName, String lastName) {
        return userRepository.deleteByFirstNameAndLastName(firstName, lastName);
    }
}
