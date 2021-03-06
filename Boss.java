public class Boss extends Enemigo
{
	private int sigilo, intel;

	public Boss(String nombre, int vida, int defensa, int danio, int nivel, int sigilo, int intel)
	{
		super(nombre, vida, defensa, danio, nivel);
		this.sigilo = sigilo;
		this.intel = intel;
	}


	public int getSigilo(){ return sigilo; }
	public void setSigilo(int sigilo){ this.sigilo = sigilo; }
	public int getIntel(){ return intel; }
	public void setIntel(){ this.intel = intel; }

	public String atacar(Heroe heroe){
		String texto;

		if(heroe.getVidaTemp() > getVida()){
			heroe.setVidaTemp(heroe.getVidaTemp() - (getDanio()*4));
			texto = "Te ha atacado el Boss con su ataque supremo";
		}
		else{
			heroe.setVidaTemp(heroe.getVidaTemp() + heroe.getDefensa() - getDanio());
		}
		texto = "Te ha atacado el Boss";
		return texto;
	}

	public String xpDada(Heroe heroe){
		String texto = "";

		if(getVida() <= 0){
			heroe.setExp(heroe.getExp() + 100*getNivel());
			int xp = heroe.getExp() + 100*getNivel();
			texto = "Has matado al Boss! te da "+xp+" puntos de experiencia";
		}
		return texto;
	}
}
