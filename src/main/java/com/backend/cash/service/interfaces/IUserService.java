package com.backend.cash.service.interfaces;

import com.backend.cash.model.User;
import com.backend.cash.modelDTO.UserDTO;

public interface IUserService {

    public UserDTO userSave(User user);
    public UserDTO findById(Long id);
    public void deleteById(Long id);
}
