package com.example.springtemplate.repositories;

import com.example.springtemplate.models.Seller;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SellerRestRepository
        extends CrudRepository<Seller, Integer> {

    @Query(value = "SELECT * FROM users " +
            "WHERE users.user_type = 1",
            nativeQuery = true)
    List<Seller> findAllSellers();

    @Query(value = "SELECT * FROM users\n" +
            "WHERE users.user_type = 1 AND users.id=:userId",
            nativeQuery = true)
    Seller findSellerById(@Param("userId") Integer id);

}
