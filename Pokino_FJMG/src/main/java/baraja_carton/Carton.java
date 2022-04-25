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

public class Carton {

    //Atributos compartidos entre clases:
    final int MAX = 5;
    ArrayList<CartaEsp[]> lineaPokerEsp;//Registra la línea de poker de cada cartón hecho (Cartas Españolas)
    ArrayList<CartaEsp[]> lineaFullEsp;//Registra la línea de full de cada cartón hecho (Cartas Españolas)
    ArrayList<CartaEsp> centrosEsp;//Registra la línea de poker de cada cartón hecho (Cartas Españolas)
    ArrayList<CartaPoker[]> lineaPokerEng;//Registra la línea de poker de cada cartón hecho (Cartas Inglesas)
    ArrayList<CartaPoker[]> lineaFullEng;//Registra la línea de full de cada cartón hecho (Cartas Inglesas)
    ArrayList<CartaPoker> centrosEng;//Registra la línea de poker de cada cartón hecho (Cartas Inglesas)

    Random rng;//El random
    int numRep1;//El nº que se repetirá en la fila 1 (Fila Poker)
    int numRep2;//El nº que se repetirá 3 veces en la fila 2 (Fila Full)
    //Variables auxiliares:
    int tmp;
    int aux;

    //Atributos propios de la clase:
    private int id;
    private CartaEsp[][] cartonEsp;
    private CartaPoker[][] cartonEng;
    private BarajaEsp barajaEsp;
    private BarajaEsp barajaEspAux;//Nos servirá para cuando se establezca la fila full
    private BarajaPoker barajaEng;
    private BarajaPoker barajaEngAux;//Nos servirá para cuando se establezca la fila full

    public Carton(int id) {//Constructor

        this.id = id;
        numRep1 = rng.nextInt(12);
        aux = rng.nextInt(5);
        rng = new Random();
        
        //Generamos el cartón de cartas españolas y el de inglesas:
        generarCartonEsp();

    }
    
    private void generarCartonEsp(){//Método que genera el cartón (Cartas Españolas)
        
        
        //Para las primeras 2 filas, llamamos a sus métodos
        //específicos (y si coinciden con alguna de las filas
        //registradas, se repite el proceso):
        
        do{
        
            barajaEsp = new BarajaEsp();
            generarLineaPokerEsp();

        }while(lineaPokerEsp.contains(cartonEsp[0]));
            
        //Añadimos la fila poker al registro:
        lineaPokerEsp.add(cartonEsp[0]);
        
        barajaEspAux = barajaEsp;
        
        //Preparamos la baraja auxiliar para generar la segunda fila:
        do{
            
            barajaEsp = barajaEspAux;
            generarLineaFullEsp();
            
        }while(lineaFullEsp.contains(cartonEsp[1]));
        
        //Guardamos la línea de full en el registro:
        lineaFullEsp.add(cartonEsp[1]);
                                
        do{//Ahora, escogemos la carta que estará al centro,
            //y procuramos que no esté en otro cartón en dicha posición
            //con el ArrayList centros:
            
            do{//Escogemos una de las 12 filas de la baraja (siempre que no esté vacía):

                tmp = rng.nextInt(12);

            }while(barajaEsp.getBaraja()[tmp].isEmpty());

            //Generamos al azar la posición del ArrayList del cual sacaremos la
            //carta (según el tamaño del ArrayList)
            aux = rng.nextInt(barajaEsp.getBaraja()[tmp].size());
            
            //Introducimos la carta de la baraja en el cartón:
            cartonEsp[2][2] = barajaEsp.getBaraja()[tmp].get(aux);
            
        }while(centrosEsp.contains(cartonEsp[2][2]));
        
            //Añadimos la carta del centro al registro:
            centrosEsp.add(cartonEsp[2][2]);
            
            //Y la borramos de la baraja para evitar duplicados:
            barajaEsp.getBaraja()[tmp].remove(aux);
        
            
        for(int x = 2; x < MAX; x++){
            
            //Para escoger las cartas restantes, hacemos un bucle:
            for(int y = 0; y < MAX; y++){
                
                do{//Escogemos una de las 12 filas de la baraja (siempre que no esté vacía):
                    
                    tmp = rng.nextInt(12);
                    
                }while(barajaEsp.getBaraja()[tmp].isEmpty());
                
                if(x != 2 && y != 2){//Con este if, ignoramos el proceso
                    //al llegar a la carta del centro
                    
                    //Generamos al azar la posición del ArrayList del cual sacaremos la
                    //carta (según el tamaño del ArrayList)
                    aux = rng.nextInt(barajaEsp.getBaraja()[tmp].size());

                    //Introducimos la carta de la baraja en el cartón:
                    cartonEsp[x][y] = barajaEsp.getBaraja()[tmp].get(aux);
                    
                    //Y la borramos de la baraja para evitar duplicados:
                    barajaEsp.getBaraja()[tmp].remove(aux);
                
                }
                
            }
                                    
        }
        
    }

