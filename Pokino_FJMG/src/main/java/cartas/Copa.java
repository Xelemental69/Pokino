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
public class Copa extends CartaEsp {
    
    protected String id;

    public Copa(int numero) {

        super(numero);
        this.id = "P" + numero;

    }

    public Copa() {

        super();
        this.id = "P" + numero;

    }

    public void mostrarCarta() {

        switch (numero) {

            case 1:
                System.out.println("As de Copas");
                break;
                
            case 10:
                System.out.println("Sota de Copas");
                break;

            case 11:
                System.out.println("Caballo de Copas");
                break;

            case 12:
                System.out.println("Rey de Copas");
                break;
            
            default:
                System.out.println(numero + " de Copas");
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