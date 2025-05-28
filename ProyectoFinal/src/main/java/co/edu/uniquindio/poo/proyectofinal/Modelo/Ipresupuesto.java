package co.edu.uniquindio.poo.proyectofinal.Modelo;

public interface Ipresupuesto {
    public boolean verificarPresupuesto(String id);
    public boolean agregarPresupuesto(Presupuesto presupuesto);
    public boolean eliminarPresupuesto(Presupuesto presupuesto);
    public boolean actualizarPresupuesto(String id, Presupuesto actualizado);
}
