public class Salud extends Item
{
	private int cura;

	public Salud(int cura)
	{
		this.cura = cura;
	}

	public int getCura(){ return cura; }
	public void setCura(int cura){ this.cura = cura; }
}
