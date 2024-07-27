package com.bnpp.bookstore.mapper;

import com.bnpp.bookstore.DTO.BookDto;
import com.bnpp.bookstore.DTO.CartDto;
import com.bnpp.bookstore.DTO.CartDtoList;
import com.bnpp.bookstore.DTO.OrderDto;
import com.bnpp.bookstore.entities.Order;
import com.bnpp.bookstore.entities.OrderBook;
import java.util.List;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
  componentModel = "spring",
  injectionStrategy = InjectionStrategy.FIELD,
  unmappedTargetPolicy = ReportingPolicy.IGNORE,
  imports = { BookMapper.class, UserMapper.class }
)
public interface OrderMapper {
  List<OrderBook> toOrderBook(List<CartDto> cartDtoList);

  @Mapping(source = "book", target = ".")
  BookDto toBookDto(OrderBook orderBook);

  @Mapping(source = "orderBookList", target = "books")
  OrderDto toOrderDto(Order order);

  List<OrderDto> toDtoList(List<Order> orderList);
}
