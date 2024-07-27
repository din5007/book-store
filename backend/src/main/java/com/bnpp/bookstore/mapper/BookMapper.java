package com.bnpp.bookstore.mapper;

import com.bnpp.bookstore.DTO.BookDto;
import com.bnpp.bookstore.entities.Book;
import com.bnpp.bookstore.entities.OrderBook;
import java.util.List;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
  componentModel = "spring",
  injectionStrategy = InjectionStrategy.FIELD,
  unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface BookMapper {
  BookDto toDto(Book book);
  List<BookDto> toDtoList(List<Book> bookList);
}
