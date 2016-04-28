package mvc;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;

public class ViewTimeTable extends JFrame implements Observer  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private JFrame frame;


	private Model model;
	private JTextField textFieldCaricaFile;
	private JTable table;
	private JButton buttonNewOrario;
	private JButton buttonCaricaOrario;
	private JButton buttonBrowse;
	private JButton buttonGeneraDaCaricato;
	
	public ViewTimeTable(Model model) {
		
		
		this.setModel(model);
		initUI();

		
		
		// View as observer of model
		model.addObserver(this);

		// Init view like model
		initViewLikeModel();

	}

	private void initViewLikeModel() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initUI() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buttonNewOrario = new JButton("Nuovo orario");
		
		buttonCaricaOrario = new JButton("Carica orario");
		
		textFieldCaricaFile = new JTextField();
		textFieldCaricaFile.setColumns(10);
		
		buttonBrowse = new JButton("Browse");
		
		buttonGeneraDaCaricato = new JButton("Genera nuovo da caricato");
		
		table = new JTable();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addComponent(buttonNewOrario, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addComponent(buttonCaricaOrario, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addGap(128)
					.addComponent(textFieldCaricaFile, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(22)
					.addComponent(buttonBrowse, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(156)
					.addComponent(buttonGeneraDaCaricato, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 684, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addComponent(buttonNewOrario)
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(buttonCaricaOrario)
						.addComponent(textFieldCaricaFile, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonBrowse))
					.addGap(55)
					.addComponent(buttonGeneraDaCaricato)
					.addGap(61)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
	
	public void clearUserInput() {
		textFieldCaricaFile.setText("");
	}

	public void appendUserInput(String line) {
		//textFieldCaricaFile.append(line);
		//textFieldCaricaFile.setCaretPosition(textFieldCaricaFile.getDocument().getLength());
		
	}



	public void pressButtonNewOrario(ActionListener listener) {
		buttonNewOrario.addActionListener(listener);
	}
	
	
	public void addLoadFromFileListener(ActionListener listener) {
		buttonBrowse.addActionListener(listener);
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
