/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drinkgamecad;

/**
 *
 * @author Jonathan Gonzalez
 */
public class Usuario {
    
    Integer id;
    String nombre;
    String correo;
    Integer cervezas;
    String ads;
    Integer avatar;

    /**
     * Constructor vacio de la clase
     */
    public Usuario() {
    }

    /**
     * Constructor completo parametrizado
     * @param id Almacena el identificador del Usuario
     * @param nombre Almacena el nombre del Usuario
     * @param correo Almacena el correo del Usuario
     * @param cervezas Almacena los puntos (Cervezas) que tiene el Usuario
     * @param ads Almacena el tipo de producto que tiene el Usuario
     * @param avatar Almacena el numero del avatar que tiene el Usuario
     */
    public Usuario(Integer id, String nombre, String correo, Integer cervezas, String ads, Integer avatar) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.cervezas = cervezas;
        this.ads = ads;
        this.avatar = avatar;
    }

    /**
     * Este método permite retornar el identificador del Usuario
     * @return retorna el id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Este método permite cambiar el identificador del Usuario almacenado
     * @param id indica el identificador que sera el remplazado
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Este método permite retornar el nombre del Usuario almacenado
     * @return retorna el nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Este método permite cambiar el nombre del Usuario almacenado
     * @param nombre indica el nombre que sera el remplazado
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Este método permite retornar el correo del usuario almacenado
     * @return retorna el correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Este método permite modificar el correo del usurio almacenado
     * @param correo indica el email que sera el remplazado
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Este método permite retornar el numero de cervezas del usuario almacenado
     * @return retorna las cervezas
     */
    public Integer getCervezas() {
        return cervezas;
    }

    public void setCervezas(Integer cervezas) {
        this.cervezas = cervezas;
    }

    /**
     * Este método permite retornar el contenido de Ads del usuario almacenado
     * @return retorna un string
     */
    public String getAds() {
        return ads;
    }

    
    public void setAds(String ads) {
        this.ads = ads;
    }

    /**
     * Este método permite retornar el numero de avatar del usuario almacenado
     * @return retorna el avatar en numero
     */
    public Integer getAvatar() {
        return avatar;
    }

    public void setAvatar(Integer avatar) {
        this.avatar = avatar;
    }

    
    /**
     * Este método permite mostrar todos los atributos de la clase Usuario en versión cadena de texto.
     * @return retorna los atributos de la clase
     */
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", cervezas=" + cervezas + ", ads=" + ads + ", avatar=" + avatar + '}';
    }
}
