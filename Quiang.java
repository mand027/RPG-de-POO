public class Quiang extends Enemigo
{
	public String Atacar(Enemigo enemigo, Heroe heroe){
		String texto;

		if(heroe.getVidaTemp() < heroe.getVidaMax()/3){
			heroe.setVidaTemp(heroe.getVidaTemp() - (enemigo.getDanio()*2));
			texto = "Te ha atacado un Quiang con embestida";
		}
		else{
			heroe.setVidaTemp(heroe.getVidaTemp() - enemigo.getDanio());
		}
		texto = "Te ha mordido un Quiang";
		return texto;
	}
	public String xpDada(Heroe heroe, Enemigo enemigo){
		String texto = "";

		if(enemigo.getVida() <= 0){
			heroe.setExp(heroe.getExp() + 25*enemigo.getNivel());
			int xp = heroe.getExp() + 25*enemigo.getNivel();
			texto = "Has matado un Quiang! te da "+xp+" puntos de experiencia";
		}
		return texto;
	}
}
