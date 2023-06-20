package com.illuminati.ebs.controller;

import com.illuminati.ebs.dto.UsuarioDto;
import com.illuminati.ebs.entity.Usuario;
import com.illuminati.ebs.mapper.RolMapper;
import com.illuminati.ebs.mapper.UsuarioMapper;
import com.illuminati.ebs.repository.UsuarioRepository;
import com.illuminati.ebs.service.UsuarioService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController extends GenericController<UsuarioDto, Long> {

    private final UsuarioService service;
    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final RolMapper rolMapper;

    public UsuarioController(UsuarioService service, UsuarioRepository repository, UsuarioMapper mapper, PasswordEncoder passwordEncoder, RolMapper rolMapper) {
        super(service);
        this.service = service;
        this.repository = repository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
        this.rolMapper = rolMapper;
    }

    @PostMapping("/register")
    public UsuarioDto register(@RequestBody UsuarioDto accountDto) {
        if (emailExist(accountDto.getEmail())) {
            throw new RuntimeException(
                    "There is an account with that email adress: " + accountDto.getEmail());
        }
        Usuario user = new Usuario();
        user.setNombre(accountDto.getNombre());
        user.setApellido(accountDto.getApellido());
        user.setEmail(accountDto.getEmail());
        user.setClave(passwordEncoder.encode(accountDto.getClave()));
        user.setRol(rolMapper.toEntity(accountDto.getRol()));  // Asegúrate de tener un RolMapper

        return mapper.toDto(repository.save(user));
    }

    private boolean emailExist(String email) {
        return repository.findByEmail(email).isPresent();
    }

    @PutMapping("/{id}")
    public UsuarioDto updateUsuario(@PathVariable Long id, @RequestBody UsuarioDto accountDto) {
        if (!repository.existsById(id)) throw new RuntimeException("User not found");
        Usuario existingUser = repository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        if (!existingUser.getEmail().equals(accountDto.getEmail()) && emailExist(accountDto.getEmail())) {
            throw new RuntimeException(
                    "There is an account with that email adress: " + accountDto.getEmail());
        }
        existingUser.setNombre(accountDto.getNombre());
        existingUser.setApellido(accountDto.getApellido());
        existingUser.setEmail(accountDto.getEmail());
        if (accountDto.getClave() != null) {
            existingUser.setClave(passwordEncoder.encode(accountDto.getClave()));
        }
        existingUser.setRol(rolMapper.toEntity(accountDto.getRol()));

        return mapper.toDto(repository.save(existingUser));
    }
}

