package com.fbs.User.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fbs.User.entity.Admin;
import com.fbs.User.entity.User;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	Optional<Admin> findByUsername(String username);

}
