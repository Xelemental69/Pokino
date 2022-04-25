/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baraja_carton;

/**
 *
 * @author pikac
 */
import java.util.*;
import cartas.*;

public class BarajaEsp {
    
    ArrayList <CartaEsp>[] baraja;//Un Array de ArrayLists para meter las cartas    
    
    /*
    ArrayList <CartaEsp> as;
    ArrayList <CartaEsp> dos;
    ArrayList <CartaEsp> tres;
    ArrayList <CartaEsp> cuatro;
    ArrayList <CartaEsp> cinco;
    ArrayList <CartaEsp> seis;
    ArrayList <CartaEsp> siete;
    ArrayList <CartaEsp> ocho;
    ArrayList <CartaEsp> nueve;
    ArrayList <CartaEsp> sota;
    ArrayList <CartaEsp> caballo;
    ArrayList <CartaEsp> rey;
    */

    public BarajaEsp() {
        
        //Generamos los ArrayLists, cada uno representando un nº del 1 al 12:
        baraja[0] = new ArrayList<>();
        baraja[1] = new ArrayList<>();
        baraja[2] = new ArrayList<>();
        baraja[3] = new ArrayList<>();
        baraja[4] = new ArrayList<>();
        baraja[5] = new ArrayList<>();
        baraja[6] = new ArrayList<>();
        baraja[7] = new ArrayList<>();
        baraja[8] = new ArrayList<>();
        baraja[9] = new ArrayList<>();
        baraja[10] = new ArrayList<>();
        baraja[11] = new ArrayList<>();
        
        //Añadimos una carta de cada tipo con el nº correspondiente:
        
        baraja[0].add(new Basto(1));
        baraja[0].add(new Oro(1));
        baraja[0].add(new Espada(1));
        baraja[0].add(new Copa(1));
        
        baraja[1].add(new Basto(2));
        baraja[1].add(new Oro(2));
        baraja[1].add(new Espada(2));
        baraja[1].add(new Copa(2));
        
        baraja[2].add(new Basto(3));
        baraja[2].add(new Oro(3));
        baraja[2].add(new Espada(3));
        baraja[2].add(new Copa(3));
        
        baraja[3].add(new Basto(4));
        baraja[3].add(new Oro(4));
        baraja[3].add(new Espada(4));
        baraja[3].add(new Copa(4));
        
        baraja[4].add(new Basto(5));
        baraja[4].add(new Oro(5));
        baraja[4].add(new Espada(5));
        baraja[4].add(new Copa(5));
        
        baraja[5].add(new Basto(6));
        baraja[5].add(new Oro(6));
        baraja[5].add(new Espada(6));
        baraja[5].add(new Copa(6));
        
        baraja[6].add(new Basto(7));
        baraja[6].add(new Oro(7));
        baraja[6].add(new Espada(7));
        baraja[6].add(new Copa(7));
        
        baraja[7].add(new Basto(8));
        baraja[7].add(new Oro(8));
        baraja[7].add(new Espada(8));
        baraja[7].add(new Copa(8));
        
        baraja[8].add(new Basto(9));
        baraja[8].add(new Oro(9));
        baraja[8].add(new Espada(9));
        baraja[8].add(new Copa(9));
        
        baraja[9].add(new Basto(10));
        baraja[9].add(new Oro(10));
        baraja[9].add(new Espada(10));
        baraja[9].add(new Copa(10));
        
        baraja[10].add(new Basto(11));
        baraja[10].add(new Oro(11));
        baraja[10].add(new Espada(11));
        baraja[10].add(new Copa(11));
        
        baraja[11].add(new Basto(12));
        baraja[11].add(new Oro(12));
        baraja[11].add(new Espada(12));
        baraja[11].add(new Copa(12));
        
    }

    public ArrayList<CartaEsp>[] getBaraja() {
        return baraja;
    }

    public void setBaraja(ArrayList<CartaEsp>[] baraja) {
        this.baraja = baraja;
    }
    
    /*public ArrayList<CartaEsp> getAs() {
        return as;
    }

    public void setAs(ArrayList<CartaEsp> as) {
        this.as = as;
    }

    public ArrayList<CartaEsp> getDos() {
        return dos;
    }

    public void setDos(ArrayList<CartaEsp> dos) {
        this.dos = dos;
    }

    public ArrayList<CartaEsp> getTres() {
        return tres;
    }

    public void setTres(ArrayList<CartaEsp> tres) {
        this.tres = tres;
    }

    public ArrayList<CartaEsp> getCuatro() {
        return cuatro;
    }

    public void setCuatro(ArrayList<CartaEsp> cuatro) {
        this.cuatro = cuatro;
    }

    public ArrayList<CartaEsp> getCinco() {
        return cinco;
    }

    public void setCinco(ArrayList<CartaEsp> cinco) {
        this.cinco = cinco;
    }

    public ArrayList<CartaEsp> getSeis() {
        return seis;
    }

    public void setSeis(ArrayList<CartaEsp> seis) {
        this.seis = seis;
    }

    public ArrayList<CartaEsp> getSiete() {
        return siete;
    }

    public void setSiete(ArrayList<CartaEsp> siete) {
        this.siete = siete;
    }

    public ArrayList<CartaEsp> getOcho() {
        return ocho;
    }

    public void setOcho(ArrayList<CartaEsp> ocho) {
        this.ocho = ocho;
    }

    public ArrayList<CartaEsp> getNueve() {
        return nueve;
    }

    public void setNueve(ArrayList<CartaEsp> nueve) {
        this.nueve = nueve;
    }

    public ArrayList<CartaEsp> getSota() {
        return sota;
    }

    public void setSota(ArrayList<CartaEsp> sota) {
        this.sota = sota;
    }

    public ArrayList<CartaEsp> getCaballo() {
        return caballo;
    }

    public void setCaballo(ArrayList<CartaEsp> caballo) {
        this.caballo = caballo;
    }

    public ArrayList<CartaEsp> getRey() {
        return rey;
    }

    public void setRey(ArrayList<CartaEsp> rey) {
        this.rey = rey;
    }*/
    

    
}
