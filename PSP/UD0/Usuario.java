class Usuario {
    private String nombre;
    private int mesesSuscripcion;
    private boolean activo;

    public Usuario(String nombre, int mesesSuscripcion) {
        this.nombre = nombre;
        this.mesesSuscripcion = mesesSuscripcion;
        this.activo = true;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getMesesSuscripcion() {
        return mesesSuscripcion;
    }

    public boolean isActivo() {
        return activo;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMesesSuscripcion(int mesesSuscripcion) {
        this.mesesSuscripcion = mesesSuscripcion;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void calculoGastado(Double cuota) {
        System.out.println("Gastado: " + (mesesSuscripcion * cuota));
        ;
    }

    public void verPerfil() {
        System.out.println("Perfil de Usuario:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Meses suscrito: " + mesesSuscripcion);
        System.out.println("Estado: " + (activo ? "Activo" : "Inactivo"));
    }

}
