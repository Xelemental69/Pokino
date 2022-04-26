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
public class Oro extends CartaEsp {
    
    

    public Oro(int numero) {

        super(numero);
        this.id = "O" + numero;

    }

    public Oro() {

        super();
        this.id = "O" + numero;

    }

    @Override
    public void mostrarCarta() {
        
        if(!tachado){

            switch (numero) {

                case 1:
                    System.out.printf("As de Oros");
                    break;

                case 10:
                    System.out.printf("Sota de Oros");
                    break;

                case 11:
                    System.out.printf("Caballo de Oros");
                    break;

                case 12:
                    System.out.printf("Rey de Oros");
                    break;

                default:
                    System.out.printf(numero + " de Oros");
                    break;

            }
        
        } else {

            System.out.printf("XXXXXXXXXX");

        }

    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
}