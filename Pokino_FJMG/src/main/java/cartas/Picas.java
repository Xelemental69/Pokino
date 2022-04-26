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
public class Picas extends CartaPoker {

    

    public Picas(int numero) {

        super(numero);
        this.id = "P" + numero;

    }

    public Picas() {

        super();
        this.id = "P" + numero;

    }

    @Override
    public void mostrarCarta() {

        if (!tachado) {

            switch (numero) {

                case 1:
                    System.out.printf("As de Picas");
                    break;

                case 11:
                    System.out.printf("J de Picas");
                    break;

                case 12:
                    System.out.printf("Q de Picas");
                    break;

                case 13:
                    System.out.printf("K de Picas");
                    break;

                default:
                    System.out.printf(numero + " de Picas");
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
