/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main_game;

/**
 *
 * @author fcoj
 */
import java.util.*;
import cartas.*;
import baraja_carton.*;

public class PruebaCartones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int choice;    
        Scanner entry = new Scanner(System.in);
        boolean permitemeQueInsista = false;
        ArrayList <Carton> jugadores = new ArrayList<>();
        //BarajaEsp plantilla = new BarajaEsp();
        
        for(int f = 0; f < 12; f++){
            
            jugadores.add(new Carton(f+1));
            
        }
        
        //plantilla.mostrarBaraja();
        
        
        
        try{
        
        System.out.println("¿Qué tipo de carta prefiere?");
        System.out.println("1: Carta Española");
        System.out.println("2: Carta Inglesa");
        System.out.println("Otro: Salir...");
        
        choice = entry.nextInt();
        
        if(choice == 1){
            
            for(int j = 0; j < 12; j++){
                
                System.out.println("Cartón " + jugadores.get(j).getId() + ":");
                jugadores.get(j).MostrarCartonEsp();

            }
            
        }else if(choice == 2){
            
            for(int j = 0; j < 12; j++){

                System.out.println("Cartón " + jugadores.get(j).getId() + ":");
                jugadores.get(j).MostrarCartonEng();

            }
            
        }else{
            
            System.out.println("Saliendo del programa...");
            
        }
        
        }catch(InputMismatchException ime){
            
            System.out.println("ERROR. Introduce un nº");
            permitemeQueInsista = true;
            System.out.println("PERMÍTEME QUE INSISTA");
            
        }
        
        

    }
    
}
