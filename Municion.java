public class Municion extends Item
{
	// no se si lo necesitamos si lo ponemos en un array private int tipo;
	private int numero;

	public Municion(int numero)
	{
		this.numero = numero;
	}

	public int getNumero(){ return numero; }
	public void setNumero(int numero){ this.numero = numero; }

	public void shoot()
	{
		numero -= 1;
	}
}
