/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul10;

/**
 *
 * @author rpl
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Form_Siswa form = new Form_Siswa();
            form.setVisible(true);
        } catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
 
}
