import java.util.Random;

public class Specops extends Heroe{
	private int sigilo;
	private String texto;

	public Specops(String nombre, String clase, int nivel, int exp, int vidaMax, int defensa, int danio, int intel, int sigilo){
        super(nombre, clase, nivel, exp, vidaMax, defensa, danio, intel);
		this.sigilo = sigilo;
    }

	public String atacar(Enemigo enemigo, Inventario inventario ){
		Random rn = new Random();
	    int r = rn.nextInt(10) + 1;

		if( ((Municion)inventario.getItems()[3]).getNumero() > 0){
			if(r < 4){
				enemigo.setVida(enemigo.getVida() - ((getDanio() + ((ArmaPrincipal)inventario.getItems()[0]).getDanio() + getIntel()/3) * 3));
			}
			else{
				enemigo.setVida(enemigo.getVida() - (getDanio() + ((ArmaPrincipal)inventario.getItems()[0]).getDanio() + getIntel()/3));
			}
			((Municion)inventario.getItems()[3]).setNumero(((Municion)inventario.getItems()[3]).getNumero() -1);
			texto = "has atacado a "+enemigo.getNombre()+" con tu "+inventario.getItems()[0].getNombre()+" usando 1 de municion";
		}
		else{
			if(r < 4){
				enemigo.setVida(enemigo.getVida() - ((getDanio() + ((ArmaSecundaria)inventario.getItems()[1]).getDanio() + getDanio()/3) * 3));
			}
			else{
				enemigo.setVida(enemigo.getVida() - (getDanio() + ((ArmaSecundaria)inventario.getItems()[1]).getDanio() + getDanio()/3));
			}
			texto = "has atacado a "+enemigo.getNombre()+" con tu "+inventario.getItems()[1].getNombre();
		}
		return texto;
	}

	public int getSigilo(){
		return sigilo;
	}
	public void setSigilo(){
		this.sigilo = sigilo;
	}

	public String subirDeNivel(){
		if(getNivel()==20){
			texto="ya eres nivel maximo";
		}
		if(getExp() >= 100*getNivel() ){
			setVida(getVidaMax()+100);
			setVidaTemp(getVidaMax());
			setDanio(getDanio()+3);
			setIntel(getIntel()+2);
			sigilo = getSigilo()+3;
			setDefensa(getDefensa()+1);
			setNivel(getNivel()+1);

			texto = "Felicidades, ahore eres nivel "+getNivel();
		}

		return texto;
	}
}
