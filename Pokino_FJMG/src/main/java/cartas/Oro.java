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
    
    protected String id;

    public Oro(int numero) {

        super(numero);
        this.id = "P" + numero;

    }

    public Oro() {

        super();
        this.id = "P" + numero;

    }

    public void mostrarCarta() {
        
        if(!tachado){

            switch (numero) {

                case 1:
                    System.out.println("As de Oros");
                    break;

                case 10:
                    System.out.println("Sota de Oros");
                    break;

                case 11:
                    System.out.println("Caballo de Oros");
                    break;

                case 12:
                    System.out.println("Rey de Oros");
                    break;

                default:
                    System.out.println(numero + " de Oros");
                    break;

            }
        
        } else {

            System.out.println("XXXXXXXXXX");

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