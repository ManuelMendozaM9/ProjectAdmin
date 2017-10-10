/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.DAOProveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import projectadmin.Proveedor;

/**
 *
 * @author Manuel
 */
public class DAOProveedorImpl extends Conexion implements DAOProveedor {

    @Override
    public void registrar(Proveedor prov) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Proveedor prov) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Proveedor prov) throws Exception {
        try{
            Connection c = Conexion.getConnection();
            PreparedStatement st = c.prepareStatement(
            "delete from proveedor where proveedor_ID = ?");
            st.setInt(1, prov.getProveedor_ID());
        }catch(Exception e){
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public List<Proveedor> verProveedor() throws Exception {
        List<Proveedor> lista = null;
        try{
         Connection c = Conexion.getConnection();
            PreparedStatement st = c.prepareStatement(
                    "select * from proveedor");
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Proveedor prov = new Proveedor();
                prov.setProveedor_ID(rs.getInt("Proveedor_ID"));
                prov.setNombre(rs.getString("Nombre"));
                prov.setDireccion(rs.getString("Direccion"));
                prov.setTelefono(rs.getInt("Telefono"));
                prov.setFormaPago(rs.getString("Forma_Pago"));
                prov.setRFC(rs.getString("RFC"));
                prov.setStatus(rs.getBoolean("Status"));
            }
            rs.close();
            st.close();   
        }catch(Exception e){
            throw e;
        }finally{
            this.cerrar();
        }
        return lista;
    }
    
}