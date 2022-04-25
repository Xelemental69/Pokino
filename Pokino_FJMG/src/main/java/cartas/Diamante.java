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
public class Diamante extends CartaPoker {

    protected String id;

    public Diamante(int numero) {

        super(numero);
        this.id = "P" + numero;

    }

    public Diamante() {

        super();
        this.id = "P" + numero;

    }

    public void mostrarCarta() {

        if (tachado) {

            switch (numero) {

                case 1:
                    System.out.println("As de Diamantes");
                    break;

                case 11:
                    System.out.println("J de Diamantes");
                    break;

                case 12:
                    System.out.println("Q de Diamantes");
                    break;

                case 13:
                    System.out.println("K de Diamantes");
                    break;

                default:
                    System.out.println(numero + " de Diamantes");
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
