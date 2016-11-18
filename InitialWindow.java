import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InitialWindow extends JFrame
{
    private JLabel nombreL;
    private JTextField nombreTF;
    private JLabel queHeroe;
    private JButton specops, techno, veteran;

    public InitialWindow()
    {
        setSize(1290, 340);
        setTitle("Bienvenido");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        init();
        setVisible(true);
    }

    public void init()
    {
        nombreL = new JLabel("Nombre:");
        nombreTF = new JTextField(15);
        queHeroe = new JLabel("Escoje un heroe");
        specops = new JButton("Spec Ops");
        specops.addActionListener(new StartListener());
        specops.setActionCommand("Spec Ops");
        techno = new JButton("Techno");
        techno.addActionListener(new StartListener());
        techno.setActionCommand("Techno");
        veteran = new JButton("Veteran");
        veteran.addActionListener(new StartListener());
        veteran.setActionCommand("Veteran");
        add(nombreL);
        add(nombreTF);
        add(queHeroe);
        add(specops);
        add(techno);
        add(veteran);
    }

    private class StartListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if (nombreTF.getText().equals(""))
            {
                nombreL.setText("Nombre (obligatorio)");
            }
            else
            {
                setVisible(false);
                new MainWindow(nombreTF.getText(), event.getActionCommand());
            }
        }
    }
}
