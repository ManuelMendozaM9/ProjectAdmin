/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectadmin;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Manuel
 */
public class Requisicion {
    
    Integer reqID;
    Date fecha;
    Time hora;
    String status;

    public Integer getReqID() {
        return reqID;
    }

    public void setReqID(Integer reqID) {
        this.reqID = reqID;
    }
    
}
