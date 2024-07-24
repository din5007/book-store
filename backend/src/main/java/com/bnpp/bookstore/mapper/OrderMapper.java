package com.bnpp.bookstore.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
  componentModel = "spring",
  injectionStrategy = InjectionStrategy.FIELD,
  unmappedTargetPolicy = ReportingPolicy.IGNORE,
  imports = { BookMapper.class, UserMapper.class }
)
public interface OrderMapper {}
