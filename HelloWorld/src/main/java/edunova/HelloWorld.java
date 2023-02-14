/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package edunova;

/**
 *
 * @author WinUSER
 */
public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello World!");
         System.out.println("");
        
       Osoba osoba=new Osoba();
       osoba.setIme("Isidora");
       osoba.setPrezime("Karan");
        System.out.println(osoba.getIme() + " " + osoba.getPrezime());
       
       
        
       
        
        new Prozor().setVisible(true);
       
    }
}
