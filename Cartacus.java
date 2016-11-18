public class Cartacus extends Enemigo
{
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
}
