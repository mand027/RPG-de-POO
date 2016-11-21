import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class LoadSaveWindow extends JFrame
{
    private JButton newB, loadB;

    public LoadSaveWindow()
    {
        setTitle("Bienvenido");
        setLayout(new GridLayout(1,2));
        setSize(1290, 340);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init();
        setVisible(true);
    }

    private void init()
    {
        newB = new JButton("NEW GAME");
        newB.addActionListener(new BotonListener());
        newB.setActionCommand("N");
        loadB = new JButton("No File");
        if (deserializeHeroe() != null)
        {
            loadB.setText("LOAD");
            loadB.addActionListener(new BotonListener());
            loadB.setActionCommand("L");
        }
        JPanel panel1 = new JPanel();
        panel1.add(newB);
        JPanel panel2 = new JPanel();
        panel2.add(loadB);
        add(panel1);
        add(panel2);
    }

    public SaveObject deserializeHeroe()
	{
		SaveObject saveObject;
		try
		{
			FileInputStream fin = new FileInputStream("./saveFile.hor");
			ObjectInputStream ois = new ObjectInputStream(fin);
			saveObject = (SaveObject) ois.readObject();
			ois.close();
			return saveObject;
		}
		catch(Exception e)
		{
			e.printStackTrace();
            System.out.println("null object");
			return null;
		}
	}

    private class BotonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if (event.getActionCommand().equals("N"))
            {
                new InitialWindow();
            }
            else
            {
                new MainWindow("", "", false);
            }
        }
    }
}
