import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Locale;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SettingsDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JRadioButton optEnglish;
	private JRadioButton optFrench;
	private JRadioButton optGerman;
	private ButtonGroup buttonGroup;
	private Locale locale = Locale.ENGLISH;
	private boolean ok = false;

	public boolean isOk() {
		return ok;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SettingsDialog dialog = new SettingsDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SettingsDialog() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				this_WindowOpened(arg0);
			}
			@Override
			public void windowClosed(WindowEvent e) {
				this_WindowClosed(e);
			}
		});
		setBackground(Color.BLUE);
		setBounds(100, 100, 157, 172);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLUE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		optEnglish = new JRadioButton("English");
		optEnglish.setForeground(Color.WHITE);
		optEnglish.setBackground(Color.BLUE);
		optEnglish.setBounds(16, 7, 109, 23);
		contentPanel.add(optEnglish);
		
		optFrench = new JRadioButton("Français");
		optFrench.setBackground(Color.BLUE);
		optFrench.setForeground(Color.WHITE);
		optFrench.setBounds(16, 33, 109, 23);
		contentPanel.add(optFrench);
		{
			optGerman = new JRadioButton("Deutsche");
			optGerman.setForeground(Color.WHITE);
			optGerman.setBackground(Color.BLUE);
			optGerman.setBounds(16, 59, 109, 23);
			contentPanel.add(optGerman);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.BLUE);
			buttonPane.setForeground(Color.BLUE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						okButton_MouseClicked(arg0);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						cancelButton_MouseClicked(e);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		buttonGroup = new ButtonGroup();
		buttonGroup.add(this.optEnglish);
		buttonGroup.add(this.optFrench);
		buttonGroup.add(this.optGerman);
	}
	
	protected void this_WindowOpened(WindowEvent arg0) {
		if (this.locale == Locale.ENGLISH) {
			this.optEnglish.setSelected(true);
		}else if (this.locale == Locale.FRENCH) {
			this.optFrench.setSelected(true);
		}else{
			this.optGerman.setSelected(true);
		}
	}
	protected void this_WindowClosed(WindowEvent e) {
		if (this.ok) {
			if (this.optEnglish.isSelected()) {
				this.locale = Locale.ENGLISH;
			}else if (this.optFrench.isSelected()) {
				this.locale = Locale.FRENCH;
			}else {
				this.locale = Locale.GERMAN;
			}
	}}
	protected void okButton_MouseClicked(MouseEvent arg0) {
		this.ok = true;
		this.setVisible(false);
		this_WindowClosed(null);
	}
	protected void cancelButton_MouseClicked(MouseEvent e) {
		this.ok = false;
		this.setVisible(false);
		this_WindowClosed(null);
	}
}
