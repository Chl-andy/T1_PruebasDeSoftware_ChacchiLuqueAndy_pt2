import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OrdenServiceTest {

    @Test
    void testCancelarOrdenPorStock() {
        StockService stockService = mock(StockService.class);
        ClienteService clienteService = mock(ClienteService.class);

        Producto p1 = new Producto("Laptop", 300, 0, 1); // sin stock
        Producto p2 = new Producto("Mouse", 50, 10, 1);

        Orden orden = new Orden();
        orden.setProductos(Arrays.asList(p1, p2));
        orden.setCliente(new Cliente("Carlos", true));

        when(stockService.tieneStock(p1)).thenReturn(false);
        when(stockService.tieneStock(p2)).thenReturn(true);
        when(clienteService.clienteActivo(orden.getCliente())).thenReturn(true);

        OrdenService service = new OrdenService(stockService, clienteService);
        String resultado = service.registrarOrden(orden);

        assertEquals("Orden cancelada por falta de stock", resultado);
    }
}