import java.util.Random;

public class Specops extends Heroe{
	private int sigilo;
	private String texto;

	public Specops(String nombre, String clase, int nivel, int exp, int vidaMax, int defensa, int danio, int intel, int sigilo){
        super(nombre, clase, nivel, exp, vidaMax, defensa, danio, intel);
		this.sigilo = sigilo;
    }

	public String Atacar(Enemigo enemigo, Heroe heroe, Inventario inventario ){
		Random rn = new Random();
	    int r = rn.nextInt(10) + 1;

		if( ((Municion)inventario.getItems()[3]).getNumero() > 0){
			if(r < 4){
				enemigo.setVida(enemigo.getVida() - ((heroe.getDanio() + ((ArmaPrincipal)inventario.getItems()[0]).getDanio() + heroe.getIntel()/3) * 3));
			}
			else{
				enemigo.setVida(enemigo.getVida() - (heroe.getDanio() + ((ArmaPrincipal)inventario.getItems()[0]).getDanio() + heroe.getIntel()/3));
			}
			((Municion)inventario.getItems()[3]).setNumero(((Municion)inventario.getItems()[3]).getNumero() -1);
			texto = "has atacado a "+enemigo.getNombre()+" con tu "+inventario.getItems()[0].getNombre()+" usando 1 de municion";
		}
		else{
			if(r < 4){
				enemigo.setVida(enemigo.getVida() - ((heroe.getDanio() + ((ArmaSecundaria)inventario.getItems()[1]).getDanio() + heroe.getDanio()/3) * 3));
			}
			else{
				enemigo.setVida(enemigo.getVida() - (heroe.getDanio() + ((ArmaSecundaria)inventario.getItems()[1]).getDanio() + heroe.getDanio()/3));
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
}
