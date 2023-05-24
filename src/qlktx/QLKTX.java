/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package qlktx;

/**
 *
 * @author ASUS
 */
public class QLKTX {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //new MainFrame().setVisible(true);
        LoginFrame start = new LoginFrame();
        start.setVisible(true);
        String ID = start.layID();               
    }    
}
