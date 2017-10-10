/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import projectadmin.Proveedor;

/**
 *
 * @author Manuel
 */
public interface DAOProveedor {
    public void registrar(Proveedor prov) throws Exception;
    public void modificar(Proveedor prov) throws Exception;
    public void eliminar(Proveedor prov) throws Exception;
    public List<Proveedor> verProveedor() throws Exception;
}
