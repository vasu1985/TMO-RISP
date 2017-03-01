package com.tmobile.returns.repository;

import org.springframework.data.repository.CrudRepository;

import com.tmobile.returns.domain.UserDetails;

public interface UserRepository extends CrudRepository<UserDetails, String> {

}
