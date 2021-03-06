public abstract class Heroe implements Movimiento
 {
	private int vidaMax, vidaTemp, defensa, danio, intel, nivel, exp;
    private String nombre, clase;
    private int x;
    private int y;

	public Heroe(String nombre, String clase, int nivel, int exp, int vidaMax, int defensa, int danio, int intel)
    {
        this.nombre = nombre;
        this.clase = clase;
        this.nivel = nivel;
        this.exp = exp;
        this.vidaMax = vidaMax;
        this.vidaTemp = vidaMax;
        this.defensa = defensa;
        this.danio = danio;
        this.intel = intel;
        x = 0;
        y = 0;
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

    public int getX(){
        return x;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getY(){
        return y;
    }

    public void setY(int y){
        this.y = y;
    }

    public abstract String atacar(Enemigo enemigo, Inventario inventario);

    public void horizontal (int x) throws SaliodelMapaException
    {
        if ((this.x + x) < 0 || (this.x + x) > 4)
        {
            throw new SaliodelMapaException();
        }
        else
        {
            this.x += x;
        }
    }

    public void vertical(int y) throws SaliodelMapaException
    {
        if ((this.y + y) < 0 || (this.y + y) > 19)
        {
            throw new SaliodelMapaException();
        }
        else
        {
            this.y += y;
        }
    }

    public String subirDeNivel(){
		String texto = "";
		return texto;
    }
}
