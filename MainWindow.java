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
					this.heroe = new Specops(nombreHeroe, tipoHeroe, 1, 0, 150, 2, 15, 3, 1);
					break;
				case "Techno":
					this.heroe = new Techno(nombreHeroe, tipoHeroe, 1, 0, 140, 1, 10, 6);
					break;
				case "Veteran":
					this.heroe = new Veteran(nombreHeroe, tipoHeroe, 1, 0, 180, 4, 20, 2);
					break;
			}
		}
		else
		{

			deserializeHeroe();// crear heroe con file
		}
		inventario = new Inventario(new ArmaPrincipal("Rifle Termico"), new ArmaSecundaria("Cuchillo"), new Pocion(), new Municion(50));
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
		log = new JLabel("En el año 2136 la humanidad, después de haber colonizado el sistema Sol ha comenzado a expandir su imperio galáctico, cuando encuentran en el sistema estelar más cercano un planeta terrano llamado New Haven por los humanos. Éstos deciden enviar un pequeño escuadrón de reconocimiento pero al llegar se dieron cuenta que el planeta estaba habitado por una especie inteligente que estaba en una etapa tribal. Esta atacó al escuadrón dejando a solo un sobreviviente, este deberá luchar para llegar a la nave de evacuación que está resguardada por el rey guerrero de la tribu. Para lograrlo deberás mejorar tus habilidades y conseguir mejores armas que se pidieron como refuerzo durante la emboscada de la tribu nativa. Pero esa tribu no es el único peligro, el planeta está habitado por formas de vida hostiles que no dudaran en atacar.");
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
		pocionSalud.setText("#Pociones: " + ((Pocion)inventario.getItems()[2]).getCantidad());
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
		if (heroe.getX() == 4 && heroe.getY() == 19)
		{
			enemigo = new Boss("Boss", 1+heroe.getNivel()*50, 1, 10, heroe.getNivel()+1, 0, 0);
			// TODO: Cambiar stats del boss. nombre > vida > defensa > danio > nivel > sigilo > intel
		}
		else
		{
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
		}
		updateLog("Ha aparecido un " + enemigo.getNombre());

		// Principales
		if(heroe.getX() == 2 && heroe.getY() == 3){
			if( inventario.getItems()[0].getNombre().equals("Rifle de Antimateria") ){
				log.setText("encontraste el rifle de plasma pero al tener el de antimateria lo ignoras");
			}
			else{
				((ArmaPrincipal)inventario.getItems()[0]).setDanio(6);
				inventario.getItems()[0].setNombre("Rifle de Plasma");
				log.setText("Has encontrado el rifle de plasma, se equipa automaticamente");
			}
		}

		if(heroe.getX() == 4 && heroe.getY() == 17){
			((ArmaPrincipal)inventario.getItems()[0]).setDanio(12);
			inventario.getItems()[0].setNombre("Rifle de Antimateria");
			log.setText("Has encontrado el Rifle de Antimateria, se equipa automaticamente");
		}

		//Secundarias
		if(heroe.getX() == 1 && heroe.getY() == 10){
			if( inventario.getItems()[1].getNombre().equals("Sable Tribal") ){
				log.setText("encontraste el Cuchillo Calorico pero al tener el Sable Tribal lo ignoras");
			}
			else{
				((ArmaSecundaria)inventario.getItems()[1]).setDanio(3);
				inventario.getItems()[1].setNombre("Cuchillo Calorico");
				log.setText("Has encontrado el Cuchillo Calorico, se equipa automaticamente");
			}
		}

		if(heroe.getX() == 3 && heroe.getY() == 18){
			((ArmaPrincipal)inventario.getItems()[1]).setDanio(7);
			inventario.getItems()[1].setNombre("Sable Tribal");
			log.setText("Has encontrado el Sable Tribal, se equipa automaticamente");
		}
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
						updateLog(heroe.subirDeNivel());
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
				// FIXME: pocion deberia de ser un contador
				if (((Pocion)inventario.getItems()[2]).getCantidad() > 0)
				{
					heroe.setVidaTemp(heroe.getVidaMax());
					inventario.usarPocion();
				}
				updateInfo();
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
