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

    

    public Espada(int numero) {

        super(numero);
        this.id = "E" + numero;

    }

    public Espada() {

        super();
        this.id = "E" + numero;

    }

    @Override
    public void mostrarCarta() {

        if (!tachado) {

            switch (numero) {

                case 1:
                    System.out.printf("As de Espadas");
                    break;

                case 10:
                    System.out.printf("Sota de Espadas");
                    break;

                case 11:
                    System.out.printf("Caballo de Espadas");
                    break;

                case 12:
                    System.out.printf("Rey de Espadas");
                    break;

                default:
                    System.out.printf(numero + " de Espadas");
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
