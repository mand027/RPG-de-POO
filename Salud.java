public class Salud extends Item
{
	private String nombre;
	private int cura;

	public Salud(){ }

	public String getNombre(){ return nombre; }
	public void setNombre(String nombre){ this.nombre = nombre; }
	public int getCura(){ return cura; }
	public void setCura(int cura){ this.cura = cura; }
}