public class Pertus extends Enemigo
{
	public Pertus(String nombre, int vida, int defensa, int danio, int nivel)
	{
		super(nombre, vida, defensa, danio, nivel);
	}

	public String Atacar(Enemigo enemigo, Heroe heroe){
		String texto;

		heroe.setVidaTemp(heroe.getVidaTemp() - enemigo.getDanio());
		texto = "Te ha atacado un Pertus";

		if(enemigo.getVida() < 20){
			enemigo.setVida(0);
			texto = " El Pertus ha escapado";
		}
		return texto;
	}

	public String xpDada(Heroe heroe, Enemigo enemigo){
		String texto = "";

		if(enemigo.getVida() <= 0){
			heroe.setExp(heroe.getExp() + 40*enemigo.getNivel());
			int xp = heroe.getExp() + 40*enemigo.getNivel();
			texto = "Has matado un Pertus! te da "+xp+" puntos de experiencia";
		}
		return texto;
	}
}
