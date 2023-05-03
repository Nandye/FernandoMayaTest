package com.example.demo.infrastructure.rest.spring.controller;

import com.example.demo.FernandoApplication;
import com.example.demo.infrastructure.db.config.DbJpaConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
@TestPropertySource("classpath:application.properties")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {DbJpaConfig.class, FernandoApplication.class})
public class PricesControllerIntegrationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void givenWebApplicationContext_whenServletContext_thenItProvidesPricesController() {
        final ServletContext servletContext = webApplicationContext.getServletContext();
        assertNotNull(servletContext);
        assertTrue(servletContext instanceof MockServletContext);
        assertNotNull(webApplicationContext.getBean("pricesController"));
    }

    @Test
    public void when_params_is_passed_thenResponseOK() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/fernando/pricesOnDemandDate")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("demandDate", "2020-06-15T00:00:00")
                )
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].price").value(35.50D))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].price").value(30.50D))
                .andExpect(status().isOk());
    }

    @Test
    public void when_request_day_fourteen_at_ten_in_morning_thenResponseOneElement() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/fernando/pricesOnDemandDate")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("demandDate", "2020-06-14T10:00:00")
                )
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].price").value(35.50D))
                .andExpect(status().isOk());
    }

    @Test
    public void when_request_day_fourteen_at_four_in_evening_thenResponseTwoElements() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/fernando/pricesOnDemandDate")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("demandDate", "2020-06-14T16:00:00")
                )
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].price").value(35.50D))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].price").value(25.45D))
                .andExpect(status().isOk());
    }

    @Test
    public void when_request_day_fourteen_at_nine_in_evening_thenResponseOneElement() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/fernando/pricesOnDemandDate")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("demandDate", "2020-06-14T21:00:00")
                )
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].price").value(35.50D))
                .andExpect(status().isOk());
    }

    @Test
    public void when_request_day_fifteen_at_ten_in_morning_thenResponseTwoElement() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/fernando/pricesOnDemandDate")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("demandDate", "2020-06-15T10:00:00")
                )
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].price").value(35.50D))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].price").value(30.50D))
                .andExpect(status().isOk());
    }

    @Test
    public void when_request_day_sixteen_at_nine_in_evening_thenResponseTwoElement() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/fernando/pricesOnDemandDate")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("demandDate", "2020-06-16T21:00:00")
                )
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].price").value(35.50D))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(4))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].price").value(38.95D))
                .andExpect(status().isOk());
    }

    @Test
    public void when_is_bad_request() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/fernando/pricesOnDemandDate")
                        .param("brandId", "aa")
                        .param("productId", "35455")
                        .param("demandDate", "2020-06-16T21:00:00")
                )
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}