public class ArmaPrincipal extends Item
{
	private int rareza, danio;

	public ArmaPrincipal(String nombre)
	{
		super(nombre);
	}

	public int getRareza(){ return rareza; }
	public void setRareza(int rareza){ this.rareza = rareza; }
	public int getDanio(){ return danio; }
	public void setDanio(int danio){ this.danio = danio; }
}
