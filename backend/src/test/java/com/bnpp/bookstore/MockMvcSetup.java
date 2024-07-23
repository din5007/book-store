package com.bnpp.bookstore;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.runtime.ObjectMethods;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ActiveProfiles("test")
public abstract class MockMvcSetup {
  protected MockMvc mvc;
  protected final ObjectMapper objectMapper = new ObjectMapper();

  @BeforeEach
  void init() {
    mvc = MockMvcBuilders.standaloneSetup(getController()).build();
  }

  protected abstract Object getController();
}
