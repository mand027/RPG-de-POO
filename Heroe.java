public class Heroe implements Movimiento
 {
	private int vida, defensa, danio, vel;
	private int intel, nivel, exp;

	public Heroe() { }

	public int getVida(){ return vida; }
	public void setVida(int vida){ this.vida = vida; }
	public int getDefensa(){ return defensa; }
	public void setDefensa(int defensa){ this.defensa = defensa; }
	public int getDanio(){ return danio; }
	public void setDanio(int danio){ this.danio = danio; }
	public int getVel(int vel){ return vel; }
	public void setVel(int vel){ this.vel = vel; }
	public int getIntel(){ return intel; }
	public void setIntel(int intel){ this.intel = intel; }
	public int getNivel(){ return nivel; }
	public void setNivel(int nivel){ this.nivel = nivel; }
	public int getExp(){ return exp; }
	public void setExp(int exp){ this.exp = exp; }

	public void atacar()
	{

	}
	public void atacar(String mensaje){
		
	}
  public void  izquierda(){

  }
  public void  adelante(){
  }
  public void atras(){
  }
  public void  derecha(){
  }

	public void levelup()
	{
		nivel++;
	}
}
