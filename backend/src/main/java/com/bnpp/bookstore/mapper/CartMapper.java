package com.bnpp.bookstore.mapper;

import com.bnpp.bookstore.DTO.BookDto;
import com.bnpp.bookstore.DTO.CartDto;
import com.bnpp.bookstore.entities.Book;
import com.bnpp.bookstore.entities.Cart;
import java.util.List;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
  componentModel = "spring",
  injectionStrategy = InjectionStrategy.FIELD,
  unmappedTargetPolicy = ReportingPolicy.IGNORE,
  imports = { BookMapper.class, UserMapper.class }
)
public interface CartMapper {
  CartDto toDto(Cart cart);
  List<CartDto> toDtoList(List<Cart> cartList);
}
