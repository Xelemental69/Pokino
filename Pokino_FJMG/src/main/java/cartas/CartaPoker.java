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
public abstract class CartaPoker {
    
    protected int numero;
    protected boolean tachado;
    protected String id;

    public CartaPoker(int numero) {
        
        this.numero = numero;
        tachado = false;
        id = "";
        
    }
    
    public CartaPoker(){
        Random sacar = new Random();        
        
        numero = sacar.nextInt(13) + 1;
        tachado = false;
        id = "";
        
    }
    
    public abstract void mostrarCarta();

    public boolean isTachado() {
        return tachado;
    }

    public void setTachado(boolean tachado) {
        this.tachado = tachado;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CartaPoker{" + "numero=" + numero + ", tachado=" + tachado + ", id=" + id + '}';
    }
    
}
