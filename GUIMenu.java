import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GUIMenu
{
	private JFrame frame;
	public static void main (String[] args)
	{
		GUIMenu gui = new GUIMenu();
		gui.start();
	}
	public void start()
	{
		frame = new JFrame("Pizza App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = frame.getContentPane();
		
		makeMenus();
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	private void makeMenus()
	{
		JMenuBar menuBar;
		JMenu orderMenu;
		//JMenu helpMenu;
		JMenuItem menuItem;
		
		menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        		
		//set up the order Menu
		orderMenu = new JMenu("File");
		orderMenu.setMnemonic(KeyEvent.VK_O); //adds hotkey shortcut to Order menu
        
       
        	//add order menu items below
        	menuItem = new JMenuItem("New Order"); //tells program that Order has a new item, "New Order"
        	menuItem.setMnemonic(KeyEvent.VK_N); //tells program that Alt + N will activate New menu item
        	menuItem.addActionListener(new newListener());//adds action listener and tells it which class to reference
        	menuItem.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_N,Event.CTRL_MASK)); //sets keyboard shortcut to use CTRL + N to use the New Order option 
        	orderMenu.add(menuItem); //adds "New Order" to the options in the File menu
        

        	menuItem = new JMenuItem("Save Order");
        	menuItem.setMnemonic(KeyEvent.VK_S);
        	menuItem.addActionListener(new saveListener());
        	menuItem.setAccelerator(
        			KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));
        	orderMenu.add(menuItem);

        	orderMenu.addSeparator();

        	menuItem = new JMenuItem("Exit");
        	menuItem.setMnemonic(KeyEvent.VK_X);
        	menuItem.addActionListener(new exitListener());
        	menuItem.setAccelerator(
        			KeyStroke.getKeyStroke(KeyEvent.VK_Q, Event.CTRL_MASK));
        	orderMenu.add(menuItem);
         menuBar.add(orderMenu);//adds file menu to menu bar
		
        
       
	}
	
	private class newListener implements ActionListener //program listens for click on New menu option
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(frame, 
				"The File > New Order menu option was clicked.",
				"Menu Item Click",
				JOptionPane.INFORMATION_MESSAGE);
		}
	}
	

	private class saveListener implements ActionListener //program listens for click on Save menu option
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(frame, 
					"The File > Save Order menu option was clicked",
					"Menu Item Click",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private class exitListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0); //does not return with dialog box, but exits program
		}
	}

}