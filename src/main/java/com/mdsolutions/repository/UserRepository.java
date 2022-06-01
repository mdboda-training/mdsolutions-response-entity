package com.mdsolutions.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.mdsolutions.bo.UserDAO;

@Repository
public interface UserRepository extends JpaRepositoryImplementation<UserDAO, Integer> {

}