    private void generarLineaPokerEsp() {

        do {

            tmp = rng.nextInt(12);

        } while (tmp == numRep1);

        switch (aux) {//Realizamos un switch para determinar el orden de las cartas en la fila:

            case 0:
                
                //Escogemos una carta al azar, cuyo nº no se repita en la fila:

                aux = barajaEsp.getBaraja()[numRep1].size();

                cartonEsp[0][0] = barajaEsp.getBaraja()[tmp].get(rng.nextInt(aux));

                barajaEsp.getBaraja()[tmp].remove(aux);

                for (int i = 1; i < MAX; i++) {
                    //Cojemos 4 cartas con un mismo nº
                    //(determinado al azar en la variable numRep1)

                    aux = rng.nextInt(barajaEsp.getBaraja()[numRep1].size());

                    cartonEsp[0][i] = barajaEsp.getBaraja()[numRep1].get(aux);
                    barajaEsp.getBaraja()[numRep1].remove(aux);

                }

                break;

            case 1://La carta con nº no repetido se asigna a la segunda posición

                aux = rng.nextInt(barajaEsp.getBaraja()[numRep1].size());

                cartonEsp[0][0] = barajaEsp.getBaraja()[numRep1].get(rng.nextInt(aux));
                barajaEsp.getBaraja()[3].remove(aux);

                aux = barajaEsp.getBaraja()[tmp].size();

                cartonEsp[0][1] = barajaEsp.getBaraja()[tmp].get(rng.nextInt(aux));

                barajaEsp.getBaraja()[tmp].remove(aux);

                for (int i = 2; i < MAX; i++) {

                    aux = rng.nextInt(barajaEsp.getBaraja()[numRep1].size());

                    cartonEsp[0][i] = barajaEsp.getBaraja()[numRep1].get(aux);
                    barajaEsp.getBaraja()[numRep1].remove(aux);

                }

                break;

            case 2://La carta con nº no repetido se asigna a la tercera posición

                for (int i = 0; i < 1; i++) {

                    aux = rng.nextInt(barajaEsp.getBaraja()[numRep1].size());

                    cartonEsp[0][i] = barajaEsp.getBaraja()[numRep1].get(aux);
                    barajaEsp.getBaraja()[numRep1].remove(aux);

                }

                aux = barajaEsp.getBaraja()[tmp].size();

                cartonEsp[0][2] = barajaEsp.getBaraja()[tmp].get(rng.nextInt(aux));

                barajaEsp.getBaraja()[tmp].remove(aux);

                for (int i = 3; i < MAX; i++) {

                    aux = rng.nextInt(barajaEsp.getBaraja()[numRep1].size());

                    cartonEsp[0][i] = barajaEsp.getBaraja()[numRep1].get(aux);
                    barajaEsp.getBaraja()[numRep1].remove(aux);

                }

                break;

            case 3://La carta con nº no repetido se asigna a la cuarta posición

                for (int i = 0; i < 2; i++) {

                    aux = rng.nextInt(barajaEsp.getBaraja()[numRep1].size());

                    cartonEsp[0][i] = barajaEsp.getBaraja()[numRep1].get(aux);
                    barajaEsp.getBaraja()[numRep1].remove(aux);

                }

                aux = barajaEsp.getBaraja()[tmp].size();

                cartonEsp[0][3] = barajaEsp.getBaraja()[tmp].get(rng.nextInt(aux));

                barajaEsp.getBaraja()[tmp].remove(aux);

                aux = rng.nextInt(barajaEsp.getBaraja()[numRep1].size());

                cartonEsp[0][4] = barajaEsp.getBaraja()[numRep1].get(rng.nextInt(aux));
                barajaEsp.getBaraja()[numRep1].remove(aux);

                break;

            case 4://La carta con nº no repetido se asigna a la última posición

                for (int i = 0; i < 1; i++) {

                    aux = rng.nextInt(barajaEsp.getBaraja()[numRep1].size());

                    cartonEsp[0][i] = barajaEsp.getBaraja()[numRep1].get(aux);
                    barajaEsp.getBaraja()[numRep1].remove(aux);

                }

                aux = barajaEsp.getBaraja()[tmp].size();

                cartonEsp[0][4] = barajaEsp.getBaraja()[tmp].get(rng.nextInt(aux));

                barajaEsp.getBaraja()[tmp].remove(aux);

                break;

        }

        

    }

