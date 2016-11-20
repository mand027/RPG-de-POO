public class Nikanor extends Enemigo
{
	public Nikanor(String nombre, int vida, int defensa, int danio, int nivel)
	{
		super(nombre, vida, defensa, danio, nivel);
	}

	public String atacar(Heroe heroe){
		String texto;
		boolean lanza=true;

		if(lanza == true){
			heroe.setVidaTemp(heroe.getVidaTemp() + heroe.getDefensa() - (getDanio()*3));
			texto = "Te ha atacado un Nikanor con lanza";
			lanza = false;
		}
		else{
			heroe.setVidaTemp(heroe.getVidaTemp() + heroe.getDefensa() - getDanio());
		}
		texto = "Te ha atacado con piedras un Nikanor";
		return texto;
	}

	public String xpDada(Heroe heroe){
		String texto = "";

		if(getVida() <= 0){
			heroe.setExp(heroe.getExp() + 30*getNivel());
			int xp = heroe.getExp() + 30*getNivel();
			texto = "Has matado un Nikanor! te da "+xp+" puntos de experiencia";
		}
		return texto;
	}
}
