package com.demo.pocketpal.services;
import com.demo.pocketpal.configs.jwt.JwtService;
import com.demo.pocketpal.dto.request.LoginRequestDto;
import com.demo.pocketpal.dto.request.RegisterRequestDto;
import com.demo.pocketpal.dto.response.AuthenticationResponseDto;
import com.demo.pocketpal.entitiy.Person;
import com.demo.pocketpal.entitiy.Role;
import com.demo.pocketpal.repo.IPersonRepository;
import com.demo.pocketpal.services.base.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class AuthService extends ServiceManager<Person,Long> {
    private final IPersonRepository iPersonRepository;
    private final JwtService jwtService;
    public AuthService(IPersonRepository iPersonRepository,JwtService jwtService) {
        super(iPersonRepository);
        this.iPersonRepository = iPersonRepository;
        this.jwtService = jwtService;
    }
    public Boolean createPerson(RegisterRequestDto dto) {
        if(iPersonRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }
        Person person;
        person = Person.builder()
                .email(dto.getEmail())
                .name(dto.getName())
                .lastName(dto.getLastName())
                .password(dto.getPassword())
                .roles(Set.of(Role.USER))
                .build();
        save(person);
        return true;
    }
    public AuthenticationResponseDto login(LoginRequestDto dto){
        Optional<Person> person = iPersonRepository.findByEmailAndPassword(dto.getEmail(),dto.getPassword());
        if(person.isEmpty()){
            throw new RuntimeException("Email or password is wrong");
        }
        return AuthenticationResponseDto.builder()
                .token(jwtService.generateToken(person.get()))
                .build();
    }

}


