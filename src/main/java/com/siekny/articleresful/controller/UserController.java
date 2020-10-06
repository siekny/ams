package com.siekny.articleresful.controller;

import com.siekny.articleresful.model.User;
import com.siekny.articleresful.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Api(value="users", description="Operations pertaining to products in Online")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "View a list of available users",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public List<User> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return users;
    }

    @ApiOperation(value = "Add a user")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveProduct(@RequestBody User user) {
        System.out.println("user-body" + user);
        userService.addUser(user);
        return new ResponseEntity("Product saved successfully", HttpStatus.OK);
    }

        @ApiOperation(value = "Get one user")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public User getOneUser(@PathVariable Integer id) {
        User user = userService.getOneUser(id);
        return user;
    }

    @ApiOperation(value = "Get one user by email")
    @RequestMapping(value = "email/{email}", method = RequestMethod.GET, produces = "application/json")
    public User getOneUserByEmail(@PathVariable String email) {
        User user = userService.getUserByEmail(email);
        return user;
    }

    @ApiOperation(value = "Delete one user")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public Boolean deleteUser(@PathVariable Integer id) {
        System.out.println("userId" + id);
        Boolean isDeleted = userService.deleteUser(id);
        return isDeleted;
    }

    @ApiOperation(value = "Update one user")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
    public Boolean updateUser(@PathVariable Integer id, @RequestBody User user) {
        System.out.println("userId : " + id);
        System.out.println("User : " + user);
        Boolean isUpdated = userService.updateUser(id, user);
        return isUpdated;
    }
}
