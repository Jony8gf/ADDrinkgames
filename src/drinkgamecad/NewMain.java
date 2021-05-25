/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drinkgamecad;

import herramientas.Frase;
import herramientas.Usuario;
import java.util.ArrayList;

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
        Usuario usuario = new Usuario(101,"Saray","Sara@yopmail.com",100,"S",3,3) ;
        System.out.println(usuario.toString());
        Usuario aux = new Usuario();
        Frase frase = new Frase(6, "Frase TT Valencia", "YN", usuario);
        Frase fraseNeW = new Frase();
        
        ArrayList<Frase> frases = new ArrayList<>();
        int reg = 0;
        Integer id = 0;
        
        try {
            System.out.println("Conectado");
            //reg = dgAd.insertarUsuario(usuario);
            //reg = dgAd.modificarUsuario(usuario, 22);
            //reg = dgAd.eliminarUsuario(usuario.getCorreo());
            //System.out.println(reg);
            aux = dgAd.selectId(usuario.getCorreo());
            System.out.println(aux.toString());
            System.out.println("El id es:"+aux.getId());
            
            //reg = dgAd.eliminarFrasesDeUnUsuario(aux);
            frases = dgAd.mostrarFrases(aux);
            fraseNeW.setUsuario(aux);
            
            for(int i = 1; i<aux.frases.size(); i++){

                          frases.set(i, fraseNeW);                       
                    }
            
            aux.setFrases(frases);
            aux.mostrarFrases();
            
                    for(int i = 1; i<aux.frases.size(); i++){

                            reg = dgAd.modificarFrasesUsuario(aux, i);
                            System.out.println("Registro Modificado");                        
                    }
            
            
            
            
            
            
            /*
            frase.setDescripcion("Frase 3");
            frase.setTipo("YN");
            for(int i = 1; i<41; i++){
                
                frase.setDescripcion("Frase "+i);
                
                if(i<=20){
                    frase.setTipo("MP");
                    reg = dgAd.insertarFrasesUsuario(aux, frase);
                }else{
                    reg = dgAd.insertarFrasesUsuario(aux, frase);
                    System.out.println("Registro Introducido");
                }
            }
            */
            
            /*
            aux.anadirFrase(ff);
            aux.anadirFrase(ff2);
            aux.mostrarFrases();
            */
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
