public abstract class Enemigo
{
	private int vida, defensa, danio, nivel;
	private String nombre;

	public Enemigo(String nombre, int vida, int defensa, int danio, int nivel)
	{
		this.nombre = nombre;
		this.vida = vida;
		this.defensa = defensa;
		this.danio = danio;
		this.nivel = nivel;
	}

	public int getVida(){
		return vida;
	}
	public void setVida(int vida){
		this.vida = vida;
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
	public int getNivel(){
		return nivel;
	}
	public void setNivel(int nivel){
		this.nivel = nivel;
	}
	public String getNombre(){ return nombre; }
	public void setNombre(String nombre){ this.nombre = nombre; }

	public abstract String atacar(Heroe heroe);

	public abstract String xpDada(Heroe heroe);

	public void itemTirado(){

	}
}
