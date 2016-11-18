public class Boss extends Enemigo
{
	private int sigilo, intel;

	public Boss(){ }

	public int getSigilo(){ return sigilo; }
	public void setSigilo(int sigilo){ this.sigilo = sigilo; }
	public int getIntel(){ return intel; }
	public void setIntel(){ this.intel = intel; }

	public String Atacar(Enemigo enemigo, Heroe heroe){
		String texto;

		if(heroe.getVidaTemp() > enemigo.getVida()){
			heroe.setVidaTemp(heroe.getVidaTemp() - (enemigo.getDanio()*3));
			texto = "Te ha atacado el Boss con su ataque supremo";
		}
		else{
			heroe.setVidaTemp(heroe.getVidaTemp() - enemigo.getDanio());
		}
		texto = "Te ha atacado el Boss";
		return texto;
	}
}