public class Pertus extends Enemigo
{
	public Pertus(String nombre, int vida, int defensa, int danio, int nivel)
	{
		super(nombre, vida, defensa, danio, nivel);
	}

	public String atacar(Heroe heroe){
		String texto;

		heroe.setVidaTemp(heroe.getVidaTemp() + heroe.getDefensa() - getDanio());
		texto = "Te ha atacado un Pertus";

		if(getVida() < 20){
			setVida(0);
		}
		return texto;
	}

	public String xpDada(Heroe heroe){
		String texto = "";

		if(getVida() <= 0){
			heroe.setExp(heroe.getExp() + 40*getNivel());
			int xp = heroe.getExp() + 40*getNivel();
			texto = "Has escapado el Pertus! te da "+xp+" puntos de experiencia";
		}
		return texto;
	}
}
