package com.bnpp.bookstore.mapper;

import com.bnpp.bookstore.DTO.UserDto;
import com.bnpp.bookstore.entities.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
  componentModel = "spring",
  injectionStrategy = InjectionStrategy.FIELD,
  unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UserMapper {
  UserDto toDto(User book);

  @Mapping(source = "username", target = "userName")
  User toEntity(UserDto userDto);
}
