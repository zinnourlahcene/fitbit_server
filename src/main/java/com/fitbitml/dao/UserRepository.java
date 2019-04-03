package com.fitbitml.dao;


import com.fitbitml.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User getUserByFirstNameAndLastName(String firstName, String lastName);

    @Transactional
    @Modifying
    @Query("delete from User u where u.firstName = :firstName and u.lastName = :lastName")
    int deleteByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);
}