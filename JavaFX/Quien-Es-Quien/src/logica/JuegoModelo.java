package logica;

import modelo.Personaje;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JuegoModelo {

    private List<Personaje> listaPersonajes;
    private Personaje personajeOculto;
    private Random random;
    private int vidas;

    public JuegoModelo() {
        this.listaPersonajes = new ArrayList<>();
        this.random = new Random();
        inicializarPersonajes();
        reiniciarJuego();
    }

    private void inicializarPersonajes() {
        // GRUPO 1
        // Alex: Hombre, Moreno
        listaPersonajes.add(new Personaje("Alex", true, false, false, false, "Moreno", "persona1.png"));
        // Laura: Mujer, Rubio
        listaPersonajes.add(new Personaje("Laura", false, false, false, false, "Rubio", "persona4.png"));
        // Maria: Mujer, Moreno, Gafas, Sombrero
        listaPersonajes.add(new Personaje("Maria", false, false, true, true, "Moreno", "persona2.png"));
        // Pepe: Hombre, Calvo, Gafas
        listaPersonajes.add(new Personaje("Pepe", true, true, true, false, "Ninguno", "persona3.png"));
        
        
        // GRUPO 2
        // Sara: Mujer, Pelirrojo, Gafas
        listaPersonajes.add(new Personaje("Sara", false, false, true, false, "Pelirrojo", "persona6.png"));
        // Luis: Hombre, Calvo
        listaPersonajes.add(new Personaje("Luis", true, true, false, false, "Ninguno", "persona7.png"));
        // Juan: Hombre, Rubio, Sombrero
        listaPersonajes.add(new Personaje("Juan", true, false, false, true, "Rubio", "persona5.png"));
        // Elena: Mujer, Moreno, Sombrero
        listaPersonajes.add(new Personaje("Elena", false, false, false, true, "Moreno", "persona8.png"));

        // GRUPO 3
        // Ana: Mujer, Rubio, Gafas
        listaPersonajes.add(new Personaje("Ana", false, false, true, false, "Rubio", "persona10.png"));
        // Carlos: Hombre, Pelirrojo, Sombrero
        listaPersonajes.add(new Personaje("Carlos", true, false, false, true, "Pelirrojo", "persona9.png"));
        // Dani: Hombre, Moreno, Gafas
        listaPersonajes.add(new Personaje("Dani", true, false, true, false, "Moreno", "persona11.png"));
        // Lucia: Mujer, Pelirrojo, Sombrero
        listaPersonajes.add(new Personaje("Lucia", false, false, false, true, "Pelirrojo", "persona12.png"));
    }

    public void reiniciarJuego() {
        // Reactivar a todos los personajes
        for(Personaje p : listaPersonajes) {
            p.setActivo(true);
        }
        
        seleccionarPersonajeOculto();
        this.vidas = 3;
    }

    private void seleccionarPersonajeOculto() {
        int indice = random.nextInt(listaPersonajes.size());
        this.personajeOculto = listaPersonajes.get(indice);
        // Chivato en consola para probar
        System.out.println("El personaje oculto es: " + personajeOculto.getNombre());
    }

    public boolean cumplePregunta(Personaje p, String pregunta) {
        if (p == null) return false;
        if (pregunta == null) return false;
        
        switch (pregunta) {
            case "¿Es hombre?":
                return p.isEsHombre();
            case "¿Es mujer?":
                return !p.isEsHombre();
            case "¿Tiene gafas?":
                return p.isTieneGafas();
            case "¿Es calvo?":
                return p.isEsCalvo();
            case "¿Tiene sombrero?":
                return p.isTieneSombrero();
            case "¿Tiene pelo moreno?":
                return p.getColorPelo().equals("Moreno");
            case "¿Tiene pelo rubio?":
                return p.getColorPelo().equals("Rubio");
            case "¿Tiene pelo pelirrojo?":
                return p.getColorPelo().equals("Pelirrojo");
            default:
                return false;
        }
    }

    public int getVidas() { return vidas; }
    
    public void perderVida() {
        if (vidas > 0) {
            vidas = vidas - 1;
        }
    }

    public List<Personaje> getListaPersonajes() { return listaPersonajes; }
    public Personaje getPersonajeOculto() { return personajeOculto; }
}