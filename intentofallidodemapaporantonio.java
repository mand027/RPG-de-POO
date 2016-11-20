import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JFrame
{
	private JPanel topLeft, topRight, bottomLeft, bottomRight;
	private JButton atacar, usar, recoger, arriba, abajo, izq, derecha;
	private int mov1, mov2;



	public MainWindow()
	{
		setTitle("Horizons 1336");
		setSize(1280, 720);
		setLayout(new GridLayout(2, 2));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
		setVisible(true);
	}

	private void init()
	{
		topLeft = new JPanel();
		topRight = new JPanel(new GridLayout(20,5));
		bottomLeft = new JPanel(new GridLayout(4, 3));
		bottomRight = new JPanel();
		add(topLeft);
		add(topRight);
		add(bottomLeft);
		add(bottomRight);

		atacar = new JButton("Atacar");
		usar = new JButton("Usar");
		recoger = new JButton("Recoger");
		arriba = new JButton("arriba");
		abajo = new JButton("abajo");
		izq  = new JButton("<");
		derecha = new JButton(">");

		bottomLeft.add(atacar);
		bottomLeft.add(usar);
		bottomLeft.add(recoger);
		JLabel emptyBL1 = new JLabel("");
		bottomLeft.add(emptyBL1);
		bottomLeft.add(arriba);
		arriba.setActionCommand("arriba");
		arriba.addActionListener(new arribaListener());
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

	}


	private class arribaListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			heroe.setVertical(heroe.getVertical()++);
			try{
				limpiarMapa();
			}catch(SaliodelMapa e){

			}
			heroe.Vertical();
		}
	}
			//En este metodo ponemos Heroe.setHorizontal y setVertical para que mueva los
			//mueva los parametros que jala el limpiarMapa para tener la posicion exacta del
			//Heroe en ese momento, cuando se pone new game se setean los valores de Movimoento en 0
//el metodo limpiarMapa se ejecuta cuando se preciona algun listener de movimiento
//un listener para varios Botones???
			public void limpiarMapa(){
				for(int x=0; x<20; x++){
						for(int i=0; i<5; i++){
						JLabel map2 = new JLabel("[_______________]");
						topRight.add(map2);
						if (horizontal > 20 || vertical > 5){
							throw new SaliodelMapa();
						if(heroe.getVertical()==x){
							if(heroe.getHorizontal()==i){
								JLabel posicion = new JLabel("[__estas_aqui__]");
							}
						}
					}
				}
			}
		}
	}
	//Tiene que jalar los valores que tengan los Movimientos H y V para que en esos valores meta
	//la posicion y se tienen que modificar cada que se ejecuta un metodo de Movimiento
