package com.example.infiniteOS;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    public void saveUser(Users user) {
        usersRepository.save(user);
    }

    public Users getUser(Integer id) {
        return usersRepository.findById(id).get();
    }

    public Users loginUser(String userName, String password){

        return usersRepository.loginUser(userName, password);
    }
}
