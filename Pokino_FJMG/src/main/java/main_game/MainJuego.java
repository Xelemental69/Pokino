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
public class MainJuego {
    
    public static void main(String[] args) {
        
        int choice;    
        Scanner entry = new Scanner(System.in);
        boolean permitemeQueInsista = false;
        
        do{
            
            try{
        
        System.out.println("¿Qué tipo de cartas prefiere?");
        System.out.println("1: Cartas Españolas");
        System.out.println("2: Cartas Inglesas");
        System.out.println("Otro: Salir...");
        
        choice = entry.nextInt();
        
                switch (choice) {
                    
                    case 1:                        
                        juegoEsp();                        
                        break;
                        
                    case 2:
                        juegoEng();
                        break;
                        
                    default:
                        System.out.println("Saliendo del programa...");
                        break;
                }
        
        }catch(InputMismatchException ime){
            
            System.out.println("ERROR. Introduce un nº");
            permitemeQueInsista = true;
            System.out.println("PERMÍTEME QUE INSISTA");
            
        }
            
        }while(permitemeQueInsista);
        
    }

    public static void juegoEsp() {

        ArrayList<Carton> cartones = new ArrayList<>();
        BarajaEsp baraja = new BarajaEsp();
        Random rng = new Random();
        CartaEsp auxiliar;
        int elegirFila;
        int elegirCarta;
        //Estos int guardarán los id de los cartones ganadores del premio correspondiente:
        int esquinaC = -1, estampaC = -1, pokerC = -1, centroC = -1, fullC = -1,
                ganador = -1;
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
        
        do{//Iniciamos el bucle del juego hasta que a alguien le toque Pokino
                                  
            //Sacamos la carta:
            do{//Comprobamos que no sacamos de una fila vacía
                
                elegirFila = rng.nextInt(12);
                
            }while(baraja.getBaraja().get(elegirFila).isEmpty());
            
            //Escogemos al azar una carta de la fila:
            elegirCarta = rng.nextInt(baraja.getBaraja().get(elegirFila).size());
            
            //La mostramos y la quitamos de la baraja:
            System.out.printf("Ha salido...");            
            auxiliar = baraja.getBaraja().get(elegirFila).get(elegirCarta);
            auxiliar.mostrarCarta();
            baraja.getBaraja().get(elegirFila).remove(elegirCarta);
            System.out.println("");
            
            for(int x = 0; x < 12; x++){//Comprobamos en los cartones si está
                //la carta:
                
                for(int fila = 0; fila < 5; fila++){
                    
                    for(int posicion = 0; posicion < 5; posicion++){
                        
                        if(cartones.get(x).getCartonEsp()[fila][posicion].getId().equals(auxiliar.getId())){
                                       
                            //Si está, la tachamos:
                            cartones.get(x).getCartonEsp()[fila][posicion].setTachado(true);
                            break;
                            
                        }
                        
                    }
                    
                }

            }
            
            for(int j = 0; j < 12; j++){//Mostramos los cartones:
                
                System.out.println("Cartón " + cartones.get(j).getId() + ":");
                cartones.get(j).MostrarCartonEsp();

            }
            
            //Comprobamos los premios (solo se comprobará si no lo ha ganado nadie,
            //guardándose el ganador de los mismos y mostrándolos en pantalla)
            
            if(centroCheckEsp(cartones) > 0 && !centro){
                
                centro = true;
                centroC = centroCheckEsp(cartones);
                System.out.println("El jugador con el cartón "
                        + centroC + " ha ganado el premio de Centro");
                
            }
            
            if(esquinaCheckEsp(cartones) > 0 && !esquina){
                
                esquina = true;
                esquinaC = esquinaCheckEsp(cartones);
                System.out.println("El jugador con el cartón "
                        + esquinaC + " ha ganado el premio de Esquina");
                
            }
            
            if(estampaCheckEsp(cartones) > 0 && !estampa){
                
                estampa = true;
                estampaC = estampaCheckEsp(cartones);
                System.out.println("El jugador con el cartón "
                        + estampaC + " ha ganado el premio de Estampa");
                
            }
            
            if(fullCheckEsp(cartones) > 0 && !full){
                
                full = true;
                fullC = fullCheckEsp(cartones);System.out.println("El jugador con el cartón "
                        + fullC + " ha ganado el premio de Full");
                
            }
            
            if(pokerCheckEsp(cartones) > 0 && !poker){
                
                poker = true;
                pokerC = pokerCheckEsp(cartones);
                System.out.println("El jugador con el cartón "
                        + pokerC + " ha ganado el premio de Póker");
                
            }    
            
            if(winCheckEsp(cartones) > 0){//Comprobamos si a uno le ha salido Pokino:
                
                victoria = true;
                ganador = winCheckEsp(cartones);
                System.out.println("POKINO!!!\nEl jugador con el cartón "
                        + ganador + " es el ganador del Pokino");
                
            }                                                
            
        }while(!victoria);
        
        //Mostramos por pantalla a cada ganador de los premios:        
        System.out.println("Ganadores de los premios: ");
        //Si hay un ganador, se muestra su nº de cartón, si no,
        //se muestra que ninguno ha ganado:
        System.out.println("Centro: " + ((centro) ? "Cartón nº " + centroC : "Ningún Cartón"));        
        System.out.println("Esquina: " + ((esquina) ? "Cartón nº " + esquinaC : "Ningún Cartón"));        
        System.out.println("Estampa: " + ((estampa) ? "Cartón nº " + estampaC : "Ningún Cartón"));        
        System.out.println("Poker: " + ((poker)?"Cartón nº " + pokerC : "Ningún Cartón"));        
        System.out.println("Full: " + ((full) ? "Cartón nº " + fullC : "Ningún Cartón"));
        //Por último, mostramos el ganador del Pokino:
        System.out.println("Ganador del juego: Cartón nº " + ganador);

    }

