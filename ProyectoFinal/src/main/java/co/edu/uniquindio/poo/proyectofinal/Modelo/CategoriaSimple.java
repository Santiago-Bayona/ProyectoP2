package co.edu.uniquindio.poo.proyectofinal.Modelo;


public class CategoriaSimple extends Categoria {

    /**
     *
     * @param idCategoria
     * @param nombreCategoria
     * @param descripcion
     */
    public CategoriaSimple(String idCategoria, NombreCategoria nombreCategoria, String descripcion) {
            super(idCategoria, nombreCategoria, descripcion);
    }

    /**
     * Muestra una categoria simple
     * @param nivel
     */
    @Override
    public void mostrar(int nivel) {
        System.out.println("  ".repeat(nivel) + "- " + getNombreCategoria() + " - " + getDescripcion());
    }
}