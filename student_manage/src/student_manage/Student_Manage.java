package student_manage;

import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class Student_Manage extends JFrame{

	/* where button is placed. It's convenience
	 * to use static and create main function which to be
	 * an inner class.
	*/

	private static final long serialVersionUID = 1L;
	private static JPanel panel;
	private JButton add_button, delete_button;
	JTextField student_ID =new JTextField(15); // the size of the input box
	JTextField student_name =new JTextField(15);
	MYSQL_Open open;

	public Student_Manage(MYSQL_Open open){
		super("This is a student manage system, yeah!!");
		this.open =open;
		panel = new JPanel();
		panel.setLayout(new GridLayout(4,2));
		add_button = new JButton("add");
		delete_button = new JButton("delete");

		/* Two buttons share the same monitor.
		 * It cannot perform well when the program is complex.(use lots of it-else)
		 */

		myJframe_listener listener = new myJframe_listener();
		add_button.addActionListener(listener);
		clean_button.addActionListener(listener);

		//add the button in the user-interface
		panel.add(new JLabel("student's ID: "));
		panel.add(student_ID);
		panel.add(new JLabel("Student's name: "));
		panel.add(student_name);
		panel.add(add_button);   
		panel.add(clean_button);

		this.getContentPane().add(panel);
		this.pack(); 
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.out.println(open);
				}
			});

	}

	/*Each button is spied by different monitor
	*Still cannot understand how it work. :(
	-add_button.addActionListener(
	-	new ActionListener(){
	-		public void actionPerformed(ActionEvent e){
	-			//some method you want it to do.
	-		}
	-	}
	-)
	-
	-clean_button.addActionListener(
	-	public void actionPerformed(ActionEvent e){
	-		//some method you want it to do.
	-	}
	-)
	*/

	// create inner class so that it can spy all the change and get the private value directly
	private class myJframe_listener implements ActionListener{

		public void actionPerformed(ActionEvent e){

			if(e.getSource() == add_button){

				open.setData_IntoSQL(Integer.parseInt(student_ID.getText()), student_name.getText());

			}
				else if(e.getSource() == delete_button){

					System.out.println("Got it, I will clean the interface");
				}
		}
	}

	/*
	-	public static void main(String[] args){
	-
	-	myJframe my = new myJframe();
	-	frame = new JFrame("myJframe");
	-
	-	frame.addWindowListener(new WindowAdapter() {
	-		public void windowClosing(WindowEvent e){
	-			System.exit(0);
	-			}
	-		});
	-	frame.getContentPane().add(panel);
	-	frame.pack(); 
	-	frame.setVisible(true);
	} 
	*/
}