/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import frames.frmLogin;
import interfaces.DAOUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import projectadmin.Usuario;

/**
 *
 * @author Manuel
 */
public class DAOUsuarioImpl extends Conexion implements DAOUsuario {

    @Override
    public void registrar(Usuario usu) throws Exception {
        try{
            Connection c = Conexion.getConnection();
            PreparedStatement st = c.prepareStatement(
                    "insert into usuario(nombre,apellido,telefono,correo,"
                            + "tipo_Usuario,usuario_Login, contraseña)"
                            + " values(?,?,?,?,?,?,?)");
            st.setString(1, usu.getNombre());
            st.setString(2, usu.getApellido());
            st.setInt(3, usu.getTelefono());
            st.setString(4, usu.getCorreo());
            st.setString(5, usu.getTiposuario());
            st.setString(6, usu.getUsuarioLogin());
            st.setString(7, usu.getPassword());
            st.executeQuery();
        }catch(Exception e){
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public List<Usuario> verUsuario() throws Exception {
        List<Usuario> lista = null;
        try{
            Connection c = Conexion.getConnection();
            PreparedStatement st = c.prepareStatement("select * from usuario");
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Usuario usu = new Usuario();
                usu.setUsuarioID(rs.getInt("Usuario_ID"));
                usu.setNombre(rs.getString("Nombre"));
                usu.setApellido(rs.getString("Descripcion"));
                usu.setTelefono(rs.getInt("Telefono"));
                usu.setCorreo(rs.getString("Correo"));
                usu.setTiposuario(rs.getString("Tipo_Usuario"));
                usu.setUsuarioLogin(rs.getString("Usuario_Login"));
                usu.setPassword(rs.getString("Contraseña"));
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
    public void modificar(Usuario usu) throws Exception {
        try{
            Connection c = Conexion.getConnection();
            PreparedStatement st = c.prepareStatement(
                    "update proveedor set nombre = ?, apellido = ?, telefono = ?,"
                    + " correo = ?, tipo_Usuario = ?, usuario_Login = ?,"
                            + " contraseña = ? where usuario_ID = ?");
            st.setString(1, usu.getNombre());
            st.setString(2, usu.getApellido());
            st.setInt(3, usu.getTelefono());
            st.setString(4, usu.getCorreo());
            st.setString(5, usu.getTiposuario());
            st.setString(6, usu.getUsuarioLogin());
            st.setString(7, usu.getPassword());
            st.setInt(8, usu.getUsuarioID());
            st.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void eliminar(Usuario usu) throws Exception {
         try{
            Connection c = Conexion.getConnection();
            PreparedStatement st = c.prepareStatement(
            "delete from usuario where usuario_ID = ?");
            st.setInt(1, usu.getUsuarioID());
            st.executeQuery();
        }catch(Exception e){
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public boolean ingresar(String usuario, String pass) throws Exception {
        boolean flag = false;
        try{
            Connection c = Conexion.getConnection();
            PreparedStatement st = c.prepareStatement(
                    "select usuario_ID from usuario"
                            + "where usuario_Login = ? "
                            + "and contraseña = ?");
            st.setString(1, usuario);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                flag = true;
            }
        }catch(Exception e){
            throw e;
        }finally{
            this.cerrar();
        }
        return flag;
    }
}

