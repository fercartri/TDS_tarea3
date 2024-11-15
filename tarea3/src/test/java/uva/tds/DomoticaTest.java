package uva.tds;

import static org.junit.jupiter.api.Assertions.*;
import org.easymock.*;
import org.junit.jupiter.api.*;

/**
 * Clase de test para la clase Domotica
 * @author Fernando Carmona Palacio
 */

public class DomoticaTest {

    @TestSubject
    private Domotica dom;

    @Mock
    private DomoticaService servicio;

    @BeforeEach
    void setUp(){
        servicio = EasyMock.mock(DomoticaService.class);
    }

    //Constructor
    @Test
    void testDomoticaConstructorValido(){
        Domotica dom = new Domotica(servicio);
        
        assertEquals(dom.getDomoticaService(), servicio);
    }

    @Test
    void testDomoticaConstructorNoValidoServicioNull(){
        assertThrows(IllegalArgumentException.class, () -> {
            Domotica dom = new Domotica(null);
        });
    }

    //init
    @Test
    void testDomoticaInitValido(){
        servicio.setAvailable(true);
        EasyMock.expectLastCall().times(1);
        EasyMock.expect(servicio.isAvailable()).andReturn(true).times(1);
        
        EasyMock.replay(servicio);
        Domotica dom = new Domotica(servicio);
        dom.init();
        assertEquals(dom.isAvailable(), true);
        EasyMock.verify(servicio);
    }

    //encenderLuces
    @Test
    void testDomoticaEncenderLucesValido(){
        servicio.setAvailable(true);
        EasyMock.expectLastCall().times(1);
        EasyMock.expect(servicio.isAvailable()).andReturn(true).times(1);
        servicio.encenderLuces(0);
        EasyMock.expectLastCall().times(1);
        EasyMock.expect(servicio.isAvailable()).andReturn(true).times(1);
        EasyMock.expect(servicio.lucesEncencidas()).andReturn(true).times(1);
        
        EasyMock.replay(servicio);
        Domotica dom = new Domotica(servicio);
        dom.init();
        dom.encenderLuces(0.1);
        assertEquals(dom.lucesEncencidas(), true);
        EasyMock.verify(servicio);
    }

    @Test
    void testDomoticaEncenderLucesNoValidoDomoticaNotAvailable(){
        EasyMock.expect(servicio.isAvailable()).andReturn(false).times(1);
        
        EasyMock.replay(servicio);
        Domotica dom = new Domotica(servicio);
        assertThrows(IllegalStateException.class, () -> {
            dom.encenderLuces(0.1);
        });  
        EasyMock.verify(servicio);
    }

    @Test
    void testDomoticaEncenderLucesNoValidoIntensidadMenorLimite(){
        servicio.setAvailable(true);
        EasyMock.expectLastCall().times(1);
        EasyMock.expect(servicio.isAvailable()).andReturn(true).times(1);
        servicio.encenderLuces(-1);
        EasyMock.expectLastCall().andThrow(new IllegalArgumentException());
        
        EasyMock.replay(servicio);
        Domotica dom = new Domotica(servicio);
        dom.init();
        assertThrows(IllegalArgumentException.class, () -> {
            dom.encenderLuces(-1.1);
        });        
        EasyMock.verify(servicio);
    }

    @Test
    void testDomoticaEncenderLucesNoValidoIntensidadMayorLimite(){
        servicio.setAvailable(true);
        EasyMock.expectLastCall().times(1);
        EasyMock.expect(servicio.isAvailable()).andReturn(true).times(1);
        servicio.encenderLuces(101);
        EasyMock.expectLastCall().andThrow(new IllegalArgumentException());
        
        EasyMock.replay(servicio);
        Domotica dom = new Domotica(servicio);
        dom.init();
        assertThrows(IllegalArgumentException.class, () -> {
            dom.encenderLuces(101.1);
        });  
        EasyMock.verify(servicio);
    }

    @Test
    void testDomoticaEncenderLucesNoValidoLucesYaEncendidas(){
        servicio.setAvailable(true);
        EasyMock.expectLastCall().times(1);
        EasyMock.expect(servicio.isAvailable()).andReturn(true).times(2);
        servicio.encenderLuces(0);
        EasyMock.expectLastCall().times(1);
        servicio.encenderLuces(0);
        EasyMock.expectLastCall().andThrow(new IllegalStateException());
        
        EasyMock.replay(servicio);
        Domotica dom = new Domotica(servicio);
        dom.init();
        dom.encenderLuces(0.1);

        assertThrows(IllegalStateException.class, () -> {
            dom.encenderLuces(0.1);
        });  
        EasyMock.verify(servicio);
    }

    //apagarLuces
    @Test
    void testDomoticaApagarLucesValido(){
        servicio.setAvailable(true);
        EasyMock.expectLastCall().times(1);
        EasyMock.expect(servicio.isAvailable()).andReturn(true).times(1);
        servicio.apagarLuces();
        EasyMock.expectLastCall().times(1);
        EasyMock.expect(servicio.isAvailable()).andReturn(true).times(1);
        EasyMock.expect(servicio.lucesEncencidas()).andReturn(false).times(1);
        
        EasyMock.replay(servicio);
        Domotica dom = new Domotica(servicio);
        dom.init();
        dom.apagarLuces();
        assertEquals(dom.lucesEncencidas(), false);
        EasyMock.verify(servicio);
    }

    @Test
    void testDomoticaApagarLucesNoValidoDomoticaNotAvailable(){
        servicio.setAvailable(true);
        EasyMock.expectLastCall().times(1);
        EasyMock.expect(servicio.isAvailable()).andReturn(false).times(1);
        
        EasyMock.replay(servicio);
        Domotica dom = new Domotica(servicio);
        dom.init();
        assertThrows(IllegalStateException.class, () -> {
            dom.apagarLuces();
        });  
        EasyMock.verify(servicio);
    }

    @Test
    void testDomoticaApagarLucesNoValidoLucesYaApagadas(){
        servicio.setAvailable(true);
        EasyMock.expectLastCall().times(1);
        EasyMock.expect(servicio.isAvailable()).andReturn(true).times(2);
        servicio.apagarLuces();
        EasyMock.expectLastCall().times(1);
        servicio.apagarLuces();
        EasyMock.expectLastCall().andThrow(new IllegalStateException());
        
        EasyMock.replay(servicio);
        Domotica dom = new Domotica(servicio);
        dom.init();
        dom.apagarLuces();

        assertThrows(IllegalStateException.class, () -> {
            dom.apagarLuces();
        });  
        EasyMock.verify(servicio);
    }

    //lucesEncendidas
    @Test
    void testDomoticaLucesEncendidasNoValidoServicioNotAvailable(){
        EasyMock.expect(servicio.isAvailable()).andReturn(false).times(1);
        
        EasyMock.replay(servicio);
        Domotica dom = new Domotica(servicio);

        assertThrows(IllegalStateException.class, () -> {
            dom.lucesEncencidas();
        });  
        EasyMock.verify(servicio);
    }
}