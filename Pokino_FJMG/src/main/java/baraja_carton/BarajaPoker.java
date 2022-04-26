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

public class BarajaPoker {
    
    ArrayList <ArrayList <CartaPoker>> baraja;
    
    /*
    ArrayList <CartaPoker> as;
    ArrayList <CartaPoker> dos;
    ArrayList <CartaPoker> tres;
    ArrayList <CartaPoker> cuatro;
    ArrayList <CartaPoker> cinco;
    ArrayList <CartaPoker> seis;
    ArrayList <CartaPoker> siete;
    ArrayList <CartaPoker> ocho;
    ArrayList <CartaPoker> nueve;
    ArrayList <CartaPoker> diez;
    ArrayList <CartaPoker> j;
    ArrayList <CartaPoker> q;
    ArrayList <CartaPoker> k;
    */

    public BarajaPoker() {
        
        baraja = new ArrayList <>();
        
        //Generamos los ArrayLists, cada uno representando un nº del 1 al 12:
        
        for (int i = 0; i < 13; i++){
            
            baraja.add(new ArrayList<>());
        
        }
        
        /*
        this.as = new ArrayList<>();        
        this.dos = new ArrayList<>();
        this.tres = new ArrayList<>();
        this.cuatro = new ArrayList<>();
        this.cinco = new ArrayList<>();
        this.seis = new ArrayList<>();
        this.siete = new ArrayList<>();
        this.ocho = new ArrayList<>();
        this.nueve = new ArrayList<>();
        this.diez = new ArrayList<>();
        this.j = new ArrayList<>();
        this.q = new ArrayList<>();
        this.k = new ArrayList<>();
        */
        
        baraja.get(0).add(new Diamante(1));
        baraja.get(0).add(new Trebol(1));
        baraja.get(0).add(new Corazon(1));
        baraja.get(0).add(new Picas(1));
        
        baraja.get(1).add(new Diamante(2));
        baraja.get(1).add(new Trebol(2));
        baraja.get(1).add(new Corazon(2));
        baraja.get(1).add(new Picas(2));
        
        baraja.get(2).add(new Diamante(3));
        baraja.get(2).add(new Trebol(3));
        baraja.get(2).add(new Corazon(3));
        baraja.get(2).add(new Picas(3));
        
        baraja.get(3).add(new Diamante(4));
        baraja.get(3).add(new Trebol(4));
        baraja.get(3).add(new Corazon(4));
        baraja.get(3).add(new Picas(4));
        
        baraja.get(4).add(new Diamante(5));
        baraja.get(4).add(new Trebol(5));
        baraja.get(4).add(new Corazon(5));
        baraja.get(4).add(new Picas(5));
        
        baraja.get(5).add(new Diamante(6));
        baraja.get(5).add(new Trebol(6));
        baraja.get(5).add(new Corazon(6));
        baraja.get(5).add(new Picas(6));
        
        baraja.get(6).add(new Diamante(7));
        baraja.get(6).add(new Trebol(7));
        baraja.get(6).add(new Corazon(7));
        baraja.get(6).add(new Picas(7));
        
        baraja.get(7).add(new Diamante(8));
        baraja.get(7).add(new Trebol(8));
        baraja.get(7).add(new Corazon(8));
        baraja.get(7).add(new Picas(8));
        
        baraja.get(8).add(new Diamante(9));
        baraja.get(8).add(new Trebol(9));
        baraja.get(8).add(new Corazon(9));
        baraja.get(8).add(new Picas(9));
        
        baraja.get(9).add(new Diamante(10));
        baraja.get(9).add(new Trebol(10));
        baraja.get(9).add(new Corazon(10));
        baraja.get(9).add(new Picas(10));
        
        baraja.get(10).add(new Diamante(11));
        baraja.get(10).add(new Trebol(11));
        baraja.get(10).add(new Corazon(11));
        baraja.get(10).add(new Picas(11));
        
        baraja.get(11).add(new Diamante(12));
        baraja.get(11).add(new Trebol(12));
        baraja.get(11).add(new Corazon(12));
        baraja.get(11).add(new Picas(12));
        
        baraja.get(12).add(new Diamante(13));
        baraja.get(12).add(new Trebol(13));
        baraja.get(12).add(new Corazon(13));
        baraja.get(12).add(new Picas(13));
        
        
        
    }

    public ArrayList<ArrayList<CartaPoker>> getBaraja() {
        return baraja;
    }

    public void setBaraja(ArrayList<ArrayList<CartaPoker>> baraja) {
        this.baraja = baraja;
    }
    
    /*
    public ArrayList<CartaPoker> getAs() {
        return as;
    }

    public void setAs(ArrayList<CartaPoker> as) {
        this.as = as;
    }

    public ArrayList<CartaPoker> getDos() {
        return dos;
    }

    public void setDos(ArrayList<CartaPoker> dos) {
        this.dos = dos;
    }

    public ArrayList<CartaPoker> getTres() {
        return tres;
    }

    public void setTres(ArrayList<CartaPoker> tres) {
        this.tres = tres;
    }

    public ArrayList<CartaPoker> getCuatro() {
        return cuatro;
    }

    public void setCuatro(ArrayList<CartaPoker> cuatro) {
        this.cuatro = cuatro;
    }

    public ArrayList<CartaPoker> getCinco() {
        return cinco;
    }

    public void setCinco(ArrayList<CartaPoker> cinco) {
        this.cinco = cinco;
    }

    public ArrayList<CartaPoker> getSeis() {
        return seis;
    }

    public void setSeis(ArrayList<CartaPoker> seis) {
        this.seis = seis;
    }

    public ArrayList<CartaPoker> getSiete() {
        return siete;
    }

    public void setSiete(ArrayList<CartaPoker> siete) {
        this.siete = siete;
    }

    public ArrayList<CartaPoker> getOcho() {
        return ocho;
    }

    public void setOcho(ArrayList<CartaPoker> ocho) {
        this.ocho = ocho;
    }

    public ArrayList<CartaPoker> getNueve() {
        return nueve;
    }

    public void setNueve(ArrayList<CartaPoker> nueve) {
        this.nueve = nueve;
    }

    public ArrayList<CartaPoker> getDiez() {
        return diez;
    }

    public void setDiez(ArrayList<CartaPoker> diez) {
        this.diez = diez;
    }

    public ArrayList<CartaPoker> getJ() {
        return j;
    }

    public void setJ(ArrayList<CartaPoker> j) {
        this.j = j;
    }

    public ArrayList<CartaPoker> getQ() {
        return q;
    }

    public void setQ(ArrayList<CartaPoker> q) {
        this.q = q;
    }

    public ArrayList<CartaPoker> getK() {
        return k;
    }

    public void setK(ArrayList<CartaPoker> k) {
        this.k = k;
    }*/
    

    
}
