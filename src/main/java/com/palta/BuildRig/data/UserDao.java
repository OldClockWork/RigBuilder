package com.palta.BuildRig.data;


import com.palta.BuildRig.Models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface UserDao extends CrudRepository<User, Integer> {

    User findByEmail(String email);
    User findByUsername(String username);
}
