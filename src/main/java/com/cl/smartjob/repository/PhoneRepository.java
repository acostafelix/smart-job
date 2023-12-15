package com.cl.smartjob.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cl.smartjob.entity.PhoneEntity;

@Repository
public interface PhoneRepository extends CrudRepository<PhoneEntity, String>{

}
