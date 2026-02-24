package com.luan.apiusuarios.service;

import java.util.List;

import com.luan.apiusuarios.dto.UserPatchDTO;
import com.luan.apiusuarios.dto.UserRequestDTO;
import com.luan.apiusuarios.dto.UserResponseDTO;
//import com.luan.apiusuarios.model.User;


public interface UserService {

    UserResponseDTO create(UserRequestDTO dto);

    UserResponseDTO findById(Long id);

    List<UserResponseDTO> findAll();

    UserResponseDTO update(Long id, UserRequestDTO dto);
    
    UserResponseDTO partialUpdate(Long id, UserPatchDTO dto);
    
    void delete(Long id);
}

