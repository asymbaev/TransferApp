package com.app.transaction.repository;

import com.app.transaction.entity.UserSignup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSignupRepository extends JpaRepository<UserSignup, Long> {
}
