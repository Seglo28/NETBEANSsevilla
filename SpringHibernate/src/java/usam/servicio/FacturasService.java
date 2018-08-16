/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usam.servicio;

import java.util.List;
import persistencia.Usuarios.Facturas;

/**
 *
 * @author Admin125
 */
public interface FacturasService {

    public void AgregarFactura(Facturas fac);

    public void ActualizarFactura(Facturas fac);

    public List<Facturas> MostrarTodosFacturas();

    public Facturas MostrarUnoFacturas(Integer idFactura);

    public void EliminarFactura(Integer idFactura);
}
