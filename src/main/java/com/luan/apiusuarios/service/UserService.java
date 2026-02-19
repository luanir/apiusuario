package com.luan.apiusuarios.service;

import java.util.List;

import com.luan.apiusuarios.dto.UserRequestDTO;
import com.luan.apiusuarios.dto.UserResponseDTO;
//import com.luan.apiusuarios.model.User;


public interface UserService {

    UserResponseDTO create(UserRequestDTO dto);

    UserResponseDTO findById(Long id);

    List<UserResponseDTO> findAll();

    UserResponseDTO update(Long id, UserRequestDTO dto);

    void delete(Long id);
}

