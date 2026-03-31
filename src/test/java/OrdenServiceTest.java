import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OrdenServiceTest {


    @Test
    void testDescuentoSiTotalMayor500() {
        StockService stockService = mock(StockService.class);
        ClienteService clienteService = mock(ClienteService.class);

        Producto p1 = new Producto("Monitor", 400, 10, 1);
        Producto p2 = new Producto("Teclado", 150, 10, 1);

        Orden orden = new Orden();
        orden.setProductos(Arrays.asList(p1, p2));
        orden.setCliente(new Cliente("Ana", true));

        when(stockService.tieneStock(any())).thenReturn(true);
        when(clienteService.clienteActivo(orden.getCliente())).thenReturn(true);

        OrdenService service = new OrdenService(stockService, clienteService);
        String resultado = service.registrarOrden(orden);

        assertEquals("Orden registrada con descuento 10%", resultado);
    }
}