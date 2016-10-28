public class Inventario
{
	// Cinco slots para armaprincipal, secundaria, 
	// salud, municionprincipal y municionsecundaria.
	private Item[] items; 

	public Inventario()
	{
		items = new Item[5];	
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

	public void usar()
	{

	}
}