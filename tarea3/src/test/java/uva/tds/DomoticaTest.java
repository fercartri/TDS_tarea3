package uva.tds;

import static org.junit.jupiter.api.Assertions.*;

import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.jupiter.api.Test;

/**
 * Clase de test para la clase Domotica
 * @author Fernando Carmona Palacio
 */

public class DomoticaTest {

    @TestSubject
    private Domotica dom;

    @Mock
    private DomoticaService ser;

    @Test
    void testDomoticaConstructorValido(){
    
    }
}
