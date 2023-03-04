package com.osumare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osumare.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

}
