import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;
import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TriangleClassifierInterface extends JFrame {
	private final String SETTINGS_FILE = "settings.txt";
	private JButton btnClassify;
	private JTextField txtAngleA;
	private JTextField txtAngleB;
	private JTextField txtAngleC;
	private JLabel lblAngleA;
	private JLabel lblAngleB;
	private JLabel lblAngleC;
	private JTextField txtOutput;
	private JLabel lblTriangleClassifier;
	private JLabel lblAngleAWarning;
	private JLabel lblAngleBWarning;
	private JLabel lblAngleCWarning;

	private Settings settings = new Settings();
	private JButton btnSettings;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TriangleClassifierInterface frame = new TriangleClassifierInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TriangleClassifierInterface() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				this_WindowClosing(arg0);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 221, 229);
		JPanel contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnClassify = new JButton("Classify");
		btnClassify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnClassify_MouseClicked(arg0);
			}
		});
		btnClassify.setBounds(10, 123, 152, 23);
		contentPane.add(btnClassify);

		txtAngleA = new JTextField();
		txtAngleA.setBounds(76, 33, 86, 20);
		contentPane.add(txtAngleA);
		txtAngleA.setColumns(10);
		txtAngleA.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent documentEvent){
				setControls();
			}
			public void insertUpdate(DocumentEvent documentEvent){
				setControls();
			}
			public void removeUpdate(DocumentEvent documentEvent){
				setControls();
			}
		});
		txtAngleB = new JTextField();
		txtAngleB.setBounds(76, 64, 86, 20);
		contentPane.add(txtAngleB);
		txtAngleB.setColumns(10);
		txtAngleB.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent documentEvent){
				setControls();
			}
			public void insertUpdate(DocumentEvent documentEvent){
				setControls();
			}
			public void removeUpdate(DocumentEvent documentEvent){
				setControls();
			}
		});
		txtAngleC = new JTextField();
		txtAngleC.setBounds(76, 95, 86, 20);
		contentPane.add(txtAngleC);
		txtAngleC.setColumns(10);
		txtAngleC.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent documentEvent){
				setControls();
			}
			public void insertUpdate(DocumentEvent documentEvent){
				setControls();
			}
			public void removeUpdate(DocumentEvent documentEvent){
				setControls();
			}
		});
		lblAngleA = new JLabel("Angle A:");
		lblAngleA.setForeground(Color.WHITE);
		lblAngleA.setBounds(10, 36, 66, 14);
		contentPane.add(lblAngleA);

		lblAngleB = new JLabel("Angle B:");
		lblAngleB.setForeground(Color.WHITE);
		lblAngleB.setBounds(10, 67, 66, 14);
		contentPane.add(lblAngleB);

		lblAngleC = new JLabel("Angle C:");
		lblAngleC.setForeground(Color.WHITE);
		lblAngleC.setBounds(10, 98, 66, 14);
		contentPane.add(lblAngleC);

		txtOutput = new JTextField();
		txtOutput.setEditable(false);
		txtOutput.setBounds(10, 151, 152, 29);
		contentPane.add(txtOutput);
		txtOutput.setColumns(10);

		lblTriangleClassifier = new JLabel("Triangle Classifier");
		lblTriangleClassifier.setForeground(Color.WHITE);
		lblTriangleClassifier.setBounds(10, 11, 185, 14);
		contentPane.add(lblTriangleClassifier);
		
		lblAngleAWarning = new JLabel(UIManager.getIcon("OptionPane.warningIcon"));
		lblAngleAWarning.setBounds(173, 33, 32, 32);
		lblAngleAWarning.setToolTipText("Angle is not valid");
		contentPane.add(lblAngleAWarning);
		
		lblAngleBWarning = new JLabel(UIManager.getIcon("OptionPane.warningIcon"));
		lblAngleBWarning.setBounds(172, 64, 32, 32);
		lblAngleBWarning.setToolTipText("Angle is not valid");
		contentPane.add(lblAngleBWarning);
		
		lblAngleCWarning = new JLabel(UIManager.getIcon("OptionPane.warningIcon"));
		lblAngleCWarning.setBounds(172, 95, 32, 32);
		lblAngleCWarning.setToolTipText("Angle is not valid");
		contentPane.add(lblAngleCWarning);
		
		btnSettings = new JButton("");
		btnSettings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnSettings_MouseClicked(arg0);
			}
		});
		btnSettings.setForeground(Color.WHITE);
		btnSettings.setBackground(Color.WHITE);
		btnSettings.setBounds(171, 156, 24, 24);
		btnSettings.setIcon(new ImageIcon("res/" + "settingsIcon.png"));
		contentPane.add(btnSettings);

		Serializer s = new Serializer();
		try {
			settings = (Settings)s.deserialize(SETTINGS_FILE);
			if (settings == null) {
				throw new Exception();
			}
		} catch (Exception e) {
			settings = new Settings();
		}
		
		setControls();
	}
	private void setControls(){
		
		System.out.println("setcontrols");
		
		if (settings.getLocale() == Locale.FRENCH) {
			this.lblAngleA.setText("Angle A");
			this.lblAngleB.setText("Angle B");
			this.lblAngleC.setText("Angle C");
			this.lblAngleAWarning.setText("L'angle n'est pas valide");
			this.lblAngleBWarning.setText("L'angle n'est pas valide");
			this.lblAngleCWarning.setText("L'angle n'est pas valide");
			this.btnClassify.setText("Calculer");
			this.lblTriangleClassifier.setText("Classificateur des Triangles");
		}else if (settings.getLocale() == Locale.GERMAN) {
			this.lblAngleA.setText("Winkel A");
			this.lblAngleB.setText("Winkel B");
			this.lblAngleC.setText("Winkel C");
			this.lblAngleAWarning.setText("Winkel ist nicht gültig");
			this.lblAngleBWarning.setText("Das is bad");
			this.lblAngleCWarning.setText("Winkel ist nicht gültig");
			this.btnClassify.setText("Berechnung");
			this.lblTriangleClassifier.setText("Dreiecks-Klassifikator");
		}else{
			this.lblAngleA.setText("Angle A");
			this.lblAngleB.setText("Angle B");
			this.lblAngleC.setText("Angle C");
			this.lblAngleAWarning.setText("Angle is not valid");
			this.lblAngleBWarning.setText("Angle is not valid");
			this.lblAngleCWarning.setText("Angle is not valid");
			this.btnClassify.setText("Calculate");
			this.lblTriangleClassifier.setText("Triangle Classifier");
		}

		boolean allInputProvided = false;

		boolean angleANotNumerical = false;
		boolean angleBNotNumerical = false;
		boolean angleCNotNumerical = false;

		try {
			angleANotNumerical = (Integer.valueOf(this.txtAngleA.getText(), 10) == 0);
		} catch (NumberFormatException e) {
			angleANotNumerical = true;
			e.printStackTrace();
		}
		try {
			angleBNotNumerical = (Integer.valueOf(this.txtAngleB.getText(), 10) == 0);
		} catch (NumberFormatException e) {
			angleBNotNumerical = true;
			e.printStackTrace();
		}
		try {
			angleCNotNumerical = (Integer.valueOf(this.txtAngleC.getText(), 10) == 0);
		} catch (NumberFormatException e) {
			angleCNotNumerical = true;
			e.printStackTrace();
		}

		boolean angleANotGiven = this.txtAngleA.getText().equals("");
		boolean angleBNotGiven = this.txtAngleB.getText().equals("");
		boolean angleCNotGiven = this.txtAngleC.getText().equals("");
		
		this.lblAngleAWarning.setVisible(angleANotGiven == false && angleANotNumerical);
		this.lblAngleBWarning.setVisible(angleBNotGiven == false && angleBNotNumerical);
		this.lblAngleCWarning.setVisible(angleCNotGiven == false && angleCNotNumerical);
		
		allInputProvided = ((angleANotNumerical == false) && (angleBNotNumerical == false) && (angleCNotNumerical == false));

		this.btnClassify.setEnabled(allInputProvided);


	}

	protected void btnClassify_MouseClicked(MouseEvent arg0) {

		if (this.btnClassify.isEnabled() == false) {
			return;
		}
		
		//Input
 
		int angleA = Integer.parseInt(this.txtAngleA.getText());
		int angleB = Integer.parseInt(this.txtAngleB.getText());
		int angleC = Integer.parseInt(this.txtAngleC.getText());

		//Processing

		TriangleClassifier tc = new TriangleClassifier();
		String output = tc.getClassification(angleA, angleB, angleC);

		//Output

		if (output.equals("INVALID")){
			if (settings.getLocale() == Locale.ENGLISH) {
				JOptionPane.showMessageDialog(this, "Your Triangle is Invalid!",
						"INVALID", JOptionPane.WARNING_MESSAGE);
				this.txtOutput.setText(""); 
			}else if (settings.getLocale() == Locale.FRENCH) {
				JOptionPane.showMessageDialog(this, "Votre triangle est invalide!",
						"INVALIDE", JOptionPane.WARNING_MESSAGE);
				this.txtOutput.setText("");
			}else{
				JOptionPane.showMessageDialog(this, "Dein Dreieck ist ungültig!",
						"Ungültig", JOptionPane.WARNING_MESSAGE);
				this.txtOutput.setText("");
			}
		}else{
			if (settings.getLocale() == Locale.GERMAN) {
				if (output.equals("equilateral")) {
					this.txtOutput.setText("gleichseitig");
				}else if (output.equals("right scalene")) {
					this.txtOutput.setText("rechte Scalene");
				}else if (output.equals("right isosceles")) {
					this.txtOutput.setText("rechts gleichschenklig");
				}else if (output.equals("obtuse scalene")) {
					this.txtOutput.setText("stumpfes Scalen");
				}else if (output.equals("obtuse isosceles")) {
					this.txtOutput.setText("stumpfe gleichschenklige");
				}else if (output.equals("acute scalene")) {
					this.txtOutput.setText("akutes Scalen");
				}else if (output.equals("acute isosceles")) {
					this.txtOutput.setText("akute Isozelen");
				}else{
					this.txtOutput.setText("ERROR");
				};
			}else if (settings.getLocale() == Locale.FRENCH) {
				if (output.equals("equilateral")) {
					this.txtOutput.setText("équilatéral");
				}else if (output.equals("right scalene")) {
					this.txtOutput.setText("scalène droit");
				}else if (output.equals("right isosceles")) {
					this.txtOutput.setText("isosceles à droite");
				}else if (output.equals("obtuse scalene")) {
					this.txtOutput.setText("scalène obtus");
				}else if (output.equals("obtuse isosceles")) {
					this.txtOutput.setText("obésité isocèle");
				}else if (output.equals("acute scalene")) {
					this.txtOutput.setText("scalène aigu");
				}else if (output.equals("acute isosceles")) {
					this.txtOutput.setText("isocèle aiguë");
				}else{
					this.txtOutput.setText("ERROR");
				}
			}else{
				this.txtOutput.setText(output);
			}
		}}
	protected void btnSettings_MouseClicked(MouseEvent arg0) {
		
		SettingsDialog settingsDialog = new SettingsDialog();
		settingsDialog.setLocationRelativeTo(this);
		settingsDialog.setModalityType(ModalityType.APPLICATION_MODAL);
		settingsDialog.setLocale(settings.getLocale());
		settingsDialog.setVisible(true);
		
		if (settingsDialog.isOk()) {
			settings.setLocale(settingsDialog.getLocale());
			setControls();
		}
	}
	protected void this_WindowClosing(WindowEvent arg0) {
		Serializer s = new Serializer();
		try {
			s.serialize(settings, SETTINGS_FILE);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
