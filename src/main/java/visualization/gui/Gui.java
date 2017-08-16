package visualization.gui;



import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.graphstream.ui.view.View;

import scheduler.graphstructures.DefaultDirectedWeightedGraph;
import visualization.Visualizer;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class Gui {
	protected Visualizer _visualizer;
	public JFrame frame;
	protected JPanel _cards;
	protected JPanel _graphPage;
	private JPanel panel;

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] agrs) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		 UIManager.setLookAndFeel(
		            UIManager.getSystemLookAndFeelClassName());
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Gui window = new Gui(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui(Visualizer DAG) {
		_visualizer = DAG;
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 850, 580);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(30, 15, 600, 500);
		frame.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		_cards = new JPanel(new CardLayout());
		panel.add(_cards);
		_cards.setPreferredSize(new Dimension(600,500));
		
		_graphPage = new GraphPage(_visualizer);
		_graphPage.setPreferredSize(new Dimension(600,530));
		_cards.add(_graphPage, "name_3915657358581");
		
		JButton btnNewButton = new JButton("Tree Graph");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnNewButton.setBounds(741, 20, 133, 45);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnGanttChart = new JButton("Gantt Chart");
		btnGanttChart.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnGanttChart.setBounds(741, 76, 133, 45);
		frame.getContentPane().add(btnGanttChart);
		
		JButton btnClose = new JButton("Close");
		btnClose.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnClose.setBounds(741, 505, 133, 45);
		frame.getContentPane().add(btnClose);
		
	}
	
	public void updateGraphGui(){
		_graphPage.revalidate();
		_graphPage.repaint();
		
	}
}

