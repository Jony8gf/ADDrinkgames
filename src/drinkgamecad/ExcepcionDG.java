/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drinkgamecad;

/**
 *
 * @author Jonathan Gonzalez Fraga
 */
public class ExcepcionDG {
    
    String mensajeErrorUsuario;
    String mensajeErrorAdministrador;
    Integer codigoError;
    String sentenciaSQL;

    /**
    * Constructor vacio de la clase
    * 
    */
    public ExcepcionDG() {
    }
    
    /**
     * Este es el constructor completo parametrizado de la clase
     * @param mensajeErrorUsuario Almaacena un mensaje de error al usuario
     * @param mensajeErrorAdministrador Almaacena un mensaje de error al administrador del sistema
     * @param codigoError Almaacena el código de error probocado
     * @param sentenciaSQL Almaacena la sentencia SQL que se utilizo
     */
    public ExcepcionDG(String mensajeErrorUsuario, String mensajeErrorAdministrador, Integer codigoError, String sentenciaSQL) {
        this.mensajeErrorUsuario = mensajeErrorUsuario;
        this.mensajeErrorAdministrador = mensajeErrorAdministrador;
        this.codigoError = codigoError;
        this.sentenciaSQL = sentenciaSQL;
    }
    
    /**
     * Este método permite retornar el valor del atributo mensaje de error del usuario
     * @return retorna mensajeErrorUsuario
     */
    public String getMensajeErrorUsuario() {
        return mensajeErrorUsuario;
    }

    /**
     * Este método permite cambiar el mensaje de error al usuario
     * @param mensajeErrorUsuario Almacena el mensaje de error al usuario
     */
    public void setMensajeErrorUsuario(String mensajeErrorUsuario) {
        this.mensajeErrorUsuario = mensajeErrorUsuario;
    }

    /**
     * Este método permite retornar el valor del atributo mensaje de error al administrador
     * @return retorna mensajeErrorAdminstrador
     */
    public String getMensajeErrorAdministrador() {
        return mensajeErrorAdministrador;
    }
    
    /**
     * Este método permite cambiar el mensaje de error al administrador
     * @param mensajeErrorAdministrador Almacena el mensaje de error para el administrador
     */
    public void setMensajeErrorAdministrador(String mensajeErrorAdministrador) {
        this.mensajeErrorAdministrador = mensajeErrorAdministrador;
    }
    
    
    /**
     * Este método permite retornar el valor numerico del codigo de error de Oracle
     * @return retorna el codigo numerico
     */
    public Integer getCodigoError() {
        return codigoError;
    }

    /**
     * Este método permite cambiar el codigo de error
     * @param codigoError modifica el codigo de error por el indicado
     */
    public void setCodigoError(Integer codigoError) {
        this.codigoError = codigoError;
    }

    /**
     * Este método permite retornar la sentencia SQL almacenada
     * @return retorna la sentencia SQL en una cadena de texto
     */
    public String getSentenciaSQL() {
        return sentenciaSQL;
    }

    /**
     * Este método permite cambiar la sentencia SQL almacenada
     * @param sentenciaSQL modifica la setencia SQL indicada por una cadena de carateres
     */
    public void setSentenciaSQL(String sentenciaSQL) {
        this.sentenciaSQL = sentenciaSQL;
    }

    
    /**
     * Este método permite mostrar todos los atributos de la clase en versión cadena de texto.
     * @return retorna los atributos de la clase
     */
    @Override
    public String toString() {
        return "ExcepcionGYM{" + "mensajeErrorUsuario=" + mensajeErrorUsuario + ", mensajeErrorAdministrador=" + mensajeErrorAdministrador + ", codigoError=" + codigoError + ", sentenciaSQL=" + sentenciaSQL + '}';
    }
}
