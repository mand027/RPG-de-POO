public class Quiang extends Enemigo
{
	public String Atacar(Enemigo enemigo, Heroe heroe){
		String texto;

		if(heroe.getVidaTemp() < heroe.getVidaMax()/3){
			heroe.setVidaTemp(heroe.getVidaTemp() - (enemigo.getDanio()*2));
			texto = "Te ha atacado "+enemigo.getNombre()+" con embestida";
		}
		else{
			heroe.setVidaTemp(heroe.getVidaTemp() - enemigo.getDanio());
		}
		texto = "Te ha atacado "+enemigo.getNombre();
		return texto;
	}
}