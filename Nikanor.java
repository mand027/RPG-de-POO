public class Nikanor extends Enemigo
{
	public Nikanor(String nombre, int vida, int defensa, int danio, int nivel)
	{
		super(nombre, vida, defensa, danio, nivel);
	}

	public String Atacar(Enemigo enemigo, Heroe heroe){
		String texto;
		boolean lanza=true;

		if(lanza == true){
			heroe.setVidaTemp(heroe.getVidaTemp() + heroe.getDefensa() - (enemigo.getDanio()*3));
			texto = "Te ha atacado un Nikanor con lanza";
			lanza = false;
		}
		else{
			heroe.setVidaTemp(heroe.getVidaTemp() + heroe.getDefensa() - enemigo.getDanio());
		}
		texto = "Te ha atacado con piedras un Nikanor";
		return texto;
	}

	public String xpDada(Heroe heroe, Enemigo enemigo){
		String texto = "";

		if(enemigo.getVida() <= 0){
			heroe.setExp(heroe.getExp() + 30*enemigo.getNivel());
			int xp = heroe.getExp() + 30*enemigo.getNivel();
			texto = "Has matado un Nikanor! te da "+xp+" puntos de experiencia";
		}
		return texto;
	}
}
