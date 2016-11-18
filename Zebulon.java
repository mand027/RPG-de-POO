public class Zebulon extends Enemigo
{
	public Zebulon(String nombre, int vida, int defensa, int danio, int nivel)
	{
		super(nombre, vida, defensa, danio, nivel);
	}

	public String Atacar(Enemigo enemigo, Heroe heroe){
		String texto;

		if(heroe.getVidaTemp() > heroe.getVidaMax()/2){
			heroe.setVidaTemp(heroe.getVidaTemp() - (enemigo.getDanio()+ 5));
			texto = "Te ha atacado un Zebulon con charge";
		}
		else{
			heroe.setVidaTemp(heroe.getVidaTemp() - enemigo.getDanio());
		}
		texto = "Te ha atacado un Zebulon";
		return texto;
	}

	public String xpDada(Heroe heroe, Enemigo enemigo){
		String texto = "";

		if(enemigo.getVida() <= 0){
			heroe.setExp(heroe.getExp() + 20*enemigo.getNivel());
			int xp = heroe.getExp() + 20*enemigo.getNivel();
			texto = "Has matado un Zebulon! te da "+xp+" puntos de experiencia";
		}
		return texto;
	}
}
