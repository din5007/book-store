package com.bnpp.bookstore.config.filter;

import com.bnpp.bookstore.DTO.UserDto;
import com.bnpp.bookstore.service.UserService;
import com.bnpp.bookstore.utils.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

public class AuthTokenFilter extends OncePerRequestFilter {
  @Autowired
  private JwtUtils jwtUtils;

  @Autowired
  UserService userService;

  static Map<String, UserDto> cacheToken = new ConcurrentHashMap<>();

  @Override
  protected void doFilterInternal(
    HttpServletRequest request,
    HttpServletResponse response,
    FilterChain filterChain
  )
    throws ServletException, IOException {
    try {
      String jwt = parseJwt(request);
      if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
        String username = jwtUtils.getUserNameFromJwtToken(jwt);
        UserDto userDto;
        if (cacheToken.get(jwt) != null) {
          userDto = cacheToken.get(jwt);
        } else {
          userDto = userService.loadUserByUsername(username);
        }
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
          userDto,
          userDto.getPassword(),
          null
        );
        authentication.setDetails(
          new WebAuthenticationDetailsSource().buildDetails(request)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
      }
    } catch (Exception e) {
      logger.error("Cannot set user authentication: {}", e);
    }

    filterChain.doFilter(request, response);
  }

  private String parseJwt(HttpServletRequest request) {
    String headerAuth = request.getHeader("Authorization");

    if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
      return headerAuth.substring(7);
    }

    return null;
  }
}
