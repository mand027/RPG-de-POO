import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.io.*;

public class MainWindow extends JFrame
{
	// private String nombreHeroe;
	// private String tipoHeroe;
	private String logNivel;
	private Heroe heroe;
	private Enemigo enemigo;
	private Item itemCaido;
	private Inventario inventario;
	private JPanel topLeft, topRight, bottomLeft, bottomRight;
	private JButton atacar, usar, arriba, abajo, izq, derecha;
	private JLabel nombre, clase, vida, nivel, experiencia, defensa, danio, intel, sigilo, armaPrincipal, armaSecundaria, pocionSalud, log;

	public MainWindow(String nombreHeroe, String tipoHeroe, boolean isNew)
	{
		if (isNew)
		{
			switch (tipoHeroe)
			{
				case "Spec Ops":
					this.heroe = new Specops(nombreHeroe, tipoHeroe, 1, 0, 100, 1, 10, 2, 1);
					break;
				case "Techno":
					this.heroe = new Techno(nombreHeroe, tipoHeroe, 1, 0, 90, 0, 5, 6);
					break;
				case "Veteran":
					this.heroe = new Veteran(nombreHeroe, tipoHeroe, 1, 0, 130, 2, 15, 0);
					break;
			}
		}
		else
		{

			deserializeHeroe();// crear heroe con file
		}
		inventario = new Inventario(new ArmaPrincipal("Rifle Termico"), new ArmaSecundaria("Cuchillo"), new Salud(0), new Municion(50));
		setTitle("Horizons 1336");
		setSize(1280, 720);
		setLayout(new GridLayout(2, 2));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
		if (!isNew)
		{
			atacar.doClick();
		}
		setVisible(true);
		//run();
	}

	private void init()
	{
		topLeft = new JPanel();
		topRight = new JPanel(new GridLayout(20, 5));
		bottomLeft = new JPanel(new GridLayout(4, 3));
		bottomRight = new JPanel(new GridLayout(12, 1));
		add(topLeft);
		add(topRight);
		add(bottomLeft);
		add(bottomRight);

		//Info
		nombre = new JLabel("");
		bottomRight.add(nombre);
		clase = new JLabel("");
		bottomRight.add(clase);
		nivel = new JLabel("");
		bottomRight.add(nivel);
		experiencia = new JLabel("");
		bottomRight.add(experiencia);
		vida = new JLabel("");
		bottomRight.add(vida);
		defensa = new JLabel("");
		bottomRight.add(defensa);
		danio = new JLabel("");
		bottomRight.add(danio);
		intel = new JLabel("");
		bottomRight.add(intel);
		if(heroe.getClase().equals("Spec Ops"))
		{
			sigilo = new JLabel("");
			bottomRight.add(sigilo);
		}
		armaPrincipal = new JLabel("");
		bottomRight.add(armaPrincipal);
		armaSecundaria = new JLabel("");
		bottomRight.add(armaSecundaria);
		pocionSalud = new JLabel("");
		bottomRight.add(pocionSalud);

		// Botones
		atacar = new JButton("Entrar");
		atacar.setActionCommand("E");
		atacar.addActionListener(new AtacarListener());
		usar = new JButton("    ");
		usar.addActionListener(new PocionListener());
		arriba = new JButton("    ");
		arriba.addActionListener(new MoverListener());
		arriba.setActionCommand("U");
		abajo = new JButton("    ");
		abajo.addActionListener(new MoverListener());
		abajo.setActionCommand("D");
		izq  = new JButton("   ");
		izq.addActionListener(new MoverListener());
		izq.setActionCommand("L");
		derecha = new JButton("    ");
		derecha.addActionListener(new MoverListener());
		derecha.setActionCommand("R");
		bottomLeft.add(atacar);
		JLabel empty = new JLabel("");
		bottomLeft.add(empty);
		bottomLeft.add(usar);
		JLabel emptyBL1 = new JLabel("");
		bottomLeft.add(emptyBL1);
		bottomLeft.add(arriba);
		JLabel emptyBL2 = new JLabel("");
		bottomLeft.add(emptyBL2);
		bottomLeft.add(izq);
		JLabel emptyBL3 = new JLabel("");
		bottomLeft.add(emptyBL3);
		bottomLeft.add(derecha);
		JLabel emptyBL4 = new JLabel("");
		bottomLeft.add(emptyBL4);
		bottomLeft.add(abajo);
		JLabel emptyBL5 = new JLabel("");
		bottomLeft.add(emptyBL5);

		//Intro
		log = new JLabel("*HISTORIA* INTRODUCCION");
		topLeft.add(log);

	}

