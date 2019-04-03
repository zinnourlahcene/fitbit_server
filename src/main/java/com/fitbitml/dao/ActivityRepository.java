package com.fitbitml.dao;


import com.fitbitml.domain.Activity;
import com.fitbitml.domain.Auth;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Integer> {
}
