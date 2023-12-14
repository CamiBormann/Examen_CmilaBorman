/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenpoo_camilabormann;

/**
 *
 * @author camil
 */
public class Modelo implements Serializable{ //creacion de la clase

    private int FolioMecanico;
    private String NombreApellido;
    private int Edad;
    private String Domicilio;
    private String Titulo;
    private String Especialidad;
    private int SueldoBase;
    private int GratTitulo;
    private int SueldoTotal;

    public Modelo() {
    }

    public Modelo(int IdMecanico, String Nombre, int Edad, String Domicilio, String Titulo, String Especialidad, int SueldoBase, int GratTitulo, int SueldoTotal) {
        this.FolioMecanico = FolioMecanico;
        this.NombreApellido= NombreApellido;
        this.Edad = Edad;
        this.Domicilio = Domicilio;
        this.Titulo = Titulo;
        this.Especialidad = Especialidad;
        this.SueldoBase = SueldoBase;
        this.GratTitulo = GratTitulo;
        this.SueldoTotal = SueldoTotal;
    }

    public int getFolioMecanico() {
        return FolioMecanico;
    }

    public void setIFolioMecanico(int FolioMecanico) {
        this.FolioMecanico = FolioMecanico;
    }

    public String getNombreApellido() {
        return NombreApellido;
    }

    public void setNombreApellido(String Nombre) {
        this.NombreApellido = Nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getDomicilio() {
        return Domicilio;
    }

    public void setDomicilio(String Domicilio) {
        this.Domicilio = Domicilio;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }

    public int getSueldoBase() {
        return SueldoBase;
    }

    public void setSueldoBase(int SueldoBase) {
        this.SueldoBase = SueldoBase;
    }

    public int getGratTitulo() {
        return GratTitulo;
    }

    public void setGratTitulo(int GratTitulo) {
        this.GratTitulo = GratTitulo;
    }

    public int getSueldoTotal() {
        return SueldoTotal;
    }

    public void setSueldoTotal(int SueldoTotal) {
        this.SueldoTotal = SueldoTotal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre y Apellido del Mecanico: ").append(NombreApellido);
        sb.append("\nEdad : ").append(Edad);
        sb.append("\nEspecialidad o Profesion: ").append(Especialidad);
        sb.append("\nTitulo: ").append(Titulo);
        return sb.toString();
    }

}
