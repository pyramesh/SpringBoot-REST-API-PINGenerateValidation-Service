package com.ramesh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ramesh.domain.UserPin;

/**
 * @author Ramesh.Yaleru
 *
 */
@Repository
public interface PinGenerateValidateRepository extends JpaRepository<UserPin, Long>{

	Optional<UserPin> findByUserId(Long userId);
}
