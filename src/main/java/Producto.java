public class Producto {
    private String nombre;
    private double precio;
    private int stock;
    private int cantidad;

    public Producto(String nombre, double precio, int stock, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.cantidad = cantidad;
    }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public int getCantidad() { return cantidad; }

    public double getPrecio() { return precio; }
}