package student_manage;

import javax.swing.*;

public class Demo{
	public static JFrame frame;
	public static void main(String[] args) throws ClassNotFoundException{
		MYSQL_Open open = new MYSQL_Open();
		Student_Manage manage = new Student_Manage(open);
	} 
}