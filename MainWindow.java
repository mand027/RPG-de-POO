import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class MainWindow extends JFrame
{
	// private String nombreHeroe;
	// private String tipoHeroe;
	private Heroe heroe;
	private Inventario inventario;
	private JPanel topLeft, topRight, bottomLeft, bottomRight;
	private JButton atacar, usar, recoger, arriba, abajo, izq, derecha;
	private JLabel nombre, clase, vida, nivel, experiencia, defensa, danio, intel, sigilo, municion, armaPrincipal, armaSecundaria, log;

	public MainWindow(String nombreHeroe, String tipoHeroe)
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
		inventario = new Inventario(new ArmaPrincipal("Rifle Termico"), new ArmaSecundaria("Cuchillo"), new Salud(0), new Municion(50));
		setTitle("Horizons 1336");
		setSize(1280, 720);
		setLayout(new GridLayout(2, 2));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
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

		nombre = new JLabel("Nombre: " + heroe.getNombre());
		bottomRight.add(nombre);
		clase = new JLabel("Clase: " + heroe.getClase());
		bottomRight.add(clase);
		nivel = new JLabel("Nivel: " + heroe.getNivel());
		bottomRight.add(nivel);
		experiencia = new JLabel("Exp: " + heroe.getExp());
		bottomRight.add(experiencia);
		vida = new JLabel("Vida: " + heroe.getVidaTemp());
		bottomRight.add(vida);
		defensa = new JLabel("Defensa: " + heroe.getDefensa());
		bottomRight.add(defensa);
		danio = new JLabel("Danio: " + heroe.getDanio());
		bottomRight.add(danio);
		intel = new JLabel("Inteligencia: " + heroe.getIntel());
		bottomRight.add(intel);
		if(heroe.getClase().equals("Spec Ops"))
		{
			sigilo = new JLabel("Sigilo: " + ((Specops)heroe).getSigilo());
			bottomRight.add(sigilo);
		}
		municion = new JLabel("Municion: " + ((Municion)inventario.getItems()[3]).getNumero());
		bottomRight.add(municion);
		armaPrincipal = new JLabel("A1: " + inventario.getItems()[0].getNombre());
		bottomRight.add(armaPrincipal);
		armaSecundaria = new JLabel("A2: " + inventario.getItems()[1].getNombre());
		bottomRight.add(armaSecundaria);
		// inventario = new JLabel(Inventario);
		// bottomLeft.add(inventario);
		log = new JLabel("*HISTORIA* INTRODUCCION");
		topLeft.add(log);

		// Botones
		atacar = new JButton("Entrar");
		atacar.setActionCommand("E");
		atacar.addActionListener(new AtacarListener());
		usar = new JButton("    ");
		recoger = new JButton("    ");
		arriba = new JButton("    ");
		abajo = new JButton("    ");
		izq  = new JButton("   ");
		derecha = new JButton("    ");
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

		//Mapa
		limpiarMapa();

	}

	public void limpiarMapa(){
		for(int x=0; x < 5; x++){
			for(int y=0; y < 20 ; y++){
				JPanel panel = new JPanel();
				// JButton casillaMapa = new JButton("");
				if (x == 0 && y == 0)
				{
					// casillaMapa.setText("");
					panel.setBackground(Color.red);
				}
				else
				{
					// casillaMapa.setText("");
					panel.setBackground(Color.green);
				}
				panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				// label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				// panel.add(casillaMapa);
				topRight.add(panel);
			}
		}
	}

	private void runLevel()
	{
		Random r = new Random();
		Enemigo enemigo;
		atacar.setText("Atacar");
		usar.setText("Usar");
		recoger.setText("");
		arriba.setText("");
		abajo.setText("");
		izq.setText("");
		derecha.setText("");
		atacar.setActionCommand("A");
		// if (casilla100){
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
				enemigo = new Enemigo("no", 0, 0, 0, 0);
				break;
			default:
				enemigo = new Enemigo("no", 0, 0, 0, 0);
				break;
		}
		log.setText("<html><p>Nivel 1</p><p>Ha aparecido un " + enemigo.getNombre() + "</p></html>");

	}

	private class AtacarListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if (event.getActionCommand().equals("E"))
			{
				runLevel();
			}
		}
	}


}