    public static int estampaCheckEsp(ArrayList<Carton> cartones) {
        
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
                                
                return cartones.get(i).getId();
                
            }

        }

        return -1;

    }

    public static int esquinaCheckEsp(ArrayList<Carton> cartones) {
        
        //System.out.println("Comprobando esquinas...");

        for (int i = 0; i < 12; i++) {
            
            //Comprobamos en los cartones cual posee cuatro esquinas tachadas

            if (cartones.get(i).getCartonEsp()[0][0].isTachado()
                    && cartones.get(i).getCartonEsp()[4][0].isTachado()
                    && cartones.get(i).getCartonEsp()[0][4].isTachado()
                    && cartones.get(i).getCartonEsp()[4][4].isTachado()) {

                return cartones.get(i).getId();

            }

        }

        return -1;

    }

    public static int pokerCheckEsp(ArrayList<Carton> cartones) {
        
        //System.out.println("Comprobando pokers...");

        for (int i = 0; i < 12; i++) {

            if (cartones.get(i).getCartonEsp()[0][0].isTachado()
                    && cartones.get(i).getCartonEsp()[0][1].isTachado()
                    && cartones.get(i).getCartonEsp()[0][2].isTachado()
                    && cartones.get(i).getCartonEsp()[0][3].isTachado()) {

                return cartones.get(i).getId();

            }

        }

        return -1;

    }

    public static int fullCheckEsp(ArrayList<Carton> cartones) {
        
        //System.out.println("Comprobando fulls...");

        for (int i = 0; i < 12; i++) {

            //Comprobamos si un cartón tiene la 2a fila tachada
            if (cartones.get(i).getCartonEsp()[1][0].isTachado()
                    && cartones.get(i).getCartonEsp()[1][1].isTachado()
                    && cartones.get(i).getCartonEsp()[1][2].isTachado()
                    && cartones.get(i).getCartonEsp()[1][3].isTachado()
                    && cartones.get(i).getCartonEsp()[1][4].isTachado()) {

                return cartones.get(i).getId();

            }

        }

        return -1;

    }

    public static int centroCheckEsp(ArrayList<Carton> cartones) {
        
        //Método para comprobar quien tiene el premio del centro.

        for (int i = 0; i < 12; i++) {

            if (cartones.get(i).getCartonEsp()[2][2].isTachado()) {

                
                return cartones.get(i).getId();

            }

        }

        return -1;

    }

    public static int winCheckEsp(ArrayList<Carton> cartones) {
        
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

                        

                        return cartones.get(i).getId();

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

                        

                        return cartones.get(i).getId();

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

                return cartones.get(i).getId();

            }

        }

        return -1;

    }
    
    
    
    public static void juegoEng() {

        ArrayList<Carton> cartones = new ArrayList<>();
        BarajaPoker baraja = new BarajaPoker();
        Random rng = new Random();
        CartaPoker auxiliar;
        int elegirFila;
        int elegirCarta;
        //Estos int guardarán los id de los cartones ganadores del premio correspondiente:
        int esquinaC = -1, estampaC = -1, pokerC = -1, centroC = -1, fullC = -1,
                ganador = -1;
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
                cartones.get(j).MostrarCartonEng();

            }
        
        do{//Iniciamos el bucle del juego hasta que a alguien le toque Pokino
                                  
            //Sacamos la carta:
            do{//Comprobamos que no sacamos de una fila vacía
                
                elegirFila = rng.nextInt(13);
                
            }while(baraja.getBaraja().get(elegirFila).isEmpty());
            
            //Escogemos al azar una carta de la fila:
            elegirCarta = rng.nextInt(baraja.getBaraja().get(elegirFila).size());
            
            //La mostramos y la quitamos de la baraja:
            System.out.printf("Ha salido...");            
            auxiliar = baraja.getBaraja().get(elegirFila).get(elegirCarta);
            auxiliar.mostrarCarta();
            baraja.getBaraja().get(elegirFila).remove(elegirCarta);
            System.out.println("");
            
            for(int x = 0; x < 12; x++){//Comprobamos en los cartones si está
                //la carta:
                
                for(int fila = 0; fila < 5; fila++){
                    
                    for(int posicion = 0; posicion < 5; posicion++){
                        
                        if(cartones.get(x).getCartonEng()[fila][posicion].getId().equals(auxiliar.getId())){
                                       
                            //Si está, la tachamos:
                            cartones.get(x).getCartonEng()[fila][posicion].setTachado(true);
                            break;
                            
                        }
                        
                    }
                    
                }

            }
            
            for(int j = 0; j < 12; j++){//Mostramos los cartones:
                
                System.out.println("Cartón " + cartones.get(j).getId() + ":");
                cartones.get(j).MostrarCartonEng();

            }
            
            //Comprobamos los premios (solo se comprobará si no lo ha ganado nadie,
            //guardándose el ganador de los mismos)
            
            if(centroCheckEng(cartones) > 0 && !centro){
                
                centro = true;
                centroC = centroCheckEng(cartones);
                System.out.println("El jugador con el cartón "
                        + centroC + " ha ganado el premio de Centro");
                
            }
            
            if(esquinaCheckEng(cartones) > 0 && !esquina){
                
                esquina = true;
                esquinaC = esquinaCheckEng(cartones);
                System.out.println("El jugador con el cartón "
                        + esquinaC + " ha ganado el premio de Esquina");
                
            }
            
            if(estampaCheckEng(cartones) > 0 && !estampa){
                
                estampa = true;
                estampaC = estampaCheckEng(cartones);
                System.out.println("El jugador con el cartón "
                        + estampaC + " ha ganado el premio de Estampa");
                
            }
            
            if(fullCheckEng(cartones) > 0 && !full){
                
                full = true;
                fullC = fullCheckEng(cartones);
                System.out.println("El jugador con el cartón "
                        + fullC + " ha ganado el premio de Full");
                
            }
            
            if(pokerCheckEng(cartones) > 0 && !poker){
                
                poker = true;
                pokerC = pokerCheckEng(cartones);
                System.out.println("El jugador con el cartón "
                        + pokerC + " ha ganado el premio de Póker");
                
            }    
            
            if(winCheckEng(cartones) > 0){//Comprobamos si a uno le ha salido Pokino:
                
                victoria = true;
                ganador = winCheckEng(cartones);
                System.out.println("POKINO!!!\nEl jugador con el cartón "
                        + ganador + " es el ganador del Pokino");
                
            }                                                
            
        }while(!victoria);
        
        //Mostramos por pantalla a cada ganador de los premios:        
        System.out.println("Ganadores de los premios: ");
        //Si hay un ganador, se muestra su nº de cartón, si no,
        //se muestra que ninguno ha ganado:
        System.out.println("Centro: " + ((centro) ? "Cartón nº " + centroC : "Ningún Cartón"));        
        System.out.println("Esquina: " + ((esquina) ? "Cartón nº " + esquinaC : "Ningún Cartón"));        
        System.out.println("Estampa: " + ((estampa) ? "Cartón nº " + estampaC : "Ningún Cartón"));        
        System.out.println("Poker: " + ((poker)?"Cartón nº " + pokerC : "Ningún Cartón"));        
        System.out.println("Full: " + ((full) ? "Cartón nº " + fullC : "Ningún Cartón"));
        //Por último, mostramos el ganador del Pokino:
        System.out.println("Ganador del juego: Cartón nº " + ganador);

    }

    public static int estampaCheckEng(ArrayList<Carton> cartones) {
        
        //Método para comprobar estampas

        for (int i = 0; i < 12; i++) {//Comprobamos en los cartones cual posee cuatro cartas tachadas en una esquina

            if ((cartones.get(i).getCartonEng()[0][0].isTachado()
                    && cartones.get(i).getCartonEng()[0][1].isTachado()
                    && cartones.get(i).getCartonEng()[1][0].isTachado()
                    && cartones.get(i).getCartonEng()[1][1].isTachado())
                    || (cartones.get(i).getCartonEng()[0][4].isTachado()
                    && cartones.get(i).getCartonEng()[1][4].isTachado()
                    && cartones.get(i).getCartonEng()[0][3].isTachado()
                    && cartones.get(i).getCartonEng()[1][3].isTachado())
                    || (cartones.get(i).getCartonEng()[4][0].isTachado()
                    && cartones.get(i).getCartonEng()[3][1].isTachado()
                    && cartones.get(i).getCartonEng()[3][0].isTachado()
                    && cartones.get(i).getCartonEng()[4][1].isTachado())
                    || (cartones.get(i).getCartonEng()[4][4].isTachado()
                    && cartones.get(i).getCartonEng()[3][4].isTachado()
                    && cartones.get(i).getCartonEng()[3][3].isTachado()
                    && cartones.get(i).getCartonEng()[4][3].isTachado())) {

                return cartones.get(i).getId();
                
            }

        }

        return -1;

    }

    public static int esquinaCheckEng(ArrayList<Carton> cartones) {
        
        //System.out.println("Comprobando esquinas...");

        for (int i = 0; i < 12; i++) {
            
            //Comprobamos en los cartones cual posee cuatro esquinas tachadas

            if (cartones.get(i).getCartonEng()[0][0].isTachado()
                    && cartones.get(i).getCartonEng()[4][0].isTachado()
                    && cartones.get(i).getCartonEng()[0][4].isTachado()
                    && cartones.get(i).getCartonEng()[4][4].isTachado()) {

                return cartones.get(i).getId();

            }

        }

        return -1;

    }

    public static int pokerCheckEng(ArrayList<Carton> cartones) {
        
        //System.out.println("Comprobando pokers...");

        for (int i = 0; i < 12; i++) {

            if (cartones.get(i).getCartonEng()[0][0].isTachado()
                    && cartones.get(i).getCartonEng()[0][1].isTachado()
                    && cartones.get(i).getCartonEng()[0][2].isTachado()
                    && cartones.get(i).getCartonEng()[0][3].isTachado()) {

                return cartones.get(i).getId();

            }

        }

        return -1;

    }

    public static int fullCheckEng(ArrayList<Carton> cartones) {
        
        //System.out.println("Comprobando fulls...");

        for (int i = 0; i < 12; i++) {

            //Comprobamos si un cartón tiene la 2a fila tachada
            if (cartones.get(i).getCartonEng()[1][0].isTachado()
                    && cartones.get(i).getCartonEng()[1][1].isTachado()
                    && cartones.get(i).getCartonEng()[1][2].isTachado()
                    && cartones.get(i).getCartonEng()[1][3].isTachado()
                    && cartones.get(i).getCartonEng()[1][4].isTachado()) {

                return cartones.get(i).getId();

            }

        }

        return -1;

    }

    public static int centroCheckEng(ArrayList<Carton> cartones) {
        
        //Método para comprobar quien tiene el premio del centro.

        for (int i = 0; i < 12; i++) {

            if (cartones.get(i).getCartonEng()[2][2].isTachado()) {

                return cartones.get(i).getId();

            }

        }

        return -1;

    }

    public static int winCheckEng(ArrayList<Carton> cartones) {
        
        //System.out.println("Comprobando cartones...");

        int contador;

        for (int i = 0; i < 12; i++) {

            for (int n = 0; n < 5; n++) {
                
                contador = 0;

                if (n != 2) {

                    for (int m = 0; m < 5; m++) {

                        if (cartones.get(i).getCartonEng()[n][m].isTachado()) {

                            contador++;
                            //System.out.println("Contador: " + contador);

                        }

                    }

                    if (contador == 5) {

                        

                        return cartones.get(i).getId();

                    }

                }

            }
            
            for (int n = 0; n < 5; n++) {
                
                contador = 0;

                    for (int m = 0; m < 5; m++) {

                        if (cartones.get(i).getCartonEng()[m][n].isTachado()) {

                            contador++;
                            //System.out.println("Contador: " + contador);

                        }

                    if (contador == 5) {

                        

                        return cartones.get(i).getId();

                    }

                }

            }

            if ((cartones.get(i).getCartonEng()[0][0].isTachado()
                    && cartones.get(i).getCartonEng()[1][1].isTachado()
                    && cartones.get(i).getCartonEng()[2][2].isTachado()
                    && cartones.get(i).getCartonEng()[3][3].isTachado()
                    && cartones.get(i).getCartonEng()[4][4].isTachado())
                    || (cartones.get(i).getCartonEng()[4][0].isTachado()
                    && cartones.get(i).getCartonEng()[3][1].isTachado()
                    && cartones.get(i).getCartonEng()[2][2].isTachado()
                    && cartones.get(i).getCartonEng()[1][3].isTachado()
                    && cartones.get(i).getCartonEng()[0][4].isTachado())) {


                return cartones.get(i).getId();

            }

        }

        return -1;

    }

}
