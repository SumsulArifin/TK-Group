package com.tkgroupbd.pusti.api.data.repositories.user;

import com.tkgroupbd.pusti.api.data.models.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByEmail(String email);
}
