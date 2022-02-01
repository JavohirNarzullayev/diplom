package uz.narzullayev.javohir.service.impl;/* 
 @author: Javohir
  Date: 1/7/2022
  Time: 10:25 PM*/

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import uz.narzullayev.javohir.dto.UserDto;
import uz.narzullayev.javohir.dto.UserFilterDto;
import uz.narzullayev.javohir.entity.UserEntity;
import uz.narzullayev.javohir.repository.UserRepository;
import uz.narzullayev.javohir.service.UserService;
import uz.narzullayev.javohir.specification.UserSpecification;

import javax.validation.Valid;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    @Validated(UserDto.Create.class)
    public UserEntity save(@Valid UserDto user) {
        return userRepository.save(user.merge(new UserEntity()));
    }

    @Override
    @Validated(UserDto.Update.class)
    public void update(@Valid UserDto user) {
        try {
            var merge = user.merge(findById(user.getId()));
            userRepository.saveAndFlush(merge);
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public boolean isUserAlreadyPresent(String username) {
        return username != null ? !userRepository.existsByUsername(username) : !Boolean.FALSE;
    }

    @Override
    public boolean existByEmail(String email) {
        return email != null ? !userRepository.existsByEmail(email) : !Boolean.FALSE;
    }

    @Override
    public DataTablesOutput<UserEntity> findAllBySpecific(DataTablesInput input, UserFilterDto filterDto) {
        return userRepository.findAll(input, UserSpecification.find(filterDto));
    }

    @Override
    public void userBlockOrUnblockById(Long id) {
        var userEntity = userRepository.findById(id);
        if (userEntity.isPresent()) {
            var user = userEntity.get();
            user.setEnabled(!user.getEnabled());
            userRepository.saveAndFlush(user);
        }
    }

    @Override
    public UserEntity findById(Long id) throws IllegalAccessException {
        if (id == null) throw new IllegalAccessException("User id is null");
        return userRepository.findById(id).orElse(null);
    }
}
