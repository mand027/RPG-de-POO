public class ArmaPrincipal extends Item
{
	private int rareza, danio;
	private String nombre;

	public ArmaPrincipal(){ }
	
	public int getRareza(){ return rareza; }
	public void setRareza(int rareza){ this.rareza = rareza; }
	public int getDanio(){ return danio; }
	public void setDanio(int danio){ this.danio = danio; }
	public String getNombre(){ return nombre; }
	public void setNombre(String nombre){ this. nombre = nombre; }
}