package com.iteriam.sanitas.calculadora.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.iteriam.sanitas.calculadora.controller.OperacionControllerImpl;

@SpringBootTest
class ConfigRestExceptionsTest {

        @Autowired
        private OperacionControllerImpl operacionControllerImpl;

        @Autowired
        private ConfigRestExceptions configRestExceptions;

        private MockMvc mockMvc;

        @BeforeEach
        void setup() {
                this.mockMvc = MockMvcBuilders.standaloneSetup(operacionControllerImpl)
                                .setControllerAdvice(configRestExceptions).build();
        }

        /**
         * test throw NumberFormatException para parametros numericos incorrectos.
         */
        @Test
        void numberFormatExceptionHandlerTest() throws Exception {
                this.mockMvc.perform(
                                get("/operacion")
                                                .param("num1", "a")
                                                .param("operador", "SUMA")
                                                .param("num2", "2"))
                                .andDo(print())
                                .andExpect(result -> assertTrue(
                                                result.getResolvedException() instanceof NumberFormatException));

        }

        /**
         * test throw MethodArgumentTypeMismatchException operador incorrecto en la
         * peticion
         */
        @Test
        void methodArgumentTypeMismatchExceptionExceptionHandlerTest() throws Exception {
                this.mockMvc.perform(
                                get("/operacion")
                                                .param("num1", "1")
                                                .param("operador", "SUMAS")
                                                .param("num2", "2"))
                                .andDo(print())
                                .andExpect(result -> assertTrue(
                                                result.getResolvedException() instanceof MethodArgumentTypeMismatchException));

        }

        /**
         * test throw MissingServletRequestParameterException falta algun parametro en
         * la peticion
         */
        @Test
        void missingServletRequestParameterExceptionHandlerTest() throws Exception {
                this.mockMvc.perform(
                                get("/operacion")
                                                .param("num1", "1")
                                                .param("num2", "2"))
                                .andDo(print())
                                .andExpect(result -> assertTrue(
                                                result.getResolvedException() instanceof MissingServletRequestParameterException));

        }

        /**
         * test throw manejador global excepciones
         */
        @Test
        void globalExceptionHandlerTest() throws Exception {
                this.mockMvc.perform(
                                post("/operacion")
                                                .param("num1", "1")
                                                .param("operador", "SUMA")
                                                .param("num2", "2"))
                                .andDo(print())
                                .andExpect(result -> assertTrue(result.getResolvedException() instanceof Exception));
        }

}