    private void generarLineaFullEsp() {

        do {//Preparamos el auxiliar tmp y la variable numRep2
            //y procuramos que no sean iguales entre sí o iguales a numRep1:

            numRep2 = rng.nextInt(12);//a
            tmp = rng.nextInt(12);//b

        } while (tmp == numRep1 || numRep2 == numRep1 || tmp == numRep2);

        switch (rng.nextInt(6)) {//El switch determina el orden de las cartas (al azar):

            case 0://Orden: 3a-2b

                for (int j = 0; j < 3; j++) {//Cojemos 3 cartas del
                    //nº establecido en numRep2:

                    aux = rng.nextInt(barajaEsp.getBaraja()[numRep2].size());

                    cartonEsp[1][j] = barajaEsp.getBaraja()[numRep2].get(aux);
                    barajaEsp.getBaraja()[numRep2].remove(aux);

                }

                for (int j = 3; j < MAX; j++) {//Y las 2 restantes serán del
                    //nº establecido en tmp:

                    aux = rng.nextInt(barajaEsp.getBaraja()[tmp].size());

                    cartonEsp[1][j] = barajaEsp.getBaraja()[tmp].get(aux);
                    barajaEsp.getBaraja()[tmp].remove(aux);

                }

                break;

            case 1://Orden: 2b-3a

                for (int j = 0; j < 3; j++) {

                    aux = rng.nextInt(barajaEsp.getBaraja()[tmp].size());

                    cartonEsp[1][j] = barajaEsp.getBaraja()[tmp].get(aux);
                    barajaEsp.getBaraja()[tmp].remove(aux);

                }

                for (int j = 3; j < MAX; j++) {

                    aux = rng.nextInt(barajaEsp.getBaraja()[numRep2].size());

                    cartonEsp[1][j] = barajaEsp.getBaraja()[numRep2].get(aux);
                    barajaEsp.getBaraja()[numRep2].remove(aux);

                }

                break;

            case 2://Orden: 1a-2b-2a

                aux = rng.nextInt(barajaEsp.getBaraja()[numRep2].size());

                cartonEsp[1][0] = barajaEsp.getBaraja()[numRep2].get(aux);
                barajaEsp.getBaraja()[numRep2].remove(aux);

                for (int j = 1; j < 3; j++) {

                    aux = rng.nextInt(barajaEsp.getBaraja()[tmp].size());

                    cartonEsp[1][j] = barajaEsp.getBaraja()[tmp].get(aux);
                    barajaEsp.getBaraja()[tmp].remove(aux);

                }

                for (int j = 3; j < MAX; j++) {

                    aux = rng.nextInt(barajaEsp.getBaraja()[numRep2].size());

                    cartonEsp[1][j] = barajaEsp.getBaraja()[numRep2].get(aux);
                    barajaEsp.getBaraja()[numRep2].remove(aux);

                }

                break;

            case 3://Orden: 2a-2b-1a:

                for (int j = 0; j < 2; j++) {

                    aux = rng.nextInt(barajaEsp.getBaraja()[numRep2].size());

                    cartonEsp[1][j] = barajaEsp.getBaraja()[numRep2].get(aux);
                    barajaEsp.getBaraja()[numRep2].remove(aux);

                }

                for (int j = 2; j < 4; j++) {

                    aux = rng.nextInt(barajaEsp.getBaraja()[tmp].size());

                    cartonEsp[1][j] = barajaEsp.getBaraja()[tmp].get(aux);
                    barajaEsp.getBaraja()[tmp].remove(aux);

                }

                aux = rng.nextInt(barajaEsp.getBaraja()[numRep2].size());

                cartonEsp[1][4] = barajaEsp.getBaraja()[numRep2].get(aux);
                barajaEsp.getBaraja()[numRep2].remove(aux);

                break;

            case 4://Orden: 1a-1b-1a-1b-1a

                for (int j = 0; j < MAX; j++) {

                    if (j % 2 != 0) {

                        aux = rng.nextInt(barajaEsp.getBaraja()[tmp].size());

                        cartonEsp[1][j] = barajaEsp.getBaraja()[tmp].get(aux);
                        barajaEsp.getBaraja()[tmp].remove(aux);

                    } else {

                        aux = rng.nextInt(barajaEsp.getBaraja()[numRep2].size());

                        cartonEsp[1][j] = barajaEsp.getBaraja()[numRep2].get(aux);
                        barajaEsp.getBaraja()[numRep2].remove(aux);

                    }

                }

                break;

            case 5://1b-3a-1b

                aux = rng.nextInt(barajaEsp.getBaraja()[tmp].size());

                cartonEsp[1][0] = barajaEsp.getBaraja()[tmp].get(aux);
                barajaEsp.getBaraja()[tmp].remove(aux);

                for (int j = 1; j < 4; j++) {

                    aux = rng.nextInt(barajaEsp.getBaraja()[numRep2].size());

                    cartonEsp[1][j] = barajaEsp.getBaraja()[numRep2].get(aux);
                    barajaEsp.getBaraja()[numRep2].remove(aux);

                }

                aux = rng.nextInt(barajaEsp.getBaraja()[tmp].size());

                cartonEsp[1][0] = barajaEsp.getBaraja()[tmp].get(aux);
                barajaEsp.getBaraja()[tmp].remove(aux);

                break;

        }                

    }
    
