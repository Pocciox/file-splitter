package fileSplitter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The Class that handles the choosing of an output directory for the splitting
 * and stitching processes.
 */
public class OutputDirChooser extends JPanel implements ActionListener {

	/** The title of the component. */
	protected JLabel title;

	/** The button you click to choose the directory. */
	protected JButton chooseDirButton;

	/** The label that displays the path you selected.. */
	protected JLabel output;

	/** The actual path chooser. */
	protected JFileChooser chooser;

	/** The chosen directory. */
	protected File chosenDir;

	/**
	 * Instantiates a new output directory chooser by creating the title label, the
	 * button and the output label and adding the actionlistener for the click.
	 */
	OutputDirChooser() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		output = new JLabel();
		title = new JLabel("Scegli La Cartella Di Output");
		chooseDirButton = new JButton("Scegli");
		chooseDirButton.addActionListener(this);
		add(title);
		add(chooseDirButton);
		add(output);

		chooser = new JFileChooser();
		this.chosenDir = this.chooser.getCurrentDirectory();
		output.setText(this.chosenDir.getPath());

	}

	/**
	 * Event handler for click on the button. Opens the window where the user can
	 * choose a folder.
	 *
	 * @param e the event. Currently unused
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		chooser.setAcceptAllFileFilterUsed(false);

		if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {

			this.chosenDir = chooser.getSelectedFile();
			output.setText(this.chosenDir.getPath());
		} else {
			System.out.println("No Selection ");
		}
	}

}