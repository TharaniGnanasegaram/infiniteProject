package com.example.infiniteOS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/infiniteUserRole")
public class UsersRoleController {

    @Autowired
    UserRoleService userRoleService;

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Userrole> get(@PathVariable Integer id) {
        try {
            Userrole userrole = userRoleService.getUserrole(id);
            return new ResponseEntity<Userrole>(userrole, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Userrole>(HttpStatus.NOT_FOUND);
        }
    }


}
