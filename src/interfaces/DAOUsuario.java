/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import projectadmin.Usuario;
import frames.frmLogin;

/**
 *
 * @author Manuel
 */
public interface DAOUsuario {
    public void registrar(Usuario usu) throws Exception;
    public List<Usuario> verUsuario() throws Exception;
    public void modificar(Usuario usu) throws Exception;
    public void eliminar(Usuario usu) throws Exception;
    public boolean ingresar(Usuario usu) throws Exception;    
}
