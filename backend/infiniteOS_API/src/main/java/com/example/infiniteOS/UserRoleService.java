package com.example.infiniteOS;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserRoleService {

    @Autowired
    private UsersRoleRepository usersRoleRepository;

    public void saveUser(Userrole userrole) {
        usersRoleRepository.save(userrole);
    }

    public Userrole getUserrole(Integer id) {
        return usersRoleRepository.findById(id).get();
    }

}
