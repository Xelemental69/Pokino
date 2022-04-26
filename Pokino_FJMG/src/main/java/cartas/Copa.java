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

    

    public Copa(int numero) {

        super(numero);
        this.id = "C" + numero;

    }

    public Copa() {

        super();
        this.id = "C" + numero;

    }

    @Override
    public void mostrarCarta() {

        if (!tachado) {

            switch (numero) {

                case 1:
                    System.out.printf("As de Copas");
                    break;

                case 10:
                    System.out.printf("Sota de Copas");
                    break;

                case 11:
                    System.out.printf("Caballo de Copas");
                    break;

                case 12:
                    System.out.printf("Rey de Copas");
                    break;

                default:
                    System.out.printf( numero + " de Copas");
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
