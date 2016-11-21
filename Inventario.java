public class Inventario
{
	// Cinco slots para armaprincipal, secundaria,
	// salud, municionprincipal y municionsecundaria.
	private Item[] items;

	public Inventario(ArmaPrincipal armaPrincipal, ArmaSecundaria armaSecundaria, Pocion pocion, Municion municionPrincipal)
	{
		items = new Item[4];
		items[0] = armaPrincipal;
		items[1] = armaSecundaria;
		items[2] = pocion;
		items[3] = municionPrincipal;
	}

	public Item[] getItems(){ return items; }
	public void setItems(Item[] items){ this.items = items; }

	public void addItem(Item item, int index)
	{
		items[index] = item;
	}

	public void removeItem(int index)
	{
		items[index] = null;
	}

	public void recogerPocion()
	{
		((Pocion)items[2]).setCantidad(((Pocion)items[2]).getCantidad() + 1);
	}
	public void usarPocion()
	{
		((Pocion)items[2]).setCantidad(((Pocion)items[2]).getCantidad() - 1);
	}
}
