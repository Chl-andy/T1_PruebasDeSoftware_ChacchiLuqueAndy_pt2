public class Cliente {
    private String nombre;
    private boolean activo;

    public Cliente(String nombre, boolean activo) {
        this.nombre = nombre;
        this.activo = activo;
    }

    public boolean isActivo() { return activo; }
}