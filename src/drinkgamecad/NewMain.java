/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drinkgamecad;

import herramientas.Frase;
import herramientas.Usuario;

/**
 *
 * @author jony8
 */
public class NewMain {
    
    public static void main(String[] args){
        
        DrinkgamesAD dgAd = null;
            
            try {
                dgAd = new DrinkgamesAD();
            } catch (ExcepcionDG ex) {
                System.out.println(ex.getMensajeErrorAdministrador());
            }
        Usuario usuario = new Usuario(0,"prueba3","prueba8gf@yopmail.com",10,"S",1,null) ;
        System.out.println(usuario.toString());
        Usuario aux = new Usuario();
        Frase ff = new Frase(1, "Hola Bro", "YN", usuario);
        Frase ff2 = new Frase(1, "Adios Bro", "YN", usuario);
        int reg = 0;
        Integer id = 0;
        
        try {
            System.out.println("Conectado");
            //reg = dgAd.insertarUsuario(usuario);
            //reg = dgAd.modificarUsuario(usuario, 22);
            //reg = dgAd.eliminarUsuario(usuario.getCorreo());
            //System.out.println(reg);
            aux = dgAd.selectId(usuario.getCorreo());
            System.out.println("El id es:"+aux.getId());
            System.out.println(aux.toString());
            aux.anadirFrase(ff);
            aux.anadirFrase(ff2);
            aux.mostrarFrases();
            //System.out.println("\n Usuario insertado correctamente.");
            //System.out.println("\n Usuario modificado correctamente.");

        } catch (ExcepcionDG ex) {
            System.out.println(ex.getMensajeErrorUsuario());
            System.out.println(ex.getMensajeErrorAdministrador());
            System.out.println(ex.getCodigoError());
        }
        catch (NullPointerException ne) {
            System.out.println(ne.getMessage());
            System.out.println(ne.getCause());
        } 
    }
    
}
