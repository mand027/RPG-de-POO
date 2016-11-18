public class Zebulon extends Enemigo
{
	public String Atacar(Enemigo enemigo, Heroe heroe){
		String texto;

		if(heroe.getVidaTemp() > heroe.getVidaMax()/2){
			heroe.setVidaTemp(heroe.getVidaTemp() - (enemigo.getDanio()+ 5));
			texto = "Te ha atacado "+enemigo.getNombre()+" con charge";
		}
		else{
			heroe.setVidaTemp(heroe.getVidaTemp() - enemigo.getDanio());
		}
		texto = "Te ha atacado "+enemigo.getNombre();
		return texto;
	}
}