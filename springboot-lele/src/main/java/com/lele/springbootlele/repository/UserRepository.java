package com.lele.springbootlele.repository;

import com.lele.springbootlele.pojo.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository         // spring bean
public interface UserRepository extends CrudRepository<User, Integer> {
}
