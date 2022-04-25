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
    
    ArrayList <CartaPoker>[] baraja;
    
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

    public BarajaPoker() {
        
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
        baraja[12] = new ArrayList<>();
        
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
        
        baraja[0].add(new Diamante(1));
        baraja[0].add(new Trebol(1));
        baraja[0].add(new Corazon(1));
        baraja[0].add(new Picas(1));
        
        baraja[2].add(new Diamante(2));
        baraja[2].add(new Trebol(2));
        baraja[2].add(new Corazon(2));
        baraja[2].add(new Picas(2));
        
        baraja[3].add(new Diamante(3));
        baraja[3].add(new Trebol(3));
        baraja[3].add(new Corazon(3));
        baraja[3].add(new Picas(3));
        
        baraja[4].add(new Diamante(4));
        baraja[4].add(new Trebol(4));
        baraja[4].add(new Corazon(4));
        baraja[4].add(new Picas(4));
        
        baraja[5].add(new Diamante(5));
        baraja[5].add(new Trebol(5));
        baraja[5].add(new Corazon(5));
        baraja[5].add(new Picas(5));
        
        baraja[6].add(new Diamante(6));
        baraja[6].add(new Trebol(6));
        baraja[6].add(new Corazon(6));
        baraja[6].add(new Picas(6));
        
        baraja[7].add(new Diamante(7));
        baraja[7].add(new Trebol(7));
        baraja[7].add(new Corazon(7));
        baraja[7].add(new Picas(7));
        
        baraja[8].add(new Diamante(8));
        baraja[8].add(new Trebol(8));
        baraja[8].add(new Corazon(8));
        baraja[8].add(new Picas(8));
        
        baraja[9].add(new Diamante(9));
        baraja[9].add(new Trebol(9));
        baraja[9].add(new Corazon(9));
        baraja[9].add(new Picas(9));
        
        baraja[10].add(new Diamante(10));
        baraja[10].add(new Trebol(10));
        baraja[10].add(new Corazon(10));
        baraja[10].add(new Picas(10));
        
        baraja[11].add(new Diamante(11));
        baraja[11].add(new Trebol(11));
        baraja[11].add(new Corazon(11));
        baraja[11].add(new Picas(11));
        
        baraja[12].add(new Diamante(12));
        baraja[12].add(new Trebol(12));
        baraja[12].add(new Corazon(12));
        baraja[12].add(new Picas(12));
        
        baraja[13].add(new Diamante(13));
        baraja[13].add(new Trebol(13));
        baraja[13].add(new Corazon(13));
        baraja[13].add(new Picas(13));
        
        
        
    }

    public ArrayList<CartaPoker>[] getBaraja() {
        return baraja;
    }

    public void setBaraja(ArrayList<CartaPoker>[] baraja) {
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
