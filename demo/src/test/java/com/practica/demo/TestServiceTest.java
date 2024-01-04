package com.practica.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.powermock.api.mockito.PowerMockito;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TestServiceTest {
    @InjectMocks
    private TestService service;
    @Mock
    private Logger log; // Asegúrate de que estás importando la interfaz Logger correcta (java.util.logging.Logger)

    @BeforeEach
    public void setUp() {
        PowerMockito.mockStatic(Logger.class);
    }

    @Test
    void validate() {
        Object object = service.validate(new Object());
        assertNotNull(object);
    }

    //Esta prueba fue con powerMockito
    /*@Test
    public void testValidateWithNullObject() {
        // Resto del código...

        // Verificar que el log.info se llamó una vez con el mensaje esperado
        verifyStatic(Logger.class, times(1));
        Logger.getLogger(TestService.class.getName()).info("Datos no validos");
    }*/

    @Test
    public void testValidateWithNullObjectException() {
        // Inicializar los mocks
        Object nullObject = null;

        // Act y Assert (actuar y afirmar)
        RuntimeException exception = assertThrows(RuntimeException.class, () -> service.validate(nullObject));

        // Verificar que se lanzó la excepción esperada
        assertEquals("Datos no validos", exception.getMessage());

        // Verificar que el log.info NO se llamó (ya que no llegamos a esa parte del código)
        verify(log, never()).info(anyString());
    }
}