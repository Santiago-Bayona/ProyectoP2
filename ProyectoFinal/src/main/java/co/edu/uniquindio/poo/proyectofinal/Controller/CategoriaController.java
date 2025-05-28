package co.edu.uniquindio.poo.proyectofinal.Controller;

import co.edu.uniquindio.poo.proyectofinal.Modelo.*;

import java.util.Collection;
import java.util.List;

public class CategoriaController {

    private BilleteraVirtual virtual;

    public CategoriaController(BilleteraVirtual virtual) {
        this.virtual = virtual;
    }


    public boolean crearCategoriaCompuesta(String id, NombreCategoria nombre, String descripcion) {
        return virtual.crearCategoriaCompuesta(id, nombre, descripcion);
    }

    /**
     * Metodo que agrega una subcategoria usando un indice de categoria padre
     * @param indexPadre
     * @param subcategoria
     * @return
     */

    public boolean agregarSubcategoria(int indexPadre, Categoria subcategoria) {
        return virtual.agregarSubcategoriaACategoria(indexPadre, subcategoria);
    }



    public List<Categoria> obtenerCategorias() {
        return virtual.obtenerCategorias();
    }



    public boolean eliminarCategoriaPorId(String idCategoria) {
        return virtual.eliminarCategoria(idCategoria);
    }



    public boolean actualizarSubcategoriaPorId( String idSubcategoria, Categoria nuevaCategoria) {
        return virtual.actualizarSubcategoria(idSubcategoria, nuevaCategoria);
    }

    public Collection<CategoriaCompuesto> obtenerListaCategoriaCompuestas() {
        return virtual.obtenerListaCategoriaCompuestas();
    }

    public Collection<CategoriaSimple> obtenerListaCategoriaSimples() {
        return virtual.obtenerListaCategoriaSimples();
    }


}








