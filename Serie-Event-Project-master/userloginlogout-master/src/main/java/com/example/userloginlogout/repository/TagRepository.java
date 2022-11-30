package com.example.userloginlogout.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.userloginlogout.models.Tag;

public interface TagRepository extends  JpaRepository<Tag,Integer> {
     Tag findByName(String name);
}
