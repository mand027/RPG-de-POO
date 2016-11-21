public class Pocion extends Item
{
    private int cantidad;

    public Pocion()
    {
        cantidad = 0;
    }

    public int getCantidad(){ return cantidad; }
    public void setCantidad(int cantidad){ this.cantidad = cantidad; }

}
