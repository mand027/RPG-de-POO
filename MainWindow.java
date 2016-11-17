import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
		topRight = new JPanel();
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
		bottomLeft.add(usar);
		bottomLeft.add(recoger);
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
		for(int x=1; x<5; x++){
			for(int i=0; i<20 ; i ++){
				JLabel map2 = new JLabel("[_______________]");
				topRight.add(map2);
			}
		}

	}

	// private void run()
	// {
	// 	log.setText("*HISTORIA* INTRODUCCION");
	// 	log.setText("Nivel 1");
	//
	// }

	private class AtacarListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if (event.getActionCommand().equals("E"))
			{
				log.setText("Nivel 1");
				atacar.setText("Atacar");
				usar.setText("Usar");
				recoger.setText("Recoger");
				arriba.setText("arriba");
				abajo.setText("abajo");
				izq.setText("<");
				derecha.setText(">");
				atacar.setActionCommand("A");


			}
		}
	}
}