    private void generarCartonEng(){//Método que genera el cartón (Cartas Inglesas)
        
        //Generamos un nº del 1 al 13, ya que cada tipo de carta inglesa
        //posee 13 variaciones en vez de 12:
        numRep1 = rng.nextInt(13);
        
        //Para las primeras 2 filas, llamamos a sus métodos
        //específicos (y si coinciden con alguna de las filas
        //registradas, se repite el proceso):
        
        do{
        
            barajaEng = new BarajaPoker();
            generarLineaPokerEng();

        }while(lineaPokerEng.contains(cartonEng[0]));
            
        //Añadimos la fila poker al registro:
        lineaPokerEng.add(cartonEng[0]);
        
        barajaEngAux = barajaEng;
        
        //Preparamos la baraja auxiliar para generar la segunda fila:
        do{
            
            barajaEng = barajaEngAux;
            generarLineaFullEsp();
            
        }while(lineaFullEng.contains(cartonEng[1]));
        
        //Guardamos la línea de full en el registro:
        lineaFullEng.add(cartonEng[1]);
                                
        do{//Ahora, escogemos la carta que estará al centro,
            //y procuramos que no esté en otro cartón en dicha posición
            //con el ArrayList centros:
            
            do{//Escogemos una de las 13 filas de la baraja (siempre que no esté vacía):

                tmp = rng.nextInt(13);

            }while(barajaEng.getBaraja()[tmp].isEmpty());

            //Generamos al azar la posición del ArrayList del cual sacaremos la
            //carta (según el tamaño del ArrayList)
            aux = rng.nextInt(barajaEng.getBaraja()[tmp].size());
            
            //Introducimos la carta de la baraja en el cartón:
            cartonEng[2][2] = barajaEng.getBaraja()[tmp].get(aux);
            
        }while(centrosEng.contains(cartonEng[2][2]));
        
            //Añadimos la carta del centro al registro:
            centrosEng.add(cartonEng[2][2]);
            
            //Y la borramos de la baraja para evitar duplicados:
            barajaEng.getBaraja()[tmp].remove(aux);
        
            
        for(int x = 2; x < MAX; x++){
            
            //Para escoger las cartas restantes, hacemos un bucle:
            for(int y = 0; y < MAX; y++){
                
                do{//Escogemos una de las 12 filas de la baraja (siempre que no esté vacía):
                    
                    tmp = rng.nextInt(12);
                    
                }while(barajaEng.getBaraja()[tmp].isEmpty());
                
                if(x != 2 && y != 2){//Con este if, ignoramos el proceso
                    //al llegar a la carta del centro
                    
                    //Generamos al azar la posición del ArrayList del cual sacaremos la
                    //carta (según el tamaño del ArrayList)
                    aux = rng.nextInt(barajaEng.getBaraja()[tmp].size());

                    //Introducimos la carta de la baraja en el cartón:
                    cartonEng[x][y] = barajaEng.getBaraja()[tmp].get(aux);
                    
                    //Y la borramos de la baraja para evitar duplicados:
                    barajaEng.getBaraja()[tmp].remove(aux);
                
                }
                
            }
                                    
        }
        
    }

