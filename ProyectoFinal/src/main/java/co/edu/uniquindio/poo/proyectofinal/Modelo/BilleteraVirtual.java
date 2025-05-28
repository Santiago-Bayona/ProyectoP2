package co.edu.uniquindio.poo.proyectofinal.Modelo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class BilleteraVirtual  implements ICuentaBancaria,Ipresupuesto,Itransferencia,IUsuario{
    private String Nombre;
    public Collection<Usuario> usuarios;
    public Collection<Transaccion> transacciones;
    public Collection<Administrador> administradores;
    public Collection<CuentaBancaria> cuentas;
    public Collection<Presupuesto> presupuestos;
    public Collection<Categoria> categorias;
    public Collection<Reporte> reportes;
    private List<SesionObserver> observadores = new ArrayList<>();
    private  CategoriaService categoriaService;

    public BilleteraVirtual(String nombre) {
        this.Nombre = nombre;
        this.usuarios = new LinkedList<>();
        this.transacciones = new LinkedList<>();
        this.administradores = new LinkedList<>();
        this.cuentas = new LinkedList<>();
        this.presupuestos = new LinkedList<>();
        this.categorias = new LinkedList<>();
        this.reportes = new LinkedList<>();
        this.categoriaService = new CategoriaService();
    }


    /**
     * Método que obtiene el nombre de la billetera virtual.
     *
     * @return El nombre de la billetera virtual.
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * Método que establece el nombre de la billetera virtual.
     *
     * @param nombre El nuevo nombre de la billetera virtual.
     */
    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    /**
     * Método que obtiene la colección de usuarios registrados en la billetera virtual.
     *
     * @return Una colección de objetos de tipo Usuario.
     */
    public Collection<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * Método que establece la colección de usuarios registrados en la billetera virtual.
     *
     * @param usuarios La nueva colección de usuarios.
     */
    public void setUsuarios(Collection<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * Método que obtiene la colección de transacciones realizadas en la billetera virtual.
     *
     * @return Una colección de objetos de tipo Transaccion.
     */
    public Collection<Transaccion> getTransacciones() {
        return transacciones;
    }

    /**
     * Método que establece la colección de transacciones realizadas en la billetera virtual.
     *
     * @param transacciones La nueva colección de transacciones.
     */
    public void setTransacciones(Collection<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    /**
     * Método que obtiene la colección de administradores registrados en la billetera virtual.
     *
     * @return Una colección de objetos de tipo Administrador.
     */
    public Collection<Administrador> getAdministradores() {
        return administradores;
    }

    /**
     * Método que establece la colección de administradores registrados en la billetera virtual.
     *
     * @param administradores La nueva colección de administradores.
     */
    public void setAdministradores(Collection<Administrador> administradores) {
        this.administradores = administradores;
    }

    /**
     * Método que obtiene la colección de cuentas bancarias registradas en la billetera virtual.
     *
     * @return Una colección de objetos de tipo CuentaBancaria.
     */
    public Collection<CuentaBancaria> getCuentas() {
        return cuentas;
    }

    /**
     * Método que establece la colección de cuentas bancarias registradas en la billetera virtual.
     *
     * @param cuentas La nueva colección de cuentas bancarias.
     */
    public void setCuentas(Collection<CuentaBancaria> cuentas) {
        this.cuentas = cuentas;
    }

    /**
     * Método que obtiene la colección de presupuestos registrados en la billetera virtual.
     *
     * @return Una colección de objetos de tipo Presupuesto.
     */
    public Collection<Presupuesto> getPresupuestos() {
        return presupuestos;
    }

    /**
     * Método que establece la colección de presupuestos registrados en la billetera virtual.
     *
     * @param presupuestos La nueva colección de presupuestos.
     */
    public void setPresupuestos(Collection<Presupuesto> presupuestos) {
        this.presupuestos = presupuestos;
    }

    /**
     * Método que obtiene la colección de categorías registradas en la billetera virtual.
     *
     * @return Una colección de objetos de tipo Categoria.
     */
    public Collection<Categoria> getCategorias() {
        return categorias;
    }

    /**
     * Método que establece la colección de categorías registradas en la billetera virtual.
     *
     * @param categorias La nueva colección de categorías.
     */
    public void setCategorias(Collection<Categoria> categorias) {
        this.categorias = categorias;
    }

    /**
     * Método que obtiene la colección de reportes generados en la billetera virtual.
     *
     * @return Una colección de objetos de tipo Reporte.
     */
    public Collection<Reporte> getReportes() {
        return reportes;
    }

    /**
     * Método que establece la colección de reportes generados en la billetera virtual.
     *
     * @param reportes La nueva colección de reportes.
     */
    public void setReportes(Collection<Reporte> reportes) {
        this.reportes = reportes;
    }

    public List<SesionObserver> getObservadores() {
        return observadores;
    }

    public void setObservadores(List<SesionObserver> observadores) {
        this.observadores = observadores;
    }

    /**
     * Metodo que permite verificar si ya existe un presupuesto por medio de su ID
     *
     * @param id
     * @return true
     */

    //hola
    public boolean verificarPresupuesto(String id) {
        for (Presupuesto presupuesto : presupuestos) {
            if (id.equals(presupuesto.getId())) {
                return false;
            }
        }
        return true;
    }


    /**
     * Metodo que permite agregar presupuestos a la lista verificando que no esten duplicados.
     *
     * @param presupuesto
     * @return true si el presupuestp fue agregado exitosamente, false si el presupuesto ya existe.
     */

    //hola
    public boolean agregarPresupuesto(Presupuesto presupuesto) {
        boolean centinela = false;
        boolean esUnico = verificarPresupuesto(presupuesto.getId());
        if (esUnico) {
            presupuestos.add(presupuesto);
            centinela = true;
            System.out.println("Presupuesto agregado exitosamente");
        } else {
            System.out.println("El Presupuesto ya existe");
        }
        return centinela;
    }


    /**
     * Metodo que permite eliminar un presupuestos de la lista con su ID.
     *
     * @param presupuesto
     * @return true si el presupuesto fue eliminado exitosamente, false si no se encontró en la lista.
     */

    //hola
    public boolean eliminarPresupuesto(Presupuesto presupuesto) {
        boolean centinela = false;
        boolean esUnico = !verificarPresupuesto(presupuesto.getId());
        if (esUnico) {
            presupuestos.remove(presupuesto);
            centinela = true;
            System.out.println("Presupuesto eliminado exitosamente");
        } else {
            System.out.println("El Presupuesto ya existe");
        }
        return centinela;
    }


    /**
     * Metodo que permite actualizar un presupuesto de la lista presupuestos con su ID.
     *
     * @param id
     * @param actualizado
     * @return true si el presupuestop fue actualizado exitosamente, false si no se encontró en la lista.
     */

    //hola
    public boolean actualizarPresupuesto(String id, Presupuesto actualizado) {
        boolean centinela = false;

        for (Presupuesto presupuesto : presupuestos) {
            if (presupuesto.getId().equals(id)) {
                presupuesto.setId(actualizado.getId());
                presupuesto.setMontoAsignado(actualizado.getMontoAsignado());
                presupuesto.setMontoGastado(actualizado.getMontoGastado());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    /**
     * Metodo que permite verificar si ya existe un Usuario por medio de su cedula
     *
     * @param cedula
     * @return true
     */

    //hola
    public boolean verificarUsuario(String cedula) {
        for (Usuario usuario : usuarios) {
            if (cedula.equals(usuario.getCedula())) {
                return false;
            }
        }
        return true;
    }


    /**
     * Metodo que permite agregar usuarios a la lista verificando que no esten duplicados.
     *
     * @param usuario
     * @return true si el usuario fue agregado exitosamente, false si el usuario ya existe.
     */


    //hola
    public boolean agregarUsuario(Usuario usuario) {
        boolean centinela = false;
        boolean esUnico = verificarUsuario(usuario.getCedula());
        if (esUnico) {
            usuarios.add(usuario);
            centinela = true;
            System.out.println("Usuario agregado exitosamente");
        } else {
            System.out.println("El Usuario ya existe");
        }
        return centinela;
    }


    /**
     * Metodo que permite eliminar un usuario de la lista con su cedula.
     *
     * @param usuario
     * @return true si el usuario fue eliminado exitosamente, false si no se encontró en la lista.
     */

    //hola
    public boolean eliminarUsuario(Usuario usuario) {
        boolean centinela = false;
        boolean esUnico = !verificarUsuario(usuario.getCedula());
        if (esUnico) {
            usuarios.remove(usuario);
            centinela = true;
            System.out.println("Usuario eliminado exitosamente");
        } else {
            System.out.println("El Usuario ya existe");
        }
        return centinela;
    }


    /**
     * Metodo que permite actualizar un usuario de la lista usuarios con su cedula.
     *
     * @param cedula
     * @param actualizado
     * @return true si el usuario fue actualizado exitosamente, false si no se encontró en la lista.
     */

    //hola
    public boolean actualizarUsuario(String cedula, Usuario actualizado) {
        boolean centinela = false;

        for (Usuario usuario1 : usuarios) {
            if (usuario1.getCedula().equals(cedula)) {
                usuario1.setNombre(actualizado.getNombre());
                usuario1.setContrasenia(actualizado.getContrasenia());
                usuario1.setTelefono(actualizado.getTelefono());
                usuario1.setDireccion(actualizado.getDireccion());
                usuario1.setRespuestaSeguridad(actualizado.getRespuestaSeguridad());
                usuario1.setPreguntaSeguridad(actualizado.getPreguntaSeguridad());
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    /**
     * Metodo que permite verificar si ya existe Admin por medio de su cedula.
     *
     * @param cedula
     * @return true
     */

    public boolean verificarAdministrador(String cedula) {
        for (Administrador administrador : administradores) {
            if (cedula.equals(administrador.getCedula())) {
                return false;
            }
        }
        return true;
    }


    /**
     * Metodo que permite agregar admins a la lista verificando que no esten duplicados.
     *
     * @param administrador
     * @return true si el admin fue agregado exitosamente, false si el admin ya existe.
     */

    public boolean agregarAdministrador(Administrador administrador) {
        boolean centinela = false;
        boolean esUnico = verificarAdministrador(administrador.getCedula());
        if (esUnico) {
            administradores.add(administrador);
            centinela = true;
            System.out.println("Administrador agregado exitosamente");
        } else {
            System.out.println("El Administrador ya existe");
        }
        return centinela;
    }


    /**
     * Metodo que permite eliminar un admins de la lista con su cedula.
     *
     * @param administrador
     * @return true si el admin fue eliminado exitosamente, false si no se encontró en la lista.
     */

    public boolean eliminarAdministrador(Administrador administrador) {
        boolean centinela = false;
        boolean esUnico = !verificarAdministrador(administrador.getCedula());
        if (esUnico) {
            administradores.remove(administrador);
            centinela = true;
            System.out.println("Administrador " + administrador.getNombre() + " eliminado exitosamente");
        } else {
            System.out.println("El Administrador ya existe");
        }
        return centinela;
    }


    /**
     * Metodo que permite actualizar un admin de la lista admins con su cedula.
     *
     * @param cedula
     * @param actualizado
     * @return true si el admin fue actualizado exitosamente, false si no se encontró en la lista.
     */

    public boolean actulizarAdministrador(String cedula, Administrador actualizado) {
        boolean centinela = false;

        for (Administrador administrador1 : administradores) {
            if (administrador1.getCedula().equals(cedula)) {
                administrador1.setSalario(actualizado.getSalario());
                administrador1.setNombre(actualizado.getNombre());
                administrador1.setContrasenia(actualizado.getContrasenia());
                administrador1.setTelefono(actualizado.getTelefono());
                administrador1.setDireccion(actualizado.getDireccion());
                administrador1.setRespuestaSeguridad(actualizado.getRespuestaSeguridad());
                administrador1.setPreguntaSeguridad(actualizado.getPreguntaSeguridad());
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    /**
     * Metodo que permite verificar si ya existe una transaccion por medio de su idTransaccion
     *
     * @param idTransaccion
     * @return true
     */
    public boolean verificarTransaccion(String idTransaccion) {
        for (Transaccion transaccion : transacciones) {
            if (idTransaccion.equals(transaccion.getIdTransaccion())) {
                return false;
            }
        }
        return true;
    }


    /**
     * Metodo que permite agregar transacciones a la lista verificando que no esten duplicados.
     *
     * @param transaccion
     * @return true si la transaccion fue agregado exitosamente, false si la transaccion ya existe.
     */
    public boolean agregarTransaccion(Transaccion transaccion) {
        boolean centinela = false;
        boolean esUnico = verificarTransaccion(transaccion.getIdTransaccion());
        if (esUnico && transaccion.getCuenta1().getUsuario().getBloqueado() == false) {
            transacciones.add(transaccion);
            centinela = true;
            System.out.println("Transaccion agregado exitosamente");
        } else {
            System.out.println("La transaccion ya existe");
        }
        return centinela;
    }


    /**
     * Metodo que permite eliminar una transaccion de la lista con su idTransaccion.
     *
     * @param transaccion
     * @return true si el partido fue eliminado exitosamente, false si no se encontró en la lista.
     */
    public boolean eliminarTransaccion(Transaccion transaccion) {
        boolean centinela = false;
        boolean esUnico = !verificarTransaccion(transaccion.getIdTransaccion());
        if (esUnico) {
            transacciones.remove(transaccion);
            centinela = true;
            System.out.println("Transaccion eliminado exitosamente");
        } else {
            System.out.println("La transaccion ya existe");
        }
        return centinela;
    }


    /**
     * Metodo que permite verificar si ya existe una cuenta Bancaria por medio de su idCuenta.
     *
     * @param idCuenta
     * @return true
     */
    public boolean verificarCuentaBancaria(String idCuenta) {
        for (CuentaBancaria cuentaBancaria : cuentas) {
            if (idCuenta.equals(cuentaBancaria.getIdCuenta())) {
                return false;
            }
        }
        return true;
    }


    /**
     * Metodo que permite agregar cuentas Bnacarias a la lista verificando que no esten duplicados.
     *
     * @param cuentaBancaria
     * @return true si la cuenta fue agregado exitosamente, false si la cuenta ya existe.
     */
    public boolean agregarCuentaBancaria(CuentaBancaria cuentaBancaria) {
        boolean centinela = false;
        boolean esUnico = verificarCuentaBancaria(cuentaBancaria.getIdCuenta());
        if (esUnico && cuentaBancaria.getUsuario().getBloqueado() == false) {
            cuentas.add(cuentaBancaria);
            centinela = true;
            System.out.println("Cuenta Bancaria agregado exitosamente");
        } else {
            System.out.println("La Cuenta Bancaria ya existe");
        }
        return centinela;
    }


    /**
     * Metodo que permite eliminar un cuentas de la lista con su idCuenta.
     *
     * @param cuentaBancaria
     * @return true si la cuenta Bancaria fue eliminado exitosamente, false si no se encontró en la lista.
     */
    public boolean eliminarCuentaBancaria(CuentaBancaria cuentaBancaria) {
        boolean centinela = false;
        boolean esUnico = !verificarCuentaBancaria(cuentaBancaria.getIdCuenta());
        if (esUnico) {
            cuentas.remove(cuentaBancaria);
            centinela = true;
            System.out.println("Cuenta Bancaria " + cuentaBancaria.getNumeroCuenta() + " eliminado exitosamente");
        } else {
            System.out.println("La cuenta Bancaria ya existe");
        }
        return centinela;
    }

    /**
     * Metodo que actualiza la informacion de la cuenta
     * @param id
     * @param actualizado
     * @return
     */
    public boolean actualizarCuenta(String id, CuentaBancaria actualizado) {
        boolean centinela = false;

        for (CuentaBancaria cuentaBancaria : cuentas) {
            if (cuentaBancaria.getIdCuenta().equals(id)) {
                cuentaBancaria.setIdCuenta(actualizado.getIdCuenta());
                cuentaBancaria.setNumeroCuenta(actualizado.getNumeroCuenta());
                cuentaBancaria.setTipoCuenta(actualizado.getTipoCuenta());
                cuentaBancaria.setBanco(actualizado.getBanco());
                cuentaBancaria.setUsuario(actualizado.getUsuario());
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    /**
     * Metood que permite iniciar sesion
     * @param correo
     * @param contrasenia
     * @return
     */
    public String iniciarSesion2(String correo, String contrasenia) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCorreo().equals(correo) && usuario.getContrasenia().equals(contrasenia)) {
                notificarInicioSesion(correo, "usuario");
                return "usuario";
            }
        }
        for (Administrador administrador : administradores) {
            if (administrador.getCorreo().equals(correo) && administrador.getContrasenia().equals(contrasenia)) {
                notificarInicioSesion(correo, "admin");
                return "admin";
            }
        }
        notificarInicioSesion(correo, "ninguno");
        return "ninguno";
    }

    /**
     * Metodo que permite recuerr la contraseña
     * @param usuario1
     * @param respuesta
     * @param preguntaSeguridad
     * @param ContraseniaNueva
     * @return
     */
    public boolean RecuperarContraseña(Usuario usuario1, String respuesta, Persona.PreguntaSeguridad preguntaSeguridad, String ContraseniaNueva){
        for (Usuario usuario : usuarios) {
            if (respuesta.equals(usuario.getRespuestaSeguridad()) && preguntaSeguridad.equals(usuario.getPreguntaSeguridad())){
                usuario.setContrasenia(ContraseniaNueva);
                return true;
            }
        }
        return false;
    }


    /**
     *
     * @param id
     * @return
     */
    public boolean EnviarTransaccion(String id) {
        boolean centinela = false;
        for (Transaccion transaccion : transacciones) {
            if (transaccion.getIdTransaccion().equals(id) && transaccion.getCuenta1().getUsuario().getBloqueado() == false) {
                switch (transaccion.getTipoTransaccion()) {
                    case TipoTransaccion.TRANSFERENCIA:
                        if (transaccion.getCuenta2().getUsuario().getBloqueado() == false){
                        double resultado = transaccion.getCuenta1().getSaldoCuenta() - transaccion.getMonto();
                        transaccion.getCuenta1().setSaldoCuenta(resultado);
                        double resultado2 = transaccion.getCuenta2().getSaldoCuenta() + transaccion.getMonto();
                        transaccion.getCuenta2().setSaldoCuenta(resultado2);
                        centinela = true;}

                        return centinela;
                    case TipoTransaccion.DEPOSITO:
                        double resultado3 = transaccion.getCuenta1().getSaldoCuenta() + transaccion.getMonto();
                        transaccion.getCuenta1().setSaldoCuenta(resultado3);
                        centinela = true;
                        return centinela;
                    case TipoTransaccion.RETIRO:
                        double resultado4 = transaccion.getCuenta1().getSaldoCuenta() - transaccion.getMonto() ;
                        transaccion.getCuenta1().setSaldoCuenta(resultado4);
                        centinela = true;

                        return centinela;
                    default:
                        System.out.println("No se pudo realizar la transaccion");

                }
            }
        }
    return centinela;
    }


    /**
     *
     * @param id
     * @return
     */
    public boolean VerificarCategoria(String id) {
        for (Categoria categoria : categorias) {
            if (id.equals(categoria.getIdCategoria())) {
                return false;
            }
        }
        return true;
    }


    /**
     * Metodo que permite agregar cuentas Categorias a la lista verificando que no esten duplicados.
     *
     * @param categoria
     * @return true si la categoria fue agregado exitosamente, false si la categoria ya existe.
     */
    public boolean agregarCategoria(Categoria categoria) {
        boolean centinela = false;
        boolean esUnico = VerificarCategoria(categoria.getIdCategoria());
        if (esUnico) {
            categorias.add(categoria);
            centinela = true;
            System.out.println("Categoria agregado exitosamente");
        } else {
            System.out.println("La Categoria ya existe");
        }
        return centinela;
    }


    /**
     * Metodo que permite eliminar una categoria de la lista con su idCuenta.
     *
     * @param categoria
     * @return true si la categoria fue eliminado exitosamente, false si no se encontró en la lista.
     */
    public boolean eliminarCategoria(Categoria categoria) {
        boolean centinela = false;
        boolean esUnico = !VerificarCategoria(categoria.getIdCategoria());
        if (esUnico) {
            categorias.remove(categoria);
            centinela = true;
            System.out.println("Cuenta Bancaria " + categoria.getIdCategoria() + " eliminado exitosamente");
        } else {
            System.out.println("La cuenta Bancaria ya existe");
        }
        return centinela;
    }

    /**
     * Verfica que
     * @param id
     * @return
     */
    public boolean VerificarReporte(String id) {
        for (Reporte reporte : reportes) {
            if (id.equals(reporte.getID())) {
                return false;
            }
        }
        return true;
    }


    /**
     * Metodo que permite agregar cuentas Bnacarias a la lista verificando que no esten duplicados.
     *
     * @param reporte
     * @return true si la cuenta fue agregado exitosamente, false si la cuenta ya existe.
     */

    //hola
    public boolean agregarReporte(Reporte reporte) {
        boolean centinela = false;
        boolean esUnico = VerificarReporte(reporte.getID());
        if (esUnico) {
            reportes.add(reporte);
            centinela = true;
            System.out.println("Reporte agregado exitosamente");
        } else {
            System.out.println("El reporte ya existe");
        }
        return centinela;
    }


    /**
     * Metodo que permite eliminar un cuentas de la lista con su idCuenta.
     *
     * @param reporte
     * @return true si la cuenta Bancaria fue eliminado exitosamente, false si no se encontró en la lista.
     */

    //hola
    public boolean eliminarReporte(Reporte reporte) {
        boolean centinela = false;
        boolean esUnico = !VerificarReporte(reporte.getID());
        if (esUnico) {
            reportes.remove(reporte);
            centinela = true;
            System.out.println("Reporte " + reporte.getTitulo() + " eliminado exitosamente");
        } else {
            System.out.println("El Reporte No existe");
        }
        return centinela;
    }




    /**
     * Metodo que permite consultar una transaccion con el IdTransaccion
     * @param idTransaccion
     * @return
     */
    public Transaccion consultarTransaccion(String idTransaccion) {
        for (Transaccion transaccion : transacciones) {
            if (transaccion.getIdTransaccion().equals(idTransaccion)) {
                System.out.println("La transaccion consultado es: " + transaccion);
                return transaccion;
            }
        }
        System.out.println("La transaccion con un ID " + idTransaccion + " no se encuentra.");
        return null;
    }

    /**
     *
     * @param observer
     */
    public void agregarObserver(SesionObserver observer) {
        observadores.add(observer);
    }

    /**
     *
     * @param usuario
     * @return
     */
    public boolean bloquearUsuario(Usuario usuario) {
        for (Usuario u : usuarios) {
            if (u.getCorreo().equals(usuario.getCorreo())) {
                u.setBloqueado(true);
                return true;
            }
        }
        return false;
    }
    /**
     * Metodo que permite crear una categoria compuesta (Padre)
     * @param id
     * @param nombre
     * @param descripcion
     * @return
     */
    public boolean crearCategoriaCompuesta(String id, NombreCategoria nombre, String descripcion) {
        CategoriaCompuesto nuevaCategoria = new CategoriaCompuesto(id, nombre, descripcion, new ArrayList<>());
        return categoriaService.agregarCategoriaPadre(nuevaCategoria);
    }

    /**
     * Metodo para agregar una subcategoria a un categoria
     * @param indexPadre
     * @param subcategoria
     * @return
     */
    public boolean agregarSubcategoriaACategoria(int indexPadre, Categoria subcategoria) {
        return categoriaService.agregarSubcategoria(indexPadre, subcategoria);
    }


    /**
     * Metodo que permite obtener la lista de categorias
     * @return
     */
    public List<Categoria> obtenerCategorias() {
        return categoriaService.obtenerCategorias();
    }

    /**
     * Meotodo que permite mostrar la jerarquía completa
     */
    public void mostrarCategorias() {
        categoriaService.mostrarCategorias();
    }

    /**
     * Metodo que permite eliminar una categoria dado su id.
     *
     * @param idCategoria el identificador de la categoria a eliminar.
     * @return true si la categoria fue eliminada exitosamente, false en caso contrario.
     */
    public boolean eliminarCategoria(String idCategoria) {
        return categoriaService.eliminarCategoriaPorId(idCategoria);
    }

    /**
     * Metodo que permite consultar una categoria por su id.
     *
     * @param idCategoria el identificador de la categoria a consultar.
     * @return la categoria correspondiente si se encuentra, null en caso contrario.
     */
    public Categoria consultarCategoriaPorId(String idCategoria) {
        return categoriaService.buscarCategoriaPorId(idCategoria);
    }

    /**
     * Metodo que permite actualizar una subcategoria dado su id.
     *
     * @param idSubcategoria    el identificador de la subcategoria a actualizar.
     * @param nuevaSubcategoria la nueva informacion de la subcategoria.
     * @return true si la subcategoria fue actualizada exitosamente, false en caso contrario.
     */
    public boolean actualizarSubcategoria(String idSubcategoria, Categoria nuevaSubcategoria) {
        return categoriaService.actualizarSubcategoriaPorId(idSubcategoria, nuevaSubcategoria);
    }

    /**
     * Metodo que permite obtener la lista de categorias compuestas existentes.
     *
     * @return una coleccion que contiene todas las categorias compuestas.
     */
    public Collection<CategoriaCompuesto> obtenerListaCategoriaCompuestas() {
        return categoriaService.obtenerListaCategoriaCompuestas();
    }

    /**
     * Metodo que permite obtener la lista de categorias simples existentes.
     *
     * @return una coleccion que contiene todas las categorias simples.
     */
    public Collection<CategoriaSimple> obtenerListaCategoriaSimples() {
        return categoriaService.obtenerListaCategoriaSimples();
    }

    /**
     * Metodo que permite obtener todas las cuentas bancarias asociadas a un usuario.
     *
     * @param usuario el usuario del que se desean obtener las cuentas bancarias.
     * @return una coleccion con las cuentas bancarias del usuario.
     */
    public Collection<CuentaBancaria> getCuentasPorUsuario(Usuario usuario) {
        return cuentas.stream()
                .filter(cuenta -> cuenta.getUsuario().equals(usuario))
                .collect(Collectors.toList());
    }

    /**
     * Metodo que notifica a los observadores cuando un usuario inicia sesion.
     *
     * @param correo      el correo del usuario que inicio sesion.
     * @param tipoUsuario el tipo de usuario que inicio sesion (e.g., "usuario" o "admin").
     */
    public void notificarInicioSesion(String correo, String tipoUsuario) {
        for (SesionObserver observer : observadores) {
            observer.sesionIniciada(correo, tipoUsuario);
        }
    }
}