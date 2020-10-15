/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaarchivos;

/**
 *
 * @author usuario
 */
public class principal {
   public static void main(String [] args){
       Demanda d = new Demanda();
       d.setVisible(false);
       Oferta o= new Oferta();
       o.setVisible(false);
       Inicio i= new Inicio();
       i.setVisible(true);
       Empresa e = new   Empresa();
       e.setVisible(false);
       e.setBounds(10, 20, 400, 400);
       Empresa em=new Empresa();
       em.setVisible(false);
       
       
   }
	 
}
