/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_game;

import baraja_carton.*;
import cartas.*;
import java.util.*;

/**
 *
 * @author pikac
 */
public class JuegoEsp {

    public static void main(String[] args) {

        ArrayList<Carton> cartones = new ArrayList<>();
        BarajaEsp baraja = new BarajaEsp();
        Random rng = new Random();
        CartaEsp auxiliar;
        int elegirFila;
        int elegirCarta;
        boolean esquina = false;
        boolean estampa = false;
        boolean poker = false;
        boolean centro = false;
        boolean full = false;
        boolean victoria = false;

        for (int i = 0; i < 12; i++) {

            cartones.add(new Carton(i + 1));

        }
        
        for(int j = 0; j < 12; j++){
                
                System.out.println("Cartón " + cartones.get(j).getId() + ":");
                cartones.get(j).MostrarCartonEsp();

            }
        
        do{
            
            do{
                
                elegirFila = rng.nextInt(12);
                
            }while(baraja.getBaraja().get(elegirFila).isEmpty());
            
            elegirCarta = rng.nextInt(baraja.getBaraja().get(elegirFila).size());
            
            System.out.printf("Ha salido...");            
            auxiliar = baraja.getBaraja().get(elegirFila).get(elegirCarta);
            auxiliar.mostrarCarta();
            baraja.getBaraja().get(elegirFila).remove(elegirCarta);
            System.out.println("");
            
            for(int x = 0; x < 12; x++){
                
                for(int fila = 0; fila < 5; fila++){
                    
                    for(int posicion = 0; posicion < 5; posicion++){
                        
                        if(cartones.get(x).getCartonEsp()[fila][posicion].getId().equals(auxiliar.getId())){
                                       
                            //System.out.println("TACHADO");
                            cartones.get(x).getCartonEsp()[fila][posicion].setTachado(true);
                            break;
                            
                        }
                        
                    }
                    
                }

            }
            
            if(!centro){
                
                centro = centroCheck(cartones);
                
            }
            
            if(!esquina){
                
                esquina = esquinaCheck(cartones);
                
            }
            
            if(!estampa){
                
                estampa = estampaCheck(cartones);
                
            }
            
            if(!full){
                
                full = fullCheck(cartones);
                
            }
            
            if(!poker){
                
                poker = pokerCheck(cartones);
                
            }
            
            victoria = winCheck(cartones);
            
        }while(!victoria);

    }

    public static boolean estampaCheck(ArrayList<Carton> cartones) {
        
        //Método para comprobar estampas

        for (int i = 0; i < 12; i++) {//Comprobamos en los cartones cual posee cuatro cartas tachadas en una esquina

            if ((cartones.get(i).getCartonEsp()[0][0].isTachado()
                    && cartones.get(i).getCartonEsp()[0][1].isTachado()
                    && cartones.get(i).getCartonEsp()[1][0].isTachado()
                    && cartones.get(i).getCartonEsp()[1][1].isTachado())
                    || (cartones.get(i).getCartonEsp()[0][4].isTachado()
                    && cartones.get(i).getCartonEsp()[1][4].isTachado()
                    && cartones.get(i).getCartonEsp()[0][3].isTachado()
                    && cartones.get(i).getCartonEsp()[1][3].isTachado())
                    || (cartones.get(i).getCartonEsp()[4][0].isTachado()
                    && cartones.get(i).getCartonEsp()[3][1].isTachado()
                    && cartones.get(i).getCartonEsp()[3][0].isTachado()
                    && cartones.get(i).getCartonEsp()[4][1].isTachado())
                    || (cartones.get(i).getCartonEsp()[4][4].isTachado()
                    && cartones.get(i).getCartonEsp()[3][4].isTachado()
                    && cartones.get(i).getCartonEsp()[3][3].isTachado()
                    && cartones.get(i).getCartonEsp()[4][3].isTachado())) {

                //Quien lo tenga será indicado por pantalla
                System.out.println("El jugador con el cartón "
                        + cartones.get(i).getId() + " ha ganado el premio de Estampa");
                
                return true;
                
            }

        }

        return false;

    }

    public static boolean esquinaCheck(ArrayList<Carton> cartones) {
        
        //System.out.println("Comprobando esquinas...");

        for (int i = 0; i < 12; i++) {
            
            //Comprobamos en los cartones cual posee cuatro esquinas tachadas

            if (cartones.get(i).getCartonEsp()[0][0].isTachado()
                    && cartones.get(i).getCartonEsp()[4][0].isTachado()
                    && cartones.get(i).getCartonEsp()[0][4].isTachado()
                    && cartones.get(i).getCartonEsp()[4][4].isTachado()) {

                //Quien lo tenga será indicado por pantalla
                System.out.println("El jugador con el cartón "
                        + cartones.get(i).getId() + " ha ganado el premio de Esquina");
                
                return true;

            }

        }

        return false;

    }

