public class Veteran extends Heroe{
	private String texto;

	public Veteran(String nombre, String clase, int nivel, int exp, int vidaMax, int defensa, int danio, int intel){
        super(nombre, clase, nivel, exp, vidaMax, defensa, danio, intel);
    }

	public String atacar(Enemigo enemigo, Inventario inventario){
		if(((Municion)inventario.getItems()[3]).getNumero() > 0){
			enemigo.setVida(enemigo.getVida() - (getDanio() + ((ArmaPrincipal)inventario.getItems()[0]).getDanio() + getIntel()/3) + getDefensa() * 2);
			((Municion)inventario.getItems()[3]).setNumero(((Municion)inventario.getItems()[3]).getNumero() -1);
			texto = "has atacado a "+enemigo.getNombre()+" con tu "+inventario.getItems()[0].getNombre()+" usando 1 de municion";
		}
		else{
			enemigo.setVida(enemigo.getVida() - (getDanio() + ((ArmaSecundaria)inventario.getItems()[1]).getDanio() + getDanio()/3) + getDefensa() * 2);
			texto = "has atacado a "+enemigo.getNombre()+" con tu "+inventario.getItems()[1].getNombre();
		}

		return texto;
	}

	public String subirDeNivel(){
		if(getNivel()==20){
			texto="ya eres nivel maximo";
		}
		if(getExp() >= 100*getNivel() ){
			setVida(getVidaMax()+130);
			setVidaTemp(getVidaMax());
			setDanio(getDanio()+4);
			setIntel(getIntel()+1);
			setDefensa(getDefensa()+3);
			setNivel(getNivel()+1);

			texto = "Felicidades, ahore eres nivel "+getNivel();
		}

		return texto;
	}
}
