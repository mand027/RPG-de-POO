public class Quiang extends Enemigo
{
	public Quiang(String nombre, int vida, int defensa, int danio, int nivel)
	{
		super(nombre, vida, defensa, danio, nivel);
	}

	public String atacar(Heroe heroe){
		String texto;

		if(heroe.getVidaTemp() < heroe.getVidaMax()/6){
			heroe.setVidaTemp(heroe.getVidaTemp() + heroe.getDefensa() - (getDanio()*2));
			texto = "Te ha atacado un Quiang con embestida";
		}
		else{
			heroe.setVidaTemp(heroe.getVidaTemp() + heroe.getDefensa() - getDanio());
		}
		texto = "Te ha mordido un Quiang";
		return texto;
	}
	public String xpDada(Heroe heroe){
		String texto = "";

		if(getVida() <= 0){
			heroe.setExp(heroe.getExp() + 25*getNivel());
			int xp = heroe.getExp() + 25*getNivel();
			texto = "Has matado un Quiang! te da "+xp+" puntos de experiencia";
		}
		return texto;
	}
}
