package com.fitbitml.dao;

import com.fitbitml.domain.Auth;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AuthRepository extends CrudRepository<Auth, Integer> {

    @Query("select a from Auth a where a.accessToken = :accessToken")
    Auth findByAccessToken(@Param("accessToken") String accessToken);

    /*@Query("select a from Auth a where a.authorizationCode = :authorizationCode")
    Auth findByAuthorizationCode(@Param("authorizationCode") String authorizationCode);*/

    Auth findTopByOrderByIdDesc();

    @Transactional
    @Modifying
    @Query("delete from Auth a where a.accessToken = :accessToken")
    int deleteByAccessToken(@Param("accessToken") String accessToken);
}
