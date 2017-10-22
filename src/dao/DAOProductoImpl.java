/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.DAOProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
 import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import projectadmin.Producto;
/**
 *
 * @author Manuel
 */
public class DAOProductoImpl extends Conexion implements DAOProducto {

    @Override
    public void registrar(Producto pro) throws Exception {
        try{
            Connection c = Conexion.getConnection();
            PreparedStatement st = c.prepareStatement(
                    "insert into producto(nombre,descripcion,precio,unidad_medida,"
                            + "categoria) values(?,?,?,?,?)");
            st.setString(1, pro.getNombre());
            st.setString(2, pro.getDescripcion());
            st.setDouble(3, pro.getPrecio());
            st.setString(4, pro.getUnidadMedida());
            st.setString(5, pro.getCategoria());
            st.executeQuery();
        }catch(Exception e){
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public List<Producto> verProducto() throws Exception {
        List<Producto> lista = null;
        try{
            Connection c = Conexion.getConnection();
            PreparedStatement st = c.prepareStatement("select * from producto");
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Producto pro = new Producto();
                pro.setProductoID(rs.getInt("Producto_ID"));
                pro.setNombre(rs.getString("Nombre"));
                pro.setDescripcion(rs.getString("Descripcion"));
                pro.setPrecio(rs.getDouble("Precio"));
                pro.setUnidadMedida(rs.getString("Unidad_Medida"));
                pro.setCantidadUnidadMedida(rs.getInt("Cantidad_Unidad_Medida"));
                pro.setCategoria(rs.getString("Categorias"));
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

    @Override
    public void modificar(Producto pro) throws Exception {
        try{
            Connection c = Conexion.getConnection();
            PreparedStatement st = c.prepareStatement(
                    "update producto set nombre = '?', descripcion = '?', "
                            + "precio = '?', unidad_medida = ?', categoria = '?'"
                            + " where producto_ID = ?");
            st.setString(1, pro.getNombre());
            st.setString(2, pro.getDescripcion());
            st.setDouble(3, pro.getPrecio());
            st.setString(4, pro.getUnidadMedida());
            st.setString(5, pro.getCategoria());
            st.setInt(6, pro.getProductoID());
            st.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void baja(Producto pro) throws Exception {
        try{
            Connection c = Conexion.getConnection();
            PreparedStatement st = c.prepareStatement(
                    "update proveedor set status = '?' where proveedor_ID = ?");
            st.setString(1, pro.getStatus());
            st.setInt(2, pro.getProductoID());
            st.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void eliminar(Producto pro) throws Exception {
        try{
            Connection c = Conexion.getConnection();
            PreparedStatement st = c.prepareStatement(
            "delete from producto where producto_ID = ?");
            st.setInt(1, pro.getProductoID());
        }catch(Exception e){
            throw e;
        }finally{
            this.cerrar();
        }
    }
    
}
