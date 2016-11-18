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
		texto = "Te ha mordido un Quiang"();
		return texto;
	}
}
