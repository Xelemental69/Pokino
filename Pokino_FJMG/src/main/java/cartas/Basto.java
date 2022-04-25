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
public class Basto extends CartaEsp {

    protected String id;

    public Basto(int numero) {

        super(numero);
        this.id = "P" + numero;

    }

    public Basto() {

        super();
        this.id = "P" + numero;

    }

    public void mostrarCarta() {

        if (tachado) {

            switch (numero) {

                case 1:
                    System.out.println("As de Bastos");
                    break;

                case 10:
                    System.out.println("Sota de Bastos");
                    break;

                case 11:
                    System.out.println("Caballo de Bastos");
                    break;

                case 12:
                    System.out.println("Rey de Bastos");
                    break;

                default:
                    System.out.println(numero + " de Bastos");
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
