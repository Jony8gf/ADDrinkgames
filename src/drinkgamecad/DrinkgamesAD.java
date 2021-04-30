/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drinkgamecad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jony8
 */
public class DrinkgamesAD {
    
    static String dml = null;
    Connection conexion;

    /**
     * Método constructor vacio de la clase.
     *
     * @throws drinkgamecad.ExcepcionDG Se lanzará cuando se
     * produzca algún problema al cargar el jdbc
     */
    public DrinkgamesAD() throws ExcepcionDG {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            ExcepcionDG exc = new ExcepcionDG();
            exc.setMensajeErrorUsuario("Error en el sistema, consulte con el administrador");
            exc.setMensajeErrorAdministrador(ex.getMessage());
            throw exc;
        }
    }

    /**
     * Método contructor vacio de la clase.
     *
     * @throws drinkgamecad.ExcepcionDG Se lanzará cuando se
     * produzca algún problema al conectar con la BD
     */
    public void conectarBD() throws ExcepcionDG {
        try {
            conexion = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.120:1521:test", "DRINKGAME", "kk");

        } catch (SQLException ex) {
            ExcepcionDG exc = new ExcepcionDG();
            exc.setMensajeErrorAdministrador(ex.getMessage());
            exc.setCodigoError(ex.getErrorCode());
            exc.setMensajeErrorUsuario("Error en el sistema. Consulta con el administrador");

            throw exc;
        }
    }

    /**
     * Método contructor vacio de la clase.
     *
     * @throws drinkgamecad.ExcepcionDG Se lanzará cuando se
     * produzca algún problema al conectar con la BD
     */
    public void desconectarDB() throws ExcepcionDG {
        try {
            conexion.close();
        } catch (SQLException ex) {
            ExcepcionDG exc = new ExcepcionDG();
            exc.setMensajeErrorAdministrador(ex.getMessage());
            exc.setCodigoError(ex.getErrorCode());
            exc.setMensajeErrorUsuario("Error en el sistema. Consulta con el administrador");

            throw exc;
        }
    }
    
    
    
}
