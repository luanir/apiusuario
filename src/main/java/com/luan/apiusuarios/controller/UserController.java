package com.luan.apiusuarios.controller;

//import com.luan.apiusuarios.model.User;
import com.luan.apiusuarios.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.luan.apiusuarios.dto.UserRequestDTO;
import com.luan.apiusuarios.dto.UserResponseDTO;
import jakarta.validation.Valid;
import com.luan.apiusuarios.dto.UserPatchDTO;


import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {
	
	private final UserService userService;
	
	public UserController (UserService userService) {
		this.userService = userService;
	}
	
	//Criar Usuário
	@PostMapping
	public ResponseEntity<UserResponseDTO> create(
	        @Valid @RequestBody UserRequestDTO dto
	) {
	    return ResponseEntity
	            .status(HttpStatus.CREATED)
	            .body(userService.create(dto));
	}

	
	//Buscar todos
	@GetMapping
	public ResponseEntity<List<UserResponseDTO>> findAll() {
	    return ResponseEntity.ok(userService.findAll());
	}

	//Buscar por ID
	@GetMapping("/{id}")
	public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id) {
	    return ResponseEntity.ok(userService.findById(id));
	}

	
	//Atualizar
	@PutMapping("/{id}")
	public ResponseEntity<UserResponseDTO> update(
	        @PathVariable Long id,
	        @Valid @RequestBody UserRequestDTO dto
	) {
	    return ResponseEntity.ok(userService.update(id, dto));
	}

	
	//Deletar
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
	    userService.delete(id);
	    return ResponseEntity.noContent().build();
	}
	
	//Patch
	@PatchMapping("/{id}")
	public ResponseEntity<UserResponseDTO> partialUpdate(
	        @PathVariable Long id,
	        @RequestBody UserPatchDTO dto) {

	    return ResponseEntity.ok(userService.partialUpdate(id, dto));
	}
}
