public class Specops extends Heroe
{
	private int sigilo;

	public Specops(String nombre, String clase, int nivel, int exp, int vidaMax, int defensa, int danio, int intel, int sigilo)
    {
        super(nombre, clase, nivel, exp, vidaMax, defensa, danio, intel);
		this.sigilo = sigilo;
    }

	public void stealth()
	{

	}

	public int getSigilo(){ return sigilo; }
	public void setSigilo(){ this.sigilo = sigilo; }
}
