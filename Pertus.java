public class Pertus extends Enemigo
{
	public String Atacar(Enemigo enemigo, Heroe heroe){
		String texto;

		heroe.setVidaTemp(heroe.getVidaTemp() - enemigo.getDanio());
		texto = "Te ha atacado "+enemigo.getNombre();

		if(enemigo.getVida() < 20){
			enemigo.setVida(0);
			texto = " El "+enemigo.getNombre()+" ha escapado";
		}
		return texto;
	}
}