package mvc;

import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ViewOrario extends JFrame implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private JFrame frame;
	

	private JTextArea textLoad;
	private JTable table;
	private JButton buttonNewOrario;
	private JButton buttonLoadOrario;
	private JButton buttonBrowse;
	private JButton buttonGeneraOrario;
	private JButton buttonSave;
	
	private Model model;



	/**
	 * Create the application.
	 */
	public ViewOrario(Model model) {
		
		this.setModel(model);
		initUIOrario();
		
		model.addObserver(this);
		
		initViewLikeModel();


		
	}
	
	
	
	public void addLoadFromFileListener(ActionListener listener) {
		// TODO Auto-generated method stub
		buttonBrowse.addActionListener(listener);

		
	}

	private void initViewLikeModel() {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initUIOrario() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buttonNewOrario = new JButton("Nuovo orario");
		
		buttonLoadOrario = new JButton("Carica orario");
		
		textLoad = new JTextArea();
		textLoad.setColumns(10);
		
		buttonBrowse = new JButton("Browse");
		
		buttonGeneraOrario = new JButton("Genera nuovo da caricato");
		
		table = new JTable();
		
		buttonSave = new JButton("Salva");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(60)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(buttonSave)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(table, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(buttonLoadOrario)
								.addGap(93)
								.addComponent(textLoad, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
								.addGap(37)
								.addComponent(buttonBrowse))
							.addComponent(buttonNewOrario)
							.addComponent(buttonGeneraOrario, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap(269, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addComponent(buttonNewOrario)
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(buttonLoadOrario)
						.addComponent(textLoad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonBrowse))
					.addGap(52)
					.addComponent(buttonGeneraOrario)
					.addGap(72)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
					.addComponent(buttonSave)
					.addGap(28))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	public void clearUserInput() {
		textLoad.setText("");
	}

	public void appendUserInput(String line) {
		textLoad.append(line);
		textLoad.setCaretPosition(textLoad.getDocument().getLength());
		
	}



	
}
