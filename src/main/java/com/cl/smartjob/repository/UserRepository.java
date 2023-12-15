package com.cl.smartjob.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cl.smartjob.entity.UserEntity;


@Repository
public interface UserRepository extends CrudRepository<UserEntity, String> {

	@Query(value = "SELECT u FROM UserEntity u WHERE u.email = :email")
	UserEntity findByEmail(@Param("email") String email);

}
