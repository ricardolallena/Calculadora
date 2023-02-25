package com.iteriam.sanitas.calculadora;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class CalculadoraApplicationTests {
	/**
	 * Test de carga del contexto de springboot
	 * @param context
	 */
	@Test
	void contextLoads(ApplicationContext context) {
		CalculadoraApplication.main(new String[] {});
		Assertions.assertNotNull(context, "Error al cargar el conexto de spring boot");
	}

}
