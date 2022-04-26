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
public class Corazon extends CartaPoker {

    

    public Corazon(int numero) {

        super(numero);
        this.id = "C" + numero;

    }

    public Corazon() {

        super();
        this.id = "C" + numero;

    }

    @Override
    public void mostrarCarta() {

        if (!tachado) {

            switch (numero) {

                case 1:
                    System.out.printf("As de Corazones");
                    break;

                case 11:
                    System.out.printf("J de Corazones");
                    break;

                case 12:
                    System.out.printf("Q de Corazones");
                    break;

                case 13:
                    System.out.printf("K de Corazones");
                    break;

                default:
                    System.out.printf(numero + " de Corazones");
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
