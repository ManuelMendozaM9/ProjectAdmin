/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import projectadmin.Requisicion;

/**
 *
 * @author Manuel
 */
public interface DAOReq {
    public void registrar(Requisicion req) throws Exception;
    public List<Requisicion> verRequisicion() throws Exception;
    public void modificar(Requisicion req) throws Exception;
    public void eliminar(Requisicion req) throws Exception;
    public void aprobar(Requisicion req) throws Exception;
    public void rechazar(Requisicion req) throws Exception;
}
