import java.io.Serializable;

public class SaveObject implements Serializable
{
    private String nombre, clase;
    private int nivel, exp, vidaMax, vidaTemp, defensa, danio, intel, sigilo, x, y;

    public SaveObject(String nombre, String clase, int nivel, int exp, int vidaMax, int vidaTemp, int defensa, int danio, int intel, int sigilo, int x, int y)
    {
        this.nombre = nombre;
        this.clase = clase;
        this.nivel = nivel;
        this.exp = exp;
        this.vidaMax = vidaMax;
        this.vidaTemp = vidaTemp;
        this.defensa = defensa;
        this.danio = danio;
        this.intel = intel;
        this.sigilo = sigilo;
        this.x = x;
        this.y = y;
    }

    public String getNombre(){ ;
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getClase(){
        return clase;
    }
    public void setClase(String clase){
        this.clase = clase;
    }
    public int getVidaMax(){
        return vidaMax;
    }
    public void setVida(int vidaMax){
        this.vidaMax = vidaMax;
    }
    public int getVidaTemp(){
        return vidaTemp;
    }
    public void setVidaTemp(int vidaTemp){
        this.vidaTemp = vidaTemp;
    }
    public int getDefensa(){
        return defensa;
    }
    public void setDefensa(int defensa){
        this.defensa = defensa;
    }
    public int getDanio(){
        return danio;
    }
    public void setDanio(int danio){
        this.danio = danio;
    }
    public int getIntel(){
        return intel;
    }
    public void setIntel(int intel){
        this.intel = intel;
    }
    public int getNivel(){
        return nivel;
    }
    public void setNivel(int nivel){
        this.nivel = nivel;
    }
    public int getExp(){
        return exp;
    }
    public void setExp(int exp){
        this.exp = exp;
    }

    public int getSigilo(){ return sigilo; }
    public void setSigilo(){ this.sigilo = sigilo; }
    public int getX(){ return x; }
    public void setX(int x){ this.x = x; }
    public int getY(){ return y; }
    public void setY(int y){ this.y = y; }
    public String toString()
    {
        return new StringBuffer(" Nombre: ")
            .append(this.nombre)
            .append(" Clase: ")
            .append(this.clase)
            .append(" Nivel: ")
            .append(this.nivel)
            .append(" Exp: ")
            .append(this.exp)
            .append(" VidaMax: ")
            .append(this.vidaMax)
            .append(" VidaTemp: ")
            .append(this.vidaTemp)
            .append(" Defensa: ")
            .append(this.defensa)
            .append(" Danio: ")
            .append(this.danio)
            .append(" Intel: ")
            .append(this.intel)
            .append(" Sigilo: ")
            .append(this.sigilo)
            .append(" x-coor: ")
            .append(this.x)
            .append(" y-coor: ")
            .append(this.y).toString();
    }
}
