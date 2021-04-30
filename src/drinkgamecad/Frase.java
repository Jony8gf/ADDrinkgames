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
public class Frase {
    
    Integer id;
    String descripcion;
    String tipo;
    Usuario usuario;
    
    /**
     * Constructor vacio de la clase
     */
    public Frase() {
    }

    
    /**
     * Constructor completo parametrizado
     * @param id Almacena el identificador de la Frase
     * @param descripcion Almacena la descripcion del Frase
     * @param tipo Almacena el tipo de Frase
     * @param usuario  Almacena el Objeto de la clase Usuario
     */
    public Frase(Integer id, String descripcion, String tipo, Usuario usuario) {
        this.id = id;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Este método permite mostrar todos los atributos de la clase Frase en versión cadena de texto.
     * @return retorna los atributos de la clase
     */
    @Override
    public String toString() {
        return "Frase{" + "id=" + id + ", descripcion=" + descripcion + ", tipo=" + tipo + ", usuario=" + usuario + '}';
    } 
    
}
