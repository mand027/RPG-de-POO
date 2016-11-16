public class ArmaSecundaria extends Item
{
	private int rareza, danio;

	public ArmaSecundaria(String nombre, int danio)
	{
		super(nombre);
		this.danio = danio;
	}

	public int getRareza(){ return rareza; }
	public void setRareza(int rareza){ this.rareza = rareza; }
	public int getDanio(){ return danio; }
	public void setDanio(int danio){ this.danio = danio; }
}