    private void generarLineaPokerEng() {

        do {

            tmp = rng.nextInt(13);

        } while (tmp == numRep1);

        switch (aux) {//Realizamos un switch para determinar el orden de las cartas en la fila:

            case 0:
                
                //Escogemos una carta al azar, cuyo nº no se repita en la fila:

                aux = barajaEng.getBaraja()[numRep1].size();

                cartonEng[0][0] = barajaEng.getBaraja()[tmp].get(rng.nextInt(aux));

                barajaEng.getBaraja()[tmp].remove(aux);

                for (int i = 1; i < MAX; i++) {
                    //Cojemos 4 cartas con un mismo nº
                    //(determinado al azar en la variable numRep1)

                    aux = rng.nextInt(barajaEng.getBaraja()[numRep1].size());

                    cartonEng[0][i] = barajaEng.getBaraja()[numRep1].get(aux);
                    barajaEng.getBaraja()[numRep1].remove(aux);

                }

                break;

            case 1://La carta con nº no repetido se asigna a la segunda posición

                aux = rng.nextInt(barajaEng.getBaraja()[numRep1].size());

                cartonEng[0][0] = barajaEng.getBaraja()[numRep1].get(rng.nextInt(aux));
                barajaEng.getBaraja()[3].remove(aux);

                aux = barajaEng.getBaraja()[tmp].size();

                cartonEng[0][1] = barajaEng.getBaraja()[tmp].get(rng.nextInt(aux));

                barajaEng.getBaraja()[tmp].remove(aux);

                for (int i = 2; i < MAX; i++) {

                    aux = rng.nextInt(barajaEng.getBaraja()[numRep1].size());

                    cartonEng[0][i] = barajaEng.getBaraja()[numRep1].get(aux);
                    barajaEng.getBaraja()[numRep1].remove(aux);

                }

                break;

            case 2://La carta con nº no repetido se asigna a la tercera posición

                for (int i = 0; i < 1; i++) {

                    aux = rng.nextInt(barajaEng.getBaraja()[numRep1].size());

                    cartonEng[0][i] = barajaEng.getBaraja()[numRep1].get(aux);
                    barajaEng.getBaraja()[numRep1].remove(aux);

                }

                aux = barajaEng.getBaraja()[tmp].size();

                cartonEng[0][2] = barajaEng.getBaraja()[tmp].get(rng.nextInt(aux));

                barajaEng.getBaraja()[tmp].remove(aux);

                for (int i = 3; i < MAX; i++) {

                    aux = rng.nextInt(barajaEng.getBaraja()[numRep1].size());

                    cartonEng[0][i] = barajaEng.getBaraja()[numRep1].get(aux);
                    barajaEng.getBaraja()[numRep1].remove(aux);

                }

                break;

            case 3://La carta con nº no repetido se asigna a la cuarta posición

                for (int i = 0; i < 2; i++) {

                    aux = rng.nextInt(barajaEng.getBaraja()[numRep1].size());

                    cartonEng[0][i] = barajaEng.getBaraja()[numRep1].get(aux);
                    barajaEng.getBaraja()[numRep1].remove(aux);

                }

                aux = barajaEng.getBaraja()[tmp].size();

                cartonEng[0][3] = barajaEng.getBaraja()[tmp].get(rng.nextInt(aux));

                barajaEng.getBaraja()[tmp].remove(aux);

                aux = rng.nextInt(barajaEng.getBaraja()[numRep1].size());

                cartonEng[0][4] = barajaEng.getBaraja()[numRep1].get(rng.nextInt(aux));
                barajaEng.getBaraja()[numRep1].remove(aux);

                break;

            case 4://La carta con nº no repetido se asigna a la última posición

                for (int i = 0; i < 1; i++) {

                    aux = rng.nextInt(barajaEng.getBaraja()[numRep1].size());

                    cartonEng[0][i] = barajaEng.getBaraja()[numRep1].get(aux);
                    barajaEng.getBaraja()[numRep1].remove(aux);

                }

                aux = barajaEng.getBaraja()[tmp].size();

                cartonEng[0][4] = barajaEng.getBaraja()[tmp].get(rng.nextInt(aux));

                barajaEng.getBaraja()[tmp].remove(aux);

                break;

        }

        

    }