	public void serializeHeroe(Heroe heroe, int x, int y)
	{
		SaveObject saveObject;
		if (heroe.getClase().equals("Spec Ops"))
		{
			saveObject = new SaveObject(heroe.getNombre(), heroe.getClase(), heroe.getNivel(), heroe.getExp(),
			 							heroe.getVidaMax(), heroe.getVidaTemp(), heroe.getDefensa(), heroe.getDanio(), heroe.getIntel(), ((Specops)heroe).getSigilo(), x, y);
		}
		else
		{
			saveObject = new SaveObject(heroe.getNombre(), heroe.getClase(), heroe.getNivel(), heroe.getExp(),
			 							heroe.getVidaMax(), heroe.getVidaTemp(), heroe.getDefensa(), heroe.getDanio(), heroe.getIntel(), 0, x, y);
		}
		try
		{
			FileOutputStream fout = new FileOutputStream("./saveFile.hor");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(saveObject);
			oos.close();
			updateLog("Juego guardado...");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void deserializeHeroe()
	{
		SaveObject saveObject;
		try
		{
			FileInputStream fin = new FileInputStream("./saveFile.hor");
			ObjectInputStream ois = new ObjectInputStream(fin);
			saveObject = (SaveObject) ois.readObject();
			ois.close();
			switch (saveObject.getClase())
			{
				case "Spec Ops":
					this.heroe = new Specops(saveObject.getNombre(), saveObject.getClase(), saveObject.getNivel(), saveObject.getExp(),
					 							saveObject.getVidaMax(), saveObject.getDefensa(), saveObject.getDanio(), saveObject.getIntel(), saveObject.getSigilo());
					break;
				case "Techno":
					this.heroe = new Techno(saveObject.getNombre(), saveObject.getClase(), saveObject.getNivel(), saveObject.getExp(),
					 							saveObject.getVidaMax(), saveObject.getDefensa(), saveObject.getDanio(), saveObject.getIntel());
					break;
				case "Veteran":
					this.heroe = new Veteran(saveObject.getNombre(), saveObject.getClase(), saveObject.getNivel(), saveObject.getExp(),
					 							saveObject.getVidaMax(), saveObject.getDefensa(), saveObject.getDanio(), saveObject.getIntel());
					break;
			}
			heroe.setVidaTemp(saveObject.getVidaTemp());
			heroe.setX(saveObject.getX());
			heroe.setY(saveObject.getY());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void limpiarMapa(){
		topRight.removeAll();
		logNivel = "";
		int casillaActual = (heroe.getX() + 1 ) + (heroe.getY() * 5);
		updateLog("Casilla: " + casillaActual);
		for(int y=0; y < 20; y++){
			for(int x=0; x < 5 ; x++){
				JPanel panel = new JPanel();
				if (x == heroe.getX() && y == heroe.getY())
				{
					panel.setBackground(Color.red);
				}
				else
				{
					panel.setBackground(Color.green);
				}
				panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				topRight.add(panel);
			}
		}
	}

	public void updateInfo()
	{
		nombre.setText("Nombre: " + heroe.getNombre());
		clase.setText("Clase: " + heroe.getClase());
		nivel.setText("Nivel: " + heroe.getNivel());
		experiencia.setText("Exp: " + heroe.getExp());
		vida.setText("Vida: " + heroe.getVidaTemp());
		defensa.setText("Defensa: " + heroe.getDefensa());
		danio.setText("Danio: " + heroe.getDanio());
		intel.setText("Inteligencia: " + heroe.getIntel());
		if(heroe.getClase().equals("Spec Ops"))
		{
			sigilo.setText("Sigilo: " + ((Specops)heroe).getSigilo());
		}
		armaPrincipal.setText("A1: " + inventario.getItems()[0].getNombre() + "  Municion: " + ((Municion)inventario.getItems()[3]).getNumero());
		armaSecundaria.setText("A2: " + inventario.getItems()[1].getNombre());
		pocionSalud.setText("Pocion de Salud: " + ((Salud)inventario.getItems()[2]).getCura());
	}

	private void runLevel()
	{
		Random r = new Random();
		atacar.setText("Atacar");
		atacar.setActionCommand("A");
		usar.setText("Pocion");
		usar.setActionCommand("P");
		arriba.setText("");
		arriba.setActionCommand("none");
		abajo.setText("");
		abajo.setActionCommand("none");
		izq.setText("");
		izq.setActionCommand("none");
		derecha.setText("");
		derecha.setActionCommand("none");
		// 	if (casilla100){
		// 	enemigo > boss
		// }
		// else lo de abajo
		switch (r.nextInt(12))
		{
			case 0:
			case 1:
			case 2:
				enemigo = new Cartacus("Cartacus", heroe.getNivel()*50, 1, 10, heroe.getNivel());
				break;
			case 3:
			case 4:
			case 5:
			case 6:
				enemigo = new Nikanor("Nikanor", heroe.getNivel()*100, 0, 5, heroe.getNivel());
				break;
			case 7:
				enemigo = new Zebulon("Zebulon", heroe.getNivel()*110, 2, 15, heroe.getNivel());
				break;
			case 8:
			case 9:
				enemigo = new Quiang("Quiang", heroe.getNivel()*150, 2, 7, heroe.getNivel());
				break;
			case 10:
				enemigo = new Pertus("Pertus", heroe.getNivel()*75, 0, 20, heroe.getNivel());
				break;
			case 11:
				// enemigo = new Enemigo("no", 0, 0, 0, 0);
				break;
			default:
				// enemigo = new Enemigo("no", 0, 0, 0, 0);
				break;
		}
		updateLog("Ha aparecido un " + enemigo.getNombre());
		// TODO: aqui va la creacion del item que aparece en ese nivel
		// itemCaido == algo; sugerencia con switch;

	}

	private void updateLog(String line)
	{
		logNivel = "<p>" + line + "</p>" + logNivel;
		log.setText("<html>" + logNivel + "</html>");
	}

	private void gameOver()
	{
		topRight.removeAll();
		bottomLeft.removeAll();
		bottomRight.removeAll();
		log.setText("Haz muerto, Reinicia el juego");
	}

	private class AtacarListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if (event.getActionCommand().equals("E"))
			{
				//Mapa
				limpiarMapa();
				updateInfo();
				runLevel();
			}
			else
			{
				// TODO: aqui va el while
				while (enemigo.getVida() > 0 && heroe.getVidaTemp() > 0)
				{
					updateLog(heroe.atacar(enemigo, inventario));
					if (enemigo.getVida() > 0)
					{
						updateLog(enemigo.atacar(heroe));
					}
					else
					{
						updateLog("Derrostaste a: " + enemigo.getNombre());
					}
					if (heroe.getVidaTemp() <= 0){ gameOver(); }
					updateInfo();
				}

				// Cuando termina el while
				// TODO: recoger el itemCaido que se creo;

				arriba.setText("arriba");
				arriba.setActionCommand("U");
				abajo.setText("abajo");
				abajo.setActionCommand("D");
				izq.setText("<");
				izq.setActionCommand("L");
				derecha.setText(">");
				derecha.setActionCommand("R");
			}
		}
	}

	private class PocionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if (event.getActionCommand().equals("P"))
			{
				// TODO: modificar la salud del heroe;
			}
		}
	}

	private class MoverListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
				switch (event.getActionCommand())
				{
					case "U":
						heroe.vertical(-1);
						break;
					case "D":
						heroe.vertical(1);
						break;
					case "L":
						heroe.horizontal(-1);
						break;
					case "R":
						heroe.horizontal(1);
						break;
					default:

						break;
				}
				limpiarMapa();
				runLevel();
				serializeHeroe(heroe, heroe.getX(), heroe.getY());
				System.out.println("Saved game.");
			}
			catch (SaliodelMapaException e)
			{
				updateLog("No te puedes salir del mapa");
			}
		}
	}


}
