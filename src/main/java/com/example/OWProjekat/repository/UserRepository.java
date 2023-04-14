package com.example.OWProjekat.repository;

import com.example.OWProjekat.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByJmbg(String jmbg);

    @Modifying
    @Transactional
    @Query(value = "update users u set u.firstName = ?1, u.lastName = ?2, u.email = ?3, u.jmbg = ?4, u.phone = ?5 where u.id=?6 ", nativeQuery = true)
    void updateUser(String firstName, String lastName, String email, String jmbg, String phone, long id);

}