    public static boolean pokerCheck(ArrayList<Carton> cartones) {
        
        //System.out.println("Comprobando pokers...");

        for (int i = 0; i < 12; i++) {

            if (cartones.get(i).getCartonEsp()[0][0].isTachado()
                    && cartones.get(i).getCartonEsp()[0][1].isTachado()
                    && cartones.get(i).getCartonEsp()[0][2].isTachado()
                    && cartones.get(i).getCartonEsp()[0][3].isTachado()) {

                //Quien lo tenga será indicado por pantalla
                System.out.println("El jugador con el cartón "
                        + cartones.get(i).getId() + " ha ganado el premio de Poker");
                
                return true;

            }

        }

        return false;

    }

    public static boolean fullCheck(ArrayList<Carton> cartones) {
        
        //System.out.println("Comprobando fulls...");

        for (int i = 0; i < 12; i++) {

            //Comprobamos si un cartón tiene la 2a fila tachada
            if (cartones.get(i).getCartonEsp()[1][0].isTachado()
                    && cartones.get(i).getCartonEsp()[1][1].isTachado()
                    && cartones.get(i).getCartonEsp()[1][2].isTachado()
                    && cartones.get(i).getCartonEsp()[1][3].isTachado()
                    && cartones.get(i).getCartonEsp()[1][4].isTachado()) {

                //Quien lo tenga será indicado por pantalla
                System.out.println("El jugador con el cartón "
                        + cartones.get(i).getId() + " ha ganado el premio de Full");
                
                return true;

            }

        }

        return false;

    }

    public static boolean centroCheck(ArrayList<Carton> cartones) {
        
        //System.out.println("Comprobando centros...");

        for (int i = 0; i < 12; i++) {

            if (cartones.get(i).getCartonEsp()[2][2].isTachado()) {

                //Quien lo tenga será indicado por pantalla
                System.out.println("El jugador con el cartón "
                        + cartones.get(i).getId() + " ha ganado el premio de Centro");
                
                return true;

            }

        }

        return false;

    }

    public static boolean winCheck(ArrayList<Carton> cartones) {
        
        //System.out.println("Comprobando cartones...");

        int contador;

        for (int i = 0; i < 12; i++) {

            for (int n = 0; n < 5; n++) {
                
                contador = 0;

                if (n != 2) {

                    for (int m = 0; m < 5; m++) {

                        if (cartones.get(i).getCartonEsp()[n][m].isTachado()) {

                            contador++;
                            //System.out.println("Contador: " + contador);

                        }

                    }

                    if (contador == 5) {

                        System.out.println("POKINO!!!\nEl jugador con el cartón "
                                + cartones.get(i).getId() + " es el ganador del Pokino");

                        return true;

                    }

                }

            }
            
            for (int n = 0; n < 5; n++) {
                
                contador = 0;

                    for (int m = 0; m < 5; m++) {

                        if (cartones.get(i).getCartonEsp()[m][n].isTachado()) {

                            contador++;
                            //System.out.println("Contador: " + contador);

                        }

                    if (contador == 5) {

                        System.out.println("POKINO!!!\nEl jugador con el cartón "
                                + cartones.get(i).getId() + " es el ganador del Pokino");

                        return true;

                    }

                }

            }

            if ((cartones.get(i).getCartonEsp()[0][0].isTachado()
                    && cartones.get(i).getCartonEsp()[1][1].isTachado()
                    && cartones.get(i).getCartonEsp()[2][2].isTachado()
                    && cartones.get(i).getCartonEsp()[3][3].isTachado()
                    && cartones.get(i).getCartonEsp()[4][4].isTachado())
                    || (cartones.get(i).getCartonEsp()[4][0].isTachado()
                    && cartones.get(i).getCartonEsp()[3][1].isTachado()
                    && cartones.get(i).getCartonEsp()[2][2].isTachado()
                    && cartones.get(i).getCartonEsp()[1][3].isTachado()
                    && cartones.get(i).getCartonEsp()[0][4].isTachado())) {

                System.out.println("POKINO!!!\nEl jugador con el cartón "
                        + cartones.get(i).getId() + " es el ganador del Pokino");

                return true;

            }

        }

        return false;

    }

}
