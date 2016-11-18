public class Cartacus extends Enemigo
{
	public Cartacus(String nombre, int vida, int defensa, int danio, int nivel)
	{
		super(nombre, vida, defensa, danio, nivel);
	}

	public String Atacar(Enemigo enemigo, Heroe heroe){
		String texto;

		if(heroe.getVidaTemp() < heroe.getVidaMax()/4){
			heroe.setVidaTemp(heroe.getVidaTemp() - (enemigo.getDanio()*2));
			texto = "Te ha atacado un Caractus con mordida";
		}
		else{
			heroe.setVidaTemp(heroe.getVidaTemp() - enemigo.getDanio());
		}
		texto = "Te ha atacado un caractus";
		return texto;
	}

	public String xpDada(Heroe heroe, Enemigo enemigo){
		String texto = "";

		if(enemigo.getVida() <= 0){
			heroe.setExp(heroe.getExp() + 35*enemigo.getNivel());
			int xp = heroe.getExp() + 35*enemigo.getNivel();
			texto = "Has matado un Cartacus! te da "+xp+" puntos de experiencia";
		}
		return texto;
	}
}
