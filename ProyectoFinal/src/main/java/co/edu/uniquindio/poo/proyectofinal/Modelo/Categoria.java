package co.edu.uniquindio.poo.proyectofinal.Modelo;

public abstract class Categoria {
    private String idCategoria;
    private String descripcion;
    private NombreCategoria nombreCategoria;

    /**
     * Metodo Constructor de la clase
     *
     * @param idCategoria
     * @param nombreCategoria
     * @param descripcion
     */
    public Categoria(String idCategoria, NombreCategoria nombreCategoria, String descripcion) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.descripcion = descripcion;
    }

    /**
     * Metodo que obtiene el identificador de la categoria.
     *
     * @return
     */
    public String getIdCategoria() {
        return idCategoria;
    }

    /**
     * Método que permite establecer el identificador de la categoría.
     *
     * @param idCategoria Identificador de la categoría.
     */
    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     * Método que obtiene la descripción de la categoría.
     *
     * @return Descripción de la categoría.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método que permite establecer la descripción de la categoría.
     *
     * @param descripcion Descripción de la categoría.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Método que obtiene el nombre de la categoría.
     *
     * @return Nombre de la categoría.
     */
    public NombreCategoria getNombreCategoria() {
        return nombreCategoria;
    }

    /**
     * Método que permite establecer el nombre de la categoría.
     *
     * @param nombreCategoria Nombre de la categoría.
     */
    public void setNombreCategoria(NombreCategoria nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "idCategoria='" + idCategoria + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", nombreCategoria=" + nombreCategoria +
                '}';
    }

    public abstract void mostrar(int nivel);

}
