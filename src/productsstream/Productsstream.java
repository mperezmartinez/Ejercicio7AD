/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productsstream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oracle
 */
public class Productsstream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        product po1 = new product("cod1", "parafusos", 3);

        product po2 = new product("cod2", "arandelas", 4);

        try{
        DataInputStream dis = new DataInputStream(new FileInputStream("productos.txt"));
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("productos.txt", true));

        dos.writeUTF(po1.getCodigo());
        dos.writeUTF(po1.getDescripcion());
        dos.writeInt(po1.getPrecio());
        
        dos.writeUTF(po2.getCodigo());
        dos.writeUTF(po2.getDescripcion());
        dos.writeInt(po2.getPrecio());
        
        dos.close();
        
        
        String codigo=dis.readUTF();
        String desc = dis.readUTF();
        int preci = dis.readInt();
        
        dis.close();
        
        product po3= new product();
        po3.setCodigo(codigo);
        po3.setDescripcion(desc);
        po3.setPrecio(preci);
        
            System.out.println(po3.getCodigo());
            System.out.println(po3.getDescripcion());
            System.out.println(po3.getPrecio());
            
        
                } catch (FileNotFoundException ex) {
            Logger.getLogger(Productsstream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Productsstream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
