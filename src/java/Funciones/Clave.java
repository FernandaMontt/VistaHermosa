/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import DAO.PermisoResolucionDAO;
import DTO.PermisoResolucionDTO;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author note
 */
public class Clave {
    
     public static String createNewCode(int length){
        String cadenaReferencia = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";        
        
        Random rnd = new Random();
        boolean nuevo = false;
        String newCode = "";
        do{
            StringBuilder sb = new StringBuilder();
            while (sb.length() < length) {
                int index = (int) (rnd.nextFloat() * cadenaReferencia.length());
                sb.append(cadenaReferencia.charAt(index));
            }
            newCode = sb.toString();
            
            ArrayList<PermisoResolucionDTO> listadoResoluciones = new PermisoResolucionDAO().readAll();

            for (PermisoResolucionDTO resolucion : listadoResoluciones) {
                //if(resolucion.getId_resolucion() == newCode)
                {nuevo = true;}
            }
        }while(nuevo);
        return newCode;
    }
    
    /**
     *
     * @param length
     * @return
     */
    public static String createPassword(int length){
        String cadenaReferencia = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";        
        StringBuilder sb = new StringBuilder();
        Random rnd = new Random();
        while (sb.length() < length) {
            int index = (int) (rnd.nextFloat() * cadenaReferencia.length());
            sb.append(cadenaReferencia.charAt(index));
        }
        return sb.toString();
    }
}
