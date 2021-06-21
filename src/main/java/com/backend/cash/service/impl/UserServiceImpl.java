package com.backend.cash.service.impl;

import com.backend.cash.model.User;
import com.backend.cash.modelDTO.UserDTO;
import com.backend.cash.repository.UserRepository;
import com.backend.cash.service.interfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRep;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public UserDTO userSave(User user) {
        UserDTO userDTO = modelToDTO(userRep.save(user));
        return userDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        UserDTO userDTO = modelToDTO(userRep.findById(id).orElse(null));
        return userDTO;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userRep.deleteById(id);
    }

    private UserDTO modelToDTO(User user){
        return modelMapper.map(user, UserDTO.class);
    }

    private User dtoToModel(UserDTO userDTO){
        return modelMapper.map(userDTO, User.class);
    }
}
