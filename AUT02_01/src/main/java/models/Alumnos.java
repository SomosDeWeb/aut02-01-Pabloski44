package models;

public class Alumnos {
    private String nombre;
    private int edad;
    private double notaMedia;
    private boolean matriculado;

//Constructor para usar en Main

    public Alumnos(String nombre, int edad, double notaMedia, boolean matriculado) {
        this.nombre = nombre;
        this.edad = edad;
        this.notaMedia = notaMedia;
        this.matriculado = matriculado;
    }

    //Metodos Getters

    public String getNombre() {
        return nombre;
    }

    public int getEdad(){
        return edad;
    }

    public double getNotaMedia(){
        return notaMedia;
    }

    public boolean getmatriculado(){
        return matriculado;
    }

    //Metodos setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }

    public void setMatriculado(boolean matriculado) {
        this.matriculado = matriculado;
    }


}
