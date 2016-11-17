public class ArmaPrincipal extends Item
{
	private int rareza, danio;

	public ArmaPrincipal(String nombre){
		super(nombre);
	}

	public int getDanio(){
		return danio;
		}
	public void setDanio(int danio){
		this.danio = danio;
		}
}
