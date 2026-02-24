package com.luan.apiusuarios.service;

import com.luan.apiusuarios.exception.BusinessException;
import com.luan.apiusuarios.exception.ResourceNotFoundException;
import com.luan.apiusuarios.model.User;
import com.luan.apiusuarios.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.luan.apiusuarios.dto.UserRequestDTO;
import com.luan.apiusuarios.dto.UserResponseDTO;
import com.luan.apiusuarios.dto.UserPatchDTO;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	private UserResponseDTO toResponseDTO(User user) {
	    return new UserResponseDTO(
	            user.getId(),
	            user.getNome(),
	            user.getEmail()
	    );
	}
	
	
	public UserServiceImpl (UserRepository userRepository) {
		this.userRepository = userRepository;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}
	
	@Override
	public UserResponseDTO create(UserRequestDTO dto) {
	    if (userRepository.existsByEmail(dto.getEmail())) {
	        throw new BusinessException("Email já cadastrado!");
	    }

	    User user = new User();
	    user.setNome(dto.getNome());
	    user.setEmail(dto.getEmail());
	    user.setPassword(passwordEncoder.encode(dto.getPassword()));

	    User saved = userRepository.save(user);

	    return new UserResponseDTO(
	            saved.getId(),
	            saved.getNome(),
	            saved.getEmail()
	    );
	}

	
	@Override
	public UserResponseDTO findById(Long id) {
	    User user = userRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

	    return new UserResponseDTO(
	            user.getId(),
	            user.getNome(),
	            user.getEmail()
	    );
	}

	
	@Override
	public List<UserResponseDTO> findAll() {
	    return userRepository.findAll()
	            .stream()
	            .map(user -> new UserResponseDTO(
	                    user.getId(),
	                    user.getNome(),
	                    user.getEmail()
	            ))
	            .toList();
	}

	
	@Override
	public UserResponseDTO update(Long id, UserRequestDTO dto) {
	    User existing = userRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

	    existing.setNome(dto.getNome());
	    existing.setEmail(dto.getEmail());

	    User saved = userRepository.save(existing);

	    return new UserResponseDTO(
	            saved.getId(),
	            saved.getNome(),
	            saved.getEmail()
	    );
	}

	
	@Override
	public void delete(Long id) {
	    User user = userRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

	    userRepository.delete(user);
	}
	
	public UserResponseDTO partialUpdate(Long id, UserPatchDTO dto) {
		User user = userRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Usuário não encontrado"));
		if (dto.getNome() != null) {
			user.setNome(dto.getNome());
		}
		if (dto.getEmail() != null) {
			user.setEmail(dto.getEmail());
		}
		
		userRepository.save(user);
		
		return toResponseDTO(user);
	}

}
