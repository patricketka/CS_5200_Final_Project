package com.example.springtemplate.repositories;

import com.example.springtemplate.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRestRepository
        extends CrudRepository<User, Integer> {}