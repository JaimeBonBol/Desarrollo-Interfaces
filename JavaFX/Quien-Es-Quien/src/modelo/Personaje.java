package modelo;

public class Personaje {
    
    private String nombre;
    private boolean esHombre;
    private boolean esCalvo;
    private boolean tieneGafas;
    private boolean tieneSombrero;
    private String colorPelo;
    private String imagenRuta;
    private boolean activo; 

    public Personaje(String nombre, boolean esHombre, boolean esCalvo, boolean tieneGafas, boolean tieneSombrero, String colorPelo, String imagenRuta) {
        this.nombre = nombre;
        this.esHombre = esHombre;
        this.esCalvo = esCalvo;
        this.tieneGafas = tieneGafas;
        this.tieneSombrero = tieneSombrero;
        this.colorPelo = colorPelo;
        this.imagenRuta = imagenRuta;
        this.activo = true;
    }

    // Getters
    public String getNombre() { return nombre; }
    public boolean isEsHombre() { return esHombre; }
    public boolean isEsCalvo() { return esCalvo; }
    public boolean isTieneGafas() { return tieneGafas; }
    public boolean isTieneSombrero() { return tieneSombrero; }
    public String getColorPelo() { return colorPelo; }
    public String getImagenRuta() { return imagenRuta; }
    
    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    @Override
    public String toString() { return nombre; }
}