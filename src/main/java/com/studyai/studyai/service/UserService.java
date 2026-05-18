package com.studyai.studyai.service;

import com.studyai.studyai.dto.LoginRequestDTO;
import com.studyai.studyai.dto.LoginResponseDTO;
import com.studyai.studyai.exception.BusinessException;
import com.studyai.studyai.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.studyai.studyai.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.List;
import com.studyai.studyai.exception.ResourceNotFoundException;
import com.studyai.studyai.dto.UserResponseDTO;
import com.studyai.studyai.security.JwtService;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UserService(UserRepository userRepository,
                       BCryptPasswordEncoder passwordEncoder,
                       JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public UserResponseDTO salvarUsuario(User user) {
        if (userRepository.findByCpf(user.getCpf()).isPresent()) {
            throw new BusinessException("CPF já cadastrado");
        }

        user.setSenha(passwordEncoder.encode(user.getSenha()));
        User usuarioSalvo = userRepository.save(user);

        return converterParaDTO(usuarioSalvo);
    }

    public List<UserResponseDTO> listarUsuarios() {
        return userRepository.findAll().stream().map(this::converterParaDTO).toList();
    }

    public UserResponseDTO buscarPorId(Long id) {
        User user = buscarUsuarioEntity(id);
        return converterParaDTO(user);
    }

    public void deletarUsuario(Long id) {
        userRepository.deleteById(id);
    }

    public UserResponseDTO atualizarUsuario(Long id, User userAtualizado) {

        User usuarioExistente = buscarUsuarioEntity(id);

        usuarioExistente.setNome(userAtualizado.getNome());
        usuarioExistente.setEmail(userAtualizado.getEmail());
        usuarioExistente.setCpf(userAtualizado.getCpf());
        usuarioExistente.setSenha(
                passwordEncoder.encode(userAtualizado.getSenha())
        );

        User usuarioAtualizadoSalvo = userRepository.save(usuarioExistente);

        return converterParaDTO(usuarioAtualizadoSalvo);

    }
    private User buscarUsuarioEntity(Long id){
        return userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Usuario não encontrado"));
    }


    private UserResponseDTO converterParaDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setNome(user.getNome());
        dto.setEmail(user.getEmail());
        dto.setCpf(user.getCpf());
        return dto;
    }
    public LoginResponseDTO login(LoginRequestDTO loginRequest){
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new BusinessException("Email ou senha inválidos"));
        boolean senhaCorreta = passwordEncoder.matches(
                loginRequest.getSenha(),
                user.getSenha()
        );
        if (!senhaCorreta){
            throw new BusinessException("Email ou senha inválidos");
        }
        String token = jwtService.gerarToken(user.getEmail());

        LoginResponseDTO response = new LoginResponseDTO();
        response.setMensagem("Login realizado com sucesso");
        response.setToken(token);

        return response;
    }

}
