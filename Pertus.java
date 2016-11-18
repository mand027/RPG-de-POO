public class Pertus extends Enemigo
{
	public String Atacar(Enemigo enemigo, Heroe heroe){
		String texto;

		heroe.setVidaTemp(heroe.getVidaTemp() - enemigo.getDanio());
		texto = "Te ha atacado un Pertus";

		if(enemigo.getVida() < 20){
			enemigo.setVida(0);
			texto = " El Pertus ha escapado";
		}
		return texto;
	}
}
