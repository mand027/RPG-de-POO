import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JFrame
{
	private JPanel topLeft, topRight, bottomLeft, bottomRight;
	private JButton atacar, usar, recoger, arriba, abajo, izq, derecha;

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
		topRight = new JPanel();
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
			for(int x=1; x<5; x++){
		for(int i=0; i<20 ; i ++){
			JLabel map2 = new JLabel("[_______________]");
			topRight.add(map2);
			}
		}
	}
}
