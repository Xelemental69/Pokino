/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartas;

/**
 *
 * @author pikac
 */
import java.util.*;
public abstract class CartaEsp {
    
    protected int numero;

    public CartaEsp(int numero) {
        
        this.numero = numero;
        
    }
    
    public CartaEsp(){
        Random sacar = new Random();        
        
        numero = sacar.nextInt(12) + 1;
        
    }
    
    public abstract void mostrarCarta();
    
}
