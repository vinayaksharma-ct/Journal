package com.Journal.Controller;

import com.Journal.entity.JournalEntry;
import com.Journal.entity.User;
import com.Journal.service.JournalEntryService;
import com.Journal.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JournalEntryService journalEntryService;
    @GetMapping()
    public List<User>getAll(){
        return userService.getAll();
    }
//
//    @GetMapping("/{userId}")
//    public User getUserById(ObjectId id){
//        return userService.findById(id);
//    }

    @PostMapping
    public void createUser(@RequestBody User user){
        userService.saveEntry(user);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable String username){
        User userIndb = userService.findByUserName(username);
        if(userIndb !=null){
            userIndb.setUserName(user.getuserName());
            userIndb.setPassword(user.getPassword());
            userService.saveEntry(userIndb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}