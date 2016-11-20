public class Cartacus extends Enemigo
{
	public Cartacus(String nombre, int vida, int defensa, int danio, int nivel)
	{
		super(nombre, vida, defensa, danio, nivel);
	}

	public String atacar(Heroe heroe){
		String texto;

		if(heroe.getVidaTemp() < heroe.getVidaMax()/4){
			heroe.setVidaTemp(heroe.getVidaTemp() + heroe.getDefensa() - (getDanio()*2));
			texto = "Te ha atacado un Caractus con mordida";
		}
		else{
			heroe.setVidaTemp(heroe.getVidaTemp() + heroe.getDefensa() - getDanio());
		}
		texto = "Te ha atacado un caractus";
		return texto;
	}

	public String xpDada(Heroe heroe){
		String texto = "";

		if(getVida() <= 0){
			heroe.setExp(heroe.getExp() + 35*getNivel());
			int xp = heroe.getExp() + 35*getNivel();
			texto = "Has matado un Cartacus! te da "+xp+" puntos de experiencia";
		}
		return texto;
	}
}
