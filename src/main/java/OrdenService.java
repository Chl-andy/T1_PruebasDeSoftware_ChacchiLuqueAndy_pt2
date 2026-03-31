import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrdenService {

    private StockService stockService;
    private ClienteService clienteService;

    public OrdenService(StockService stockService, ClienteService clienteService) {
        this.stockService = stockService;
        this.clienteService = clienteService;
    }

    public String registrarOrden(Orden orden) {
        if (!clienteService.clienteActivo(orden.getCliente())) {
            return "Cliente inactivo";
        }

        Set<Producto> productosUnicos = new HashSet<>(orden.getProductos());
        if (productosUnicos.size() != orden.getProductos().size()) {
            return "No se permiten productos duplicados";
        }

        for (Producto p : orden.getProductos()) {
            if (!stockService.tieneStock(p) || p.getCantidad() <= 0) {
                return "Orden cancelada por falta de stock";
            }
        }

        double total = orden.getProductos().stream().mapToDouble(p -> p.getPrecio() * p.getCantidad()).sum();
        if (total > 500) {
            return "Orden registrada con descuento 10%";
        }

        return "Orden registrada correctamente";
    }
}