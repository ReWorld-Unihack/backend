package com.example.ReWorld.security.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.ReWorld.entities.User;

import jakarta.transaction.Transactional;

import java.util.Optional;


@Transactional
public interface IUserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);

    @Modifying
    @Query("Update User u set u.password=:password WHERE u.id = (:id)")
    void changePassword(@Param("id") Integer id,@Param("password") String password);
    @Modifying
    @Query(nativeQuery = true,value= "DELETE FROM users_roles t WHERE t.user_id = (:id)")
    void deleteUserTableJoin(@Param("id") Integer id);
}
