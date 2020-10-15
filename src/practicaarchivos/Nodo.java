/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaarchivos;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author seviloria
 */
public class Nodo {

    String habilidad;
    String valoracion;
    String titulacion;
    String completa;
    String parcial;
    Long salmin;
    Long salmax;
    String emp;
    String nombre;
    String correo;
    Nodo link;
    DefaultTableModel tabla;
    int puntuacion;
    String email;

    public Nodo() {
        link = null;
    }

    public Nodo(String titulacion, long salmin, long salmax, String completa, String parcial, String habilidad, String valoracion) {
        this.titulacion = titulacion;
        this.salmin = salmin;
        this.salmax = salmax;
        this.completa = completa;
        this.parcial = parcial;
        this.habilidad = habilidad;
        this.valoracion = valoracion;
        link = null;
    }

    public Nodo(String nombre, String cotel) {
        this.nombre = nombre;
        this.correo = cotel;
        link = null;
    }

    public Nodo(int puntuacion, String nombre, String email, Long salmin, String completa, String parcial, String titulacion, String habilidad, String valoracion) {
        this.puntuacion = puntuacion;
        this.nombre = nombre;
        this.email = email;
        this.salmin = salmin;
        this.completa = completa;
        this.parcial = parcial;
        this.titulacion = titulacion;
        this.habilidad = habilidad;
        this.valoracion = valoracion;
        link = null;
    }

    public void OrdenarLista(Nodo ptr) {
        Nodo p = ptr;
        int puntuacion;
        String nombre;
        String email;
        Long salmin;
        String completa;
        String parcial;
        String titulacion;
        String habilidad;
        String valoracion;
        while (p != null) {
            Nodo q = p.link;
            while (q != null) {
                if (p.puntuacion < q.puntuacion) {
                    puntuacion = p.puntuacion;
                    nombre = p.nombre;
                    email = p.email;
                    salmin = p.salmin;
                    completa = p.completa;
                    parcial = p.parcial;
                    titulacion = p.titulacion;
                    habilidad = p.habilidad;
                    valoracion = p.valoracion;
                    p.nombre = q.nombre;
                    p.email = q.email;
                    p.salmin = q.salmin;
                    p.completa = q.completa;
                    p.parcial = q.parcial;
                    p.titulacion = q.titulacion;
                    p.habilidad = q.habilidad;
                    p.valoracion = q.valoracion;
                    q.nombre=nombre;
                    q.email=email;
                    q.salmin=salmin;
                    q.completa=completa;
                    q.parcial=parcial;
                    q.titulacion=titulacion;
                    q.habilidad=habilidad;
                    q.valoracion=valoracion;

                }
                q = q.link;
            }
            p = p.link;
        }
    }

}
