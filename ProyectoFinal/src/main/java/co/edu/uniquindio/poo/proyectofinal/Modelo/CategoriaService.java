package co.edu.uniquindio.poo.proyectofinal.Modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CategoriaService {

    /**
     * Esta es la lista principal de categorías (las categorías padres)
     */
        private final List<Categoria> categorias = new ArrayList<>();

        /**
         * Agrega una nueva categoría padre (compuesta) a la lista.
         *
         * @param categoria Nueva categoría compuesta
         * @return true si se agregó correctamente
         */
        public boolean agregarCategoriaPadre(CategoriaCompuesto categoria) {
            return categorias.add(categoria);
        }

        /**
         * Agrega una subcategoría (simple o compuesta) a una categoría padre ya existente.
         *
         * @param indexPadre Índice de la categoría padre en la lista
         * @param subcategoria Subcategoría a agregar
         * @return true si se agregó correctamente, false si hay error
         */
        public boolean agregarSubcategoria(int indexPadre, Categoria subcategoria) {
            if (indexPadre < 0 || indexPadre >= categorias.size()) {
                System.out.println("Índice fuera de rango.");
                return false;
            }

            Categoria categoriaPadre = categorias.get(indexPadre);

            if (categoriaPadre instanceof CategoriaCompuesto categoriaCompuesta) {
                categoriaCompuesta.agregar(subcategoria);
                return true;
            } else {
                System.out.println("La categoría en el índice no es compuesta.");
                return false;
            }
        }

        /**
         * Retorna la lista completa de categorías.
         *
         * @return Lista de categorías
         */
        public List<Categoria> obtenerCategorias() {
            return categorias;
        }

        /**
         * Obtiene una categoría por su índice.
         *
         * @param index Índice
         * @return Categoría o null si no existe
         */
        public Categoria obtenerCategoria(int index) {
            if (index >= 0 && index < categorias.size()) {
                return categorias.get(index);
            }
            return null;
        }

        /**
         * Metodo que permite imprimir todas las categorías en consola de forma jerárquica.
         */
        public void mostrarCategorias() {
            for (Categoria categoria : categorias) {
                categoria.mostrar(0);
            }
        }


    /**
     *Metodo que permite eliminar una categoria por su ID
     * @param idCategoria
     * @return
     */
    public boolean eliminarCategoriaPorId(String idCategoria) {
        // Recorremos la lista principal de categorías
        for (int i = 0; i < categorias.size(); i++) {
            Categoria categoria = categorias.get(i);

            // Si la categoría coincide con el ID, la eliminamos y retornamos true
            if (categoria.getIdCategoria().equals(idCategoria)) {
                categorias.remove(i);
                return true;
            }

            // Si es categoría compuesta, intentamos eliminar recursivamente en las subcategorías
            if (categoria instanceof CategoriaCompuesto categoriaCompuesta) {
                if (eliminarSubcategoriaPorId(categoriaCompuesta, idCategoria)) {
                    return true;
                }
            }
        }
        // No se encontró la categoría con ese ID
        return false;
    }


    /**
     * Metodo qu epermite eliminar una subcategoria por su ID
     * @param categoriaCompuesta
     * @param idCategoria
     * @return
     */
    private boolean eliminarSubcategoriaPorId(CategoriaCompuesto categoriaCompuesta, String idCategoria) {
        List<Categoria> subcategorias = categoriaCompuesta.getSubcategorias();

        for (int i = 0; i < subcategorias.size(); i++) {
            Categoria subcategoria = subcategorias.get(i);

            if (subcategoria.getIdCategoria().equals(idCategoria)) {
                subcategorias.remove(i);
                return true;
            }

            // Si la subcategoría también es compuesta, llamamos recursivamente
            if (subcategoria instanceof CategoriaCompuesto subcategoriaCompuesta) {
                if (eliminarSubcategoriaPorId(subcategoriaCompuesta, idCategoria)) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * Meotdo que permite actualuzar Subcategorias
     * @param idSubcategoria
     * @param nuevaSubcategoria
     * @return
     */

    public boolean actualizarSubcategoriaPorId(String idSubcategoria, Categoria nuevaSubcategoria) {
        for (Categoria categoria : categorias) {
            if (categoria instanceof CategoriaCompuesto categoriaCompuesta) {
                if (actualizarSubcategoria(categoriaCompuesta, idSubcategoria, nuevaSubcategoria)) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean actualizarSubcategoria(CategoriaCompuesto categoriaCompuesta, String idSubcategoria, Categoria nuevaSubcategoria) {
        List<Categoria> subcategorias = categoriaCompuesta.getSubcategorias();

        for (int i = 0; i < subcategorias.size(); i++) {
            Categoria subcategoria = subcategorias.get(i);

            if (subcategoria.getIdCategoria().equals(idSubcategoria)) {
                subcategorias.set(i, nuevaSubcategoria);
                return true;
            }

            if (subcategoria instanceof CategoriaCompuesto subcategoriaCompuesta) {
                if (actualizarSubcategoria(subcategoriaCompuesta, idSubcategoria, nuevaSubcategoria)) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * Metodo que permite obtener la lista de categoria Compuestas
     * @return
     */
    public Collection<CategoriaCompuesto> obtenerListaCategoriaCompuestas() {
        return categorias.stream()
                .filter(c -> c instanceof CategoriaCompuesto)
                .map(c -> (CategoriaCompuesto) c)
                .collect(Collectors.toList());
    }


    /**
     * Metodo que permite obtener la lista de categoria Simples
     * @return
     */
    public Collection<CategoriaSimple> obtenerListaCategoriaSimples() {
        return categorias.stream()
                .filter(c -> c instanceof CategoriaSimple)
                .map(c -> (CategoriaSimple) c)
                .collect(Collectors.toList());
    }


    /**
     * Meotodo que permite consultar una categoria por su ID
     * @param idCategoria
     * @return
     */

    public Categoria buscarCategoriaPorId(String idCategoria) {
        for (Categoria categoria : categorias) {
            Categoria encontrada = buscarEnCategoria(categoria, idCategoria);
            if (encontrada != null) {
                return encontrada;
            }
        }
        return null;
    }

    /**
     * Busca una categoría por su ID dentro de una jerarquía de categorías. Si se encuentra la categoría,
     * devuelve la categoría correspondiente. En caso contrario, devuelve null.
     *
     * @param categoria
     * @param idCategoria
     * @return
     */
    private Categoria buscarEnCategoria(Categoria categoria, String idCategoria) {
        if (categoria.getIdCategoria().equals(idCategoria)) {
            return categoria;
        }

        if (categoria instanceof CategoriaCompuesto categoriaCompuesta) {
            for (Categoria subcategoria : categoriaCompuesta.getSubcategorias()) {
                Categoria encontrada = buscarEnCategoria(subcategoria, idCategoria);
                if (encontrada != null) {
                    return encontrada;
                }
            }
        }

        return null;
    }
}