    private void generarLineaFullEng() {

        do {//Preparamos el auxiliar tmp y la variable numRep2
            //y procuramos que no sean iguales entre sí o iguales a numRep1:

            numRep2 = rng.nextInt(13);//a
            tmp = rng.nextInt(13);//b

        } while (tmp == numRep1 || numRep2 == numRep1 || tmp == numRep2);

        switch (rng.nextInt(6)) {//El switch determina el orden de las cartas (al azar):

            case 0://Orden: 3a-2b

                for (int j = 0; j < 3; j++) {//Cojemos 3 cartas del
                    //nº establecido en numRep2:

                    aux = rng.nextInt(barajaEng.getBaraja()[numRep2].size());

                    cartonEng[1][j] = barajaEng.getBaraja()[numRep2].get(aux);
                    barajaEng.getBaraja()[numRep2].remove(aux);

                }

                for (int j = 3; j < MAX; j++) {//Y las 2 restantes serán del
                    //nº establecido en tmp:

                    aux = rng.nextInt(barajaEng.getBaraja()[tmp].size());

                    cartonEng[1][j] = barajaEng.getBaraja()[tmp].get(aux);
                    barajaEng.getBaraja()[tmp].remove(aux);

                }

                break;

            case 1://Orden: 2b-3a

                for (int j = 0; j < 3; j++) {

                    aux = rng.nextInt(barajaEng.getBaraja()[tmp].size());

                    cartonEng[1][j] = barajaEng.getBaraja()[tmp].get(aux);
                    barajaEng.getBaraja()[tmp].remove(aux);

                }

                for (int j = 3; j < MAX; j++) {

                    aux = rng.nextInt(barajaEng.getBaraja()[numRep2].size());

                    cartonEng[1][j] = barajaEng.getBaraja()[numRep2].get(aux);
                    barajaEng.getBaraja()[numRep2].remove(aux);

                }

                break;

            case 2://Orden: 1a-2b-2a

                aux = rng.nextInt(barajaEng.getBaraja()[numRep2].size());

                cartonEng[1][0] = barajaEng.getBaraja()[numRep2].get(aux);
                barajaEng.getBaraja()[numRep2].remove(aux);

                for (int j = 1; j < 3; j++) {

                    aux = rng.nextInt(barajaEng.getBaraja()[tmp].size());

                    cartonEng[1][j] = barajaEng.getBaraja()[tmp].get(aux);
                    barajaEng.getBaraja()[tmp].remove(aux);

                }

                for (int j = 3; j < MAX; j++) {

                    aux = rng.nextInt(barajaEng.getBaraja()[numRep2].size());

                    cartonEng[1][j] = barajaEng.getBaraja()[numRep2].get(aux);
                    barajaEng.getBaraja()[numRep2].remove(aux);

                }

                break;

            case 3://Orden: 2a-2b-1a:

                for (int j = 0; j < 2; j++) {

                    aux = rng.nextInt(barajaEng.getBaraja()[numRep2].size());

                    cartonEng[1][j] = barajaEng.getBaraja()[numRep2].get(aux);
                    barajaEng.getBaraja()[numRep2].remove(aux);

                }

                for (int j = 2; j < 4; j++) {

                    aux = rng.nextInt(barajaEng.getBaraja()[tmp].size());

                    cartonEng[1][j] = barajaEng.getBaraja()[tmp].get(aux);
                    barajaEng.getBaraja()[tmp].remove(aux);

                }

                aux = rng.nextInt(barajaEng.getBaraja()[numRep2].size());

                cartonEng[1][4] = barajaEng.getBaraja()[numRep2].get(aux);
                barajaEng.getBaraja()[numRep2].remove(aux);

                break;

            case 4://Orden: 1a-1b-1a-1b-1a

                for (int j = 0; j < MAX; j++) {

                    if (j % 2 != 0) {

                        aux = rng.nextInt(barajaEng.getBaraja()[tmp].size());

                        cartonEng[1][j] = barajaEng.getBaraja()[tmp].get(aux);
                        barajaEng.getBaraja()[tmp].remove(aux);

                    } else {

                        aux = rng.nextInt(barajaEsp.getBaraja()[numRep2].size());

                        cartonEng[1][j] = barajaEng.getBaraja()[numRep2].get(aux);
                        barajaEng.getBaraja()[numRep2].remove(aux);

                    }

                }

                break;

            case 5://1b-3a-1b

                aux = rng.nextInt(barajaEng.getBaraja()[tmp].size());

                cartonEng[1][0] = barajaEng.getBaraja()[tmp].get(aux);
                barajaEng.getBaraja()[tmp].remove(aux);

                for (int j = 1; j < 4; j++) {

                    aux = rng.nextInt(barajaEng.getBaraja()[numRep2].size());

                    cartonEng[1][j] = barajaEng.getBaraja()[numRep2].get(aux);
                    barajaEng.getBaraja()[numRep2].remove(aux);

                }

                aux = rng.nextInt(barajaEng.getBaraja()[tmp].size());

                cartonEng[1][0] = barajaEng.getBaraja()[tmp].get(aux);
                barajaEng.getBaraja()[tmp].remove(aux);

                break;

        }                

    }

}
