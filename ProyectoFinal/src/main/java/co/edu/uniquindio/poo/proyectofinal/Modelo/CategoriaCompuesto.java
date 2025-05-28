package co.edu.uniquindio.poo.proyectofinal.Modelo;

import java.util.ArrayList;
import java.util.List;

public class CategoriaCompuesto extends Categoria {

    private List<Categoria> subcategorias = new ArrayList<>();

    /**
     *
     * @param idCategoria
     * @param nombreCategoria
     * @param descripcion
     * @param subcategorias
     */
    public CategoriaCompuesto(String idCategoria, NombreCategoria nombreCategoria, String descripcion, List<Categoria> subcategorias) {
        super(idCategoria, nombreCategoria, descripcion);
        this.subcategorias = subcategorias;
    }

    /**
     * Método que obtiene la lista de subcategorías.
     *
     * @return Lista de subcategorías.
     */
    public List<Categoria> getSubcategorias() {
        return subcategorias;
    }

    /**
     * Método que permite establecer la lista de subcategorías.
     *
     * @param subcategorias Lista de subcategorías.
     */
    public void setSubcategorias(List<Categoria> subcategorias) {
        this.subcategorias = subcategorias;
    }

    /**
     * Método que permite agregar una subcategoría a la lista.
     *
     * @param categoria Subcategoría a agregar.
     */
    public void agregar(Categoria categoria) {
        subcategorias.add(categoria);
    }

    /**
     * Método que permite eliminar una subcategoría de la lista.
     *
     * @param categoria Subcategoría a eliminar.
     */
    public void eliminar(Categoria categoria) {
        subcategorias.remove(categoria);
    }

    @Override
     public void mostrar(int nivel) {
       System.out.println("  ".repeat(nivel) + "+ " + getNombreCategoria() + " - " + getDescripcion());
       for (Categoria ctg : subcategorias) {
           ctg.mostrar(nivel + 1);
       }
    }

}
