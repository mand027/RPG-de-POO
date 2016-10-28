public class Mapa {
	private int largo;
	private int ancho;
	private int[][] numeroDeCasilla;
	private double probDeCaja;
	private boolean casillaExplorada;
	
	public Mapa(){ }
	
	public int getLargo(){
		return largo; 
	}
	public void setLargo(int largo){
		this.largo = largo;
	}
	public int getAncho(){
		return ancho;
	}
	public void setAncho(int ancho){
		this.ancho = ancho;
	}
	public double getProbDeCaja(){
		return probDeCaja; 
	}
	public void setProbDeCaja(double probDeCaja){
		this.probDeCaja = probDeCaja; 
	}
	
	public boolean getCasillaExplorada(){
		return casillaExplorada;
	}
	
	public void setCasillaExplorada(boolean casillaExplorada){
		this.casillaExplorada = casillaExplorada;
	}
	
	public int[][] getNumeroDeCasilla(){
		return numeroDeCasilla;
	}
	
	public void setNumeroDeCasilla(int[][]  numeroDeCasilla){
		this.numeroDeCasilla = numeroDeCasilla;
	}
	
}
