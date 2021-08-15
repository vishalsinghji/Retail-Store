package com.example.retailStore.controller

import com.example.retailStore.models.Users
import com.example.retailStore.service.UsersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("api/v1/users")
class UsersController {
    @Autowired
    private lateinit var usersService: UsersService

    @GetMapping("")
    fun getUsers():List <Users> {
        return usersService.getUser()
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long):Users {
        return usersService.getUserById(id)
    }

    @PostMapping("/add")
    fun addUser(@RequestBody user:Users) :Users{
        return usersService.addUser(user)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteUser(@PathVariable id: Long) :String{
        return usersService.deleteUser(id)
    }

    @PutMapping("/update/{id}")
    fun updateUser(@PathVariable id: Long,@RequestBody user:Users):Users{
        return usersService.updateUser(id,user);
    }

}