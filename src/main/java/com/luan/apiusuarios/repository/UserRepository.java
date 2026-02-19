package com.luan.apiusuarios.repository;

import com.luan.apiusuarios.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByEmail(String email);
	
	Optional<User> findById(Long id);
	
	Optional<User> findByNome(String nome);
	
	List<User> findByNomeContainingIgnoreCase(String nome);
	
	boolean existsByEmail(String email);
}
