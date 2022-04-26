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
public class Trebol extends CartaPoker {

    

    public Trebol(int numero) {

        super(numero);
        this.id = "T" + numero;

    }

    public Trebol() {

        super();
        this.id = "T" + numero;

    }

    @Override
    public void mostrarCarta() {

        if (!tachado) {

            switch (numero) {

                case 1:
                    System.out.printf("As de Tréboles");
                    break;

                case 11:
                    System.out.printf("J de Tréboles");
                    break;

                case 12:
                    System.out.printf("Q de Tréboles");
                    break;

                case 13:
                    System.out.printf("K de Tréboles");
                    break;

                default:
                    System.out.printf( numero + " de Tréboles");
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
