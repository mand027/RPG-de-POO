public class SaliodelMapa extends Exception{
  private String error1="No puedes moverte en esta direccion, supera los limites del mapa";
  public SaliodelMapa(String error1){
    super (error1);

  }
}
