/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drinkgamecad;

import herramientas.Frase;
import herramientas.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author Jonathan Gonzalez Fraga
 */
public class DrinkgamesAD {

    static String dml = null;
    Connection conexion;
    String ip;

    /**
     * Método constructor vacio de la clase.
     *
     * @param ip para indicar la direccion ip del servidor de base de datos
     * @throws drinkgamecad.ExcepcionDG Se lanzará cuando se produzca algún
     * problema al cargar el jdbc
     */
    public DrinkgamesAD(String ip) throws ExcepcionDG {
        try {
            this.ip = ip;
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
     * @throws drinkgamecad.ExcepcionDG Se lanzará cuando se produzca algún
     * problema al conectar con la BD
     */
    public void conectarBD() throws ExcepcionDG {
        try {
            conexion = DriverManager.getConnection("jdbc:oracle:thin:@"+ip+":1521:test", "DRINKGAME", "kk");
            //conexion = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.120:1521:test", "DRINKGAME", "kk");
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
     * @throws drinkgamecad.ExcepcionDG Se lanzará cuando se produzca algún
     * problema al conectar con la BD
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

    //Get de Ip --> Que devuelve la Ip del Objeto DrinkGamesAd
    public String getIp() {
        return ip;
    }

    //Set de Ip --> Que modifica la Ip del Objeto DrinkGamesAd
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * Metodo que sirve para la creacion de un Usuario en la base de datos
     * @param usuario se pasa un Objeto de tipo Usuario para coger sus elementos/datos 
     * @return retorna un entero con el numero de registros afectados
     * @throws ExcepcionDG
     */
    public int insertarUsuario(Usuario usuario) throws ExcepcionDG {

        conectarBD();

        String dml = "insert into Usuario (ID, NOMBRE, CORREO, CERVEZAS, ADS, AVATAR) values (SEQUENCE_USUARIO_ID.nextval, ?, ?, ?, ? , ?)";
        int registrosAfectados = 0;

        try {

            PreparedStatement sentenciaPreparada = conexion.prepareStatement(dml);

            sentenciaPreparada.setString(1, usuario.getNombre());
            sentenciaPreparada.setString(2, usuario.getCorreo());
            sentenciaPreparada.setObject(3, usuario.getCervezas(), Types.INTEGER);
            sentenciaPreparada.setString(4, usuario.getAds());
            sentenciaPreparada.setObject(5, usuario.getAvatar(), Types.INTEGER);
            registrosAfectados = sentenciaPreparada.executeUpdate();

            sentenciaPreparada.close();
            conexion.close();

        } catch (SQLException ex) {
            ExcepcionDG e = new ExcepcionDG();
            e.setCodigoError(ex.getErrorCode());
            e.setMensajeErrorAdministrador(ex.getMessage());
            e.setMensajeErrorUsuario("Error al insertar. Compruebe los datos introducidos.");
            e.setSentenciaSQL(dml);

            switch (ex.getErrorCode()) {

                case 1400:
                    e.setMensajeErrorUsuario("Comprueba que los campos Nombre, Localidad, Código postal, Dirección,"
                            + " Email y Telefono están debidamente rellenados.");
                    break;

                case 1:
                    e.setMensajeErrorUsuario("El Email y Telefono ya existe por otro Usuario.");
                    break;

                case 2290:
                    e.setMensajeErrorUsuario("El Email se pon @");
                    break;

                default:
                    e.setMensajeErrorUsuario("Error general del sistema. Consulte con el administrador");
            }

            throw e;
        }

        desconectarDB();

        return registrosAfectados;
    }

    /**
     * Este Metodo sirve para modificar los datos de un Usuario de la base de datos
     * @param usuario se pasa un Objeto de tipo Usuario para coger sus elementos/datos 
     * @return devuelve un entero con el numero de registros afectados
     * @throws ExcepcionDG
     */
    public int modificarUsuario(Usuario usuario) throws ExcepcionDG {

        conectarBD();

        String dml = "UPDATE USUARIO SET NOMBRE = ?, CORREO = ?, CERVEZAS = ?, ADS = ?, AVATAR  = ? WHERE CORREO LIKE ?";
        int registrosAfectados = 0;

        try {

            PreparedStatement sentenciaPreparada = conexion.prepareStatement(dml);

            sentenciaPreparada.setString(1, usuario.getNombre());
            sentenciaPreparada.setString(2, usuario.getCorreo());
            sentenciaPreparada.setObject(3, usuario.getCervezas(), Types.INTEGER);
            sentenciaPreparada.setString(4, usuario.getAds());
            sentenciaPreparada.setObject(5, usuario.getAvatar(), Types.INTEGER);
            sentenciaPreparada.setString(6, usuario.getCorreo());
            registrosAfectados = sentenciaPreparada.executeUpdate();

            sentenciaPreparada.close();
            conexion.close();

        } catch (SQLException ex) {
            ExcepcionDG e = new ExcepcionDG();
            e.setCodigoError(ex.getErrorCode());
            e.setMensajeErrorAdministrador(ex.getMessage());
            e.setMensajeErrorUsuario("Error al insertar. Compruebe los datos introducidos.");
            e.setSentenciaSQL(dml);

            switch (ex.getErrorCode()) {

                case 1407:
                    e.setMensajeErrorUsuario("Comprueba que los campos están debidamente rellenados.");
                    break;

                case 1:
                    e.setMensajeErrorUsuario("El Email y Telefono ya existe por otro Usuario.");
                    break;

                case 2290:
                    e.setMensajeErrorUsuario("El Email se pon @");
                    break;
                case 2291:
                    e.setMensajeErrorUsuario("El Id de Usuario no existe");
                    break;

                default:
                    e.setMensajeErrorUsuario("Error general del sistema. Consulte con el administrador");
            }

            throw e;
        }

        desconectarDB();

        return registrosAfectados;
    }

    /**
     * Metodo que srive para eliminar un Usuario
     * @param correo correo se pasa un String con la direccion de correo del Usuario
     * @return devulve los numeros de registros afectados
     * @throws ExcepcionDG
     */
    public int eliminarUsuario(String correo) throws ExcepcionDG {

        conectarBD();
        String dml = "DELETE FROM USUARIO WHERE CORREO LIKE '" + correo + "' ";
        int registrosAfectados;

        try {
            Statement sentencia = conexion.createStatement();

            registrosAfectados = sentencia.executeUpdate(dml);

            sentencia.close();
            conexion.close();

        } catch (SQLException ex) {
            ExcepcionDG e = new ExcepcionDG();
            e.setCodigoError(ex.getErrorCode());
            e.setMensajeErrorAdministrador(ex.getMessage());
            e.setMensajeErrorUsuario("Error al borrar. Compruebe los datos introducidos.");
            e.setSentenciaSQL(dml);

            switch (ex.getErrorCode()) {

                case 2292:
                    e.setMensajeErrorUsuario("No se puede borrar un usuario que tiene asignado frases.");
                    break;

                default:
                    e.setMensajeErrorUsuario("Error general del sistema. Consulte con el administrador");
            }

            throw e;
        }

        return registrosAfectados;
    }

    /**
     * Este método sirve para seleccionar el Id de un Usuario
     * @param correo se pasa un String con la direccion de correo del Usuario
     * @return devulve un objeto tipo Usuario con todos sus datos de la base de datos
     * @throws ExcepcionDG
     */
    public Usuario selectId(String correo) throws ExcepcionDG {

        Usuario usuario = new Usuario();
        Integer id = 0;
        String dql = "SELECT * FROM USUARIO WHERE CORREO like '" + correo + "'";

        try {
            conectarBD();

            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(dql);
            if (resultado.next()) {
                usuario.setId(resultado.getInt("id"));
                usuario.setNombre(resultado.getString("nombre"));
                usuario.setCorreo(resultado.getString("correo"));
                usuario.setCervezas(resultado.getInt("cervezas"));
                usuario.setAds(resultado.getString("ads"));
                usuario.setAvatar(resultado.getInt("avatar"));
                usuario.setAuxSeleccion(4);

            } else {
                return null;
            }

            resultado.close();
            sentencia.close();

        } catch (SQLException ex) {
            ExcepcionDG exc = new ExcepcionDG();
            exc.setMensajeErrorAdministrador(ex.getMessage());
            exc.setCodigoError(ex.getErrorCode());
            exc.setSentenciaSQL(dql);

            throw exc;
        }
        desconectarDB();

        return usuario;
    }

    /**
     * Este metodo sirve para insertar Frases por defecto al Usuario
     * @param usuario se pasa un Objeto de tipo Usuario para coger su Id y sus Frases de su ArrayList
     * @param frase se pasa una Objeto tipo Frase para introducir sus valores
     * @return retorna un entero con los registros afectados
     * @throws ExcepcionDG
     */
    public int insertarFrasesUsuario(Usuario usuario, Frase frase) throws ExcepcionDG {

        conectarBD();
        
        int registrosAfectados = 0;
        
        String dml = "insert into Frase (ID, DESCRIPCION, TIPO, IDUSUARIO) values (SEQUENCE_FRASE_ID.nextval, ?, ? , ?)";

        try {

            PreparedStatement sentenciaPreparada = conexion.prepareStatement(dml);

            sentenciaPreparada.setString(1, frase.getDescripcion());
            sentenciaPreparada.setString(2, frase.getTipo());
            sentenciaPreparada.setObject(3, usuario.getId(), Types.INTEGER);
            
            registrosAfectados = sentenciaPreparada.executeUpdate();

            sentenciaPreparada.close();
            conexion.close();

        } catch (SQLException ex) {
            ExcepcionDG e = new ExcepcionDG();
            e.setCodigoError(ex.getErrorCode());
            e.setMensajeErrorAdministrador(ex.getMessage());
            e.setMensajeErrorUsuario("Error al insertar. Compruebe los datos introducidos.");
            e.setSentenciaSQL(dml);

            switch (ex.getErrorCode()) {

                case 1400:
                    e.setMensajeErrorUsuario("Comprueba que los campos Descripcion y Tipo estan rellenados.");
                    break;

                default:
                    e.setMensajeErrorUsuario("Error general del sistema. Consulte con el administrador");
            }

            throw e;
        }

        desconectarDB();

        return registrosAfectados;
    }

    /**
     * Metodo que sirve para borrar todas las frases de un usuario
     * @param usuario se pasa un Objeto de tipo Usuario para coger su Id
     * @return devuelve un entero de los registroa afectados
     * @throws ExcepcionDG
     */
    public int eliminarFrasesDeUnUsuario(Usuario usuario) throws ExcepcionDG {

        conectarBD();
        String dml = "DELETE FROM FRASE WHERE IDUSUARIO = " + usuario.getId();
        int registrosAfectados;

        try {
            Statement sentencia = conexion.createStatement();

            registrosAfectados = sentencia.executeUpdate(dml);

            sentencia.close();
            conexion.close();

        } catch (SQLException ex) {
            ExcepcionDG e = new ExcepcionDG();
            e.setCodigoError(ex.getErrorCode());
            e.setMensajeErrorAdministrador(ex.getMessage());
            e.setMensajeErrorUsuario("Error al borrar. Compruebe los datos introducidos.");
            e.setSentenciaSQL(dml);

            switch (ex.getErrorCode()) {

                case 2292:
                    e.setMensajeErrorUsuario("No se puede borrar una frases.");
                    break;

                default:
                    e.setMensajeErrorUsuario("Error general del sistema. Consulte con el administrador");
            }

            throw e;
        }

        return registrosAfectados;
    }
    
    /**
     * Este Metodo sirvee para Modificar las frases de un Usuario Autenticado
     * @param usuario  se pasa un Objeto de tipo Usuario para coger su Id y su frases de su ArrayList
     * @param i Funciona como iterador
     * @return Devuelve un entero de los numeros de registros afectados
     * @throws ExcepcionDG
     */
    public int modificarFrasesUsuario(Usuario usuario, int i) throws ExcepcionDG {

        conectarBD();
        
        ArrayList<Frase> frases = new ArrayList<>();
        frases = usuario.getFrases();
        
        int registrosAfectados = 0;
       
        
        String dml = "update frase set descripcion = ? , tipo = ?  where idusuario = ? and id = ? ";

        try {

            PreparedStatement sentenciaPreparada = conexion.prepareStatement(dml);

            sentenciaPreparada.setString(1, frases.get(i).getDescripcion());
            sentenciaPreparada.setString(2, frases.get(i).getTipo());
            sentenciaPreparada.setObject(3, usuario.getId(), Types.INTEGER);
            sentenciaPreparada.setObject(4, frases.get(i).getId(), Types.INTEGER);
            
            registrosAfectados = sentenciaPreparada.executeUpdate();

            sentenciaPreparada.close();
            conexion.close();

        } catch (SQLException ex) {
            ExcepcionDG e = new ExcepcionDG();
            e.setCodigoError(ex.getErrorCode());
            e.setMensajeErrorAdministrador(ex.getMessage());
            e.setMensajeErrorUsuario("Error al insertar. Compruebe los datos introducidos.");
            e.setSentenciaSQL(dml);

            switch (ex.getErrorCode()) {

                case 1401:
                    e.setMensajeErrorUsuario("Comprueba que los campos Descripcion y Tipo estan rellenados.");
                    break;

                default:
                    e.setMensajeErrorUsuario("Error general del sistema. Consulte con el administrador");
            }

            throw e;
        }

        desconectarDB();

        return registrosAfectados;
    }
    
    /**
     * Metodo para Mostrar Frases de un Usuario
     * @param usuario se pasa un Objeto de tipo Usuario para coger su Id
     * @return Devuelve una ArrayList con las frases del Usuario
     * @throws ExcepcionDG
     */
    public ArrayList<Frase> mostrarFrases(Usuario usuario) throws ExcepcionDG{
        
        
            conectarBD();
            ArrayList<Frase> listaFrases = new  ArrayList();
            String dql = "select id, descripcion, tipo, idusuario from frase where idusuario = "+usuario.getId();
            
            
            
        try {

            Statement sentencia = conexion.createStatement();
            ResultSet res = sentencia.executeQuery(dql);
            
            while (res.next()) {
                Frase c = new Frase();
                Usuario u = new Usuario();
                
                c.setId(res.getInt("id"));
                c.setDescripcion(res.getString("descripcion"));
                c.setTipo(res.getString("tipo"));
                
                u.setId(res.getInt("idusuario"));
                
                c.setUsuario(u);
                
                listaFrases.add(c);
            }
            
               
            res.close();
            sentencia.close();
            conexion.close();
            
        } catch (SQLException ex) {
            ExcepcionDG e = new ExcepcionDG();
            e.setCodigoError(ex.getErrorCode());
            e.setMensajeErrorAdministrador(ex.getMessage());
            e.setSentenciaSQL(dql);
            e.setMensajeErrorUsuario("Error general del sistema. Consulte con el administrador");
            throw e;
        }
        
        return listaFrases;
    }


}
