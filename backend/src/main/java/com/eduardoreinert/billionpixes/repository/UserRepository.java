package com.eduardoreinert.billionpixes.repository;

import com.eduardoreinert.billionpixes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
