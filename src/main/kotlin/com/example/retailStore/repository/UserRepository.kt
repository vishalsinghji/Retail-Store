package com.example.retailStore.repository

import com.example.retailStore.models.Users
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<Users,Long>