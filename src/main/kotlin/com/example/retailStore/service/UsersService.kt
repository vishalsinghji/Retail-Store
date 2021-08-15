package com.example.retailStore.service

import com.example.retailStore.models.Users
import com.example.retailStore.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UsersService {
    @Autowired
    private lateinit var userRepository :UserRepository

    fun getUser(): List<Users> {
        return  userRepository.findAll()
    }

    fun getUserById(id:Long) : Users {
        (userRepository.getById(id)!=null)
        return  userRepository.getById(id)
    }

    fun addUser(userDetails :Users):Users{
        return userRepository.save(userDetails)
//        return "New User has been Added"
    }

    fun updateUser(id:Long,newUser:Users) :Users{
        userRepository.findById(id).map { existingUser ->
            val updatedUser: Users =existingUser
                .copy(name = newUser.name, phone = newUser.phone ,address = newUser.address)
            ResponseEntity.ok().body(userRepository.save(updatedUser))
        }.orElse(ResponseEntity.notFound().build())
        return userRepository.getById(id)
    }

    fun deleteUser(id:Long): String {
        userRepository.deleteById(id)
       return "User has been  Deleted with id =$id"
    }

}