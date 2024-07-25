package com.bnpp.bookstore.repository;

import com.bnpp.bookstore.entities.Cart;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
  @Query(
    nativeQuery = true,
    value = "select * from cart where book_id =:book_id and user_name =:user"
  )
  Cart findByBookIdAndUserName(@Param("book_id") Long id, @Param("user") String username);

  @Query(nativeQuery = true, value = "select * from cart where user_name =:user")
  List<Cart> findByUserName(@Param("user") String username);

  @Query(
    nativeQuery = true,
    value = "select cart.* from cart " +
    "inner join users on users.user_name = cart.user_name " +
    "where users.email =:email"
  )
  List<Cart> findByEmail(@Param("email") String email);
}
