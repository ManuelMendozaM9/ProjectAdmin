/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.DAOReq;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import projectadmin.Requisicion;

/**
 *
 * @author Manuel
 */
public class DAOReqImpl extends Conexion implements DAOReq {

    @Override
    public void registrar(Requisicion req) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Requisicion> verRequisicion() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Requisicion req) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Requisicion req) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void aprobar(Requisicion req) throws Exception {
        try{
            Connection c = Conexion.getConnection();
            PreparedStatement st = c.prepareStatement(
                    "update proveedor set status = 'Aprobada' where req_ID = ?");
            st.setInt(1, req.getReqID());
            st.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void rechazar(Requisicion req) throws Exception {
        try{
            Connection c = Conexion.getConnection();
            PreparedStatement st = c.prepareStatement(
                    "update proveedor set status = 'Rechazada' where req_ID = ?");
            st.setInt(1, req.getReqID());
            st.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.cerrar();
        }
    }
    
}
