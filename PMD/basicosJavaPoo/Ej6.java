class Producto {
    private String nombreProducto;
    private Double precio;

    public Producto(String nombreProducto, Double precio) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void cambiaPrecioAPesetas() {
        this.precio = this.precio * 166;
    }
}

public class Ej6 {
    public static void main(String[] args) {
        Producto p1 = new Producto("Teclado", 25.0);
        Producto p2 = new Producto("Ratón", 15.0);

        System.out.println("Producto 1: " + p1.getNombreProducto() + ", Precio: " + p1.getPrecio());
        System.out.println("Producto 2: " + p2.getNombreProducto() + ", Precio: " + p2.getPrecio());

        p1.setPrecio(null);

        try {
            p1.cambiaPrecioAPesetas();
            System.out.println("Precio de " + p1.getNombreProducto() + " en pesetas: " + p1.getPrecio());
        } catch (Exception e) {
            System.out.println("Error al cambiar precio a pesetas: el precio es null (" + e + ")");
        }
    }
}
