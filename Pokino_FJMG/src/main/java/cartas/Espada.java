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
public class Espada extends CartaEsp {
    
    protected String id;

    public Espada(int numero) {

        super(numero);
        this.id = "P" + numero;

    }

    public Espada() {

        super();
        this.id = "P" + numero;

    }

    public void mostrarCarta() {

        switch (numero) {

            case 1:
                System.out.println("As de Espadas");
                break;
                
            case 10:
                System.out.println("Sota de Espadas");
                break;

            case 11:
                System.out.println("Caballo de Espadas");
                break;

            case 12:
                System.out.println("Rey de Espadas");
                break;
            
            default:
                System.out.println(numero + " de Espadas");
                break;

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