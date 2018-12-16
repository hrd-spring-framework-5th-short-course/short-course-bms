package com.example.shortcoursebms.controllers.restcontrollers;

import com.example.shortcoursebms.models.User;
import com.example.shortcoursebms.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {

    private UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("")
    public List<User> getAllUsers() {


        return this.userService.getAllUsers();
    }


    //    @PostMapping("")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String save(@RequestBody User user) {

        int status = this.userService.save(user);

        if (status > 0) {
            return "Save User Successfully!!!";
        }
        return "Save User Failed!!!";


    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<String> update(@RequestBody User user) {

        int status = this.userService.update(user);

        if (status > 0) {
            return ResponseEntity.ok("Update User successfully!!!");
        }
        return  new ResponseEntity<>("Update User Failed!!!", HttpStatus.NOT_FOUND);
    }



//    @RequestMapping(value = "", method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {

        int status = this.userService.delete(id);

        if (status > 0) {
            return ResponseEntity.ok("Delete User successfully!!!");
        }
        return  new ResponseEntity<>("Delete User Failed!!!", HttpStatus.NOT_FOUND);
    }





}
