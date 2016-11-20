public class Zebulon extends Enemigo
{
	public Zebulon(String nombre, int vida, int defensa, int danio, int nivel)
	{
		super(nombre, vida, defensa, danio, nivel);
	}

	public String atacar(Heroe heroe){
		String texto;

		if(heroe.getVidaTemp() > heroe.getVidaMax()/2){
			heroe.setVidaTemp(heroe.getVidaTemp() + heroe.getDefensa() - (getDanio()+ 5));
			texto = "Te ha atacado un Zebulon con charge";
		}
		else{
			heroe.setVidaTemp(heroe.getVidaTemp() + heroe.getDefensa() - getDanio());
		}
		texto = "Te ha atacado un Zebulon";
		return texto;
	}

	public String xpDada(Heroe heroe){
		String texto = "";

		if(getVida() <= 0){
			heroe.setExp(heroe.getExp() + 20*getNivel());
			int xp = heroe.getExp() + 20*getNivel();
			texto = "Has matado un Zebulon! te da "+xp+" puntos de experiencia";
		}
		return texto;
	}
}
