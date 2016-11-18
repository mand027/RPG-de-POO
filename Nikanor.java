public class Nikanor extends Enemigo
{
	public String Atacar(Enemigo enemigo, Heroe heroe){
		String texto;
		boolean lanza=true;

		if(lanza == true){
			heroe.setVidaTemp(heroe.getVidaTemp() - (enemigo.getDanio()*3));
			texto = "Te ha atacado un Nikanor con lanza";
			lanza = false;
		}
		else{
			heroe.setVidaTemp(heroe.getVidaTemp() - enemigo.getDanio());
		}
		texto = "Te ha atacado con piedras un Nikanor";
		return texto;
	}
}
