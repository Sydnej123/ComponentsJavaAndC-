

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
public class Formularz extends JComponent implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FileOutputStream fos = null;
	private ObjectOutputStream oos = null;
	private ArrayList<String> dane =new ArrayList<String>();
	private JPanel panel;
	private JLabel label;
	private JPanel panel_1;
	private JTextField textField;
	private JLabel label_2;
	private JTextField textField_1;
	private JLabel label_3;
	private JTextField textField_2;
	private JLabel label_4;
	private JTextField textField_3;
	private JLabel label_1;
	private JPanel panel_2;
	private JButton button;
	private JButton button_1;
	private Component horizontalStrut;
	private Component horizontalStrut_1;
	private Component horizontalStrut_2;
	private Component horizontalStrut_3;
	private Component horizontalStrut_4;
	private Component horizontalStrut_5;
	private Component horizontalStrut_6;
	private Component horizontalStrut_7;
	
		
		public Formularz() throws IOException, ClassNotFoundException {
			super();
			
			
			
			setSize(300,235);
			setLayout(new BorderLayout(0, 0));
			
			panel_1 = new JPanel();
			add(panel_1, BorderLayout.NORTH);
			
			label = new JLabel("Dodaj kontakt");
			panel_1.add(label);
			//label.setFont(new Font("Tahoma", Font.PLAIN, 17));
			
			panel = new JPanel();
			add(panel, BorderLayout.CENTER);
			panel.setLayout(new GridLayout(0, 4, 0, 2));
			
			horizontalStrut = Box.createHorizontalStrut(20);
			panel.add(horizontalStrut);
			
			label_1 = new JLabel("Imie");
			panel.add(label_1);
			
			textField = new JTextField();
			textField.setToolTipText("wpisz imie");
			textField.setText("");
			textField.setColumns(10);
			panel.add(textField);
			
			horizontalStrut_7 = Box.createHorizontalStrut(20);
			panel.add(horizontalStrut_7);
			
			horizontalStrut_1 = Box.createHorizontalStrut(20);
			panel.add(horizontalStrut_1);
			
			label_2 = new JLabel("Nazwisko");
			panel.add(label_2);
			
			textField_1 = new JTextField();
			textField_1.setToolTipText("nazwisko");
			textField_1.setText("");
			textField_1.setColumns(10);
			panel.add(textField_1);
			
			horizontalStrut_2 = Box.createHorizontalStrut(20);
			panel.add(horizontalStrut_2);
			
			horizontalStrut_3 = Box.createHorizontalStrut(20);
			panel.add(horizontalStrut_3);
			
			label_3 = new JLabel("Numer telefonu");
			panel.add(label_3);
			
			textField_2 = new JTextField();
			textField_2.setToolTipText("numer telefonu");
			textField_2.setText("");
			textField_2.setColumns(10);
			panel.add(textField_2);
			
			horizontalStrut_4 = Box.createHorizontalStrut(20);
			panel.add(horizontalStrut_4);
			
			horizontalStrut_5 = Box.createHorizontalStrut(20);
			panel.add(horizontalStrut_5);
			
			label_4 = new JLabel("E-mail");
			panel.add(label_4);
			
			textField_3 = new JTextField();
			textField_3.setToolTipText("e-mail");
			textField_3.setText("");
			textField_3.setColumns(10);
			panel.add(textField_3);
			
			horizontalStrut_6 = Box.createHorizontalStrut(20);
			panel.add(horizontalStrut_6);
			
			panel_2 = new JPanel();
			add(panel_2, BorderLayout.SOUTH);
			
			button = new JButton();
                        panel_2.add(button);
                        setLeftButtonAction(new JButton("Wyczyść"), new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int temp=dane.size();
                                dane.clear();
                                for(int i=0;i<temp;i++){
                                    dane.add("");
                                }
                                setPola(dane);}
                        });
			
			
			button_1 = new JButton("Dodaj");
			panel_2.add(button_1);
                        setRightButtonAction(new JButton("Pobierz"),new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                               if(sprawdzam()) {
						setDaneZPol();
					}
                               else{
                                   JOptionPane.showMessageDialog(null,"Wprowadzono błędne dane");
                               }
                            }
                        });
			
			List<String> lista = new ArrayList<String>();
			//try {
				
					
					 
				
				
			/*}catch (Exception e) {
				try {
					save(false);
				} catch (FileNotFoundException e1) {
					
					e1.printStackTrace();
				}
				//setVisible(true);
				e.printStackTrace();
			}*/
			try {
	            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	        } catch (ClassNotFoundException | InstantiationException
	                | IllegalAccessException | UnsupportedLookAndFeelException e) {
	            e.printStackTrace();
	        }
			updateFont();
		
		}
		private void setPola(List<String> lista) {
                    getTextField().setText("");
                    getTextField_1().setText("");
                    getTextField_2().setText("");
                    getTextField_3().setText("");
			
			
		}
		private boolean sprawdzam(){
			if(textField.getText().isEmpty() || textField_3.getText().indexOf("@")==-1||textField_2.getText().length()!=9){
				
				return false;
				
			}
			for(int i=0;i<textField_2.getText().length();i+=1) {
                            
				try {
					int zmienna=Integer.parseInt((String) textField_2.getText().subSequence(i,i+1));
				
				}catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}
                        if(textField_2.getText().length()!=9){
                            return false;
                        }
			
			return true;
			
			
		}
		
		public ArrayList<String> getDane(){
			return this.dane;
		}
		public String getDana(int i){
			return  (String) this.dane.get(i);
		}
		private void setDaneZPol() {
			dane.removeAll(dane);
			dane.add(0, textField.getText());
			dane.add(1, textField_1.getText());
			dane.add(2, textField_2.getText());
			dane.add(3, textField_3.getText());
                        JOptionPane.showMessageDialog(null, dane);
		}
		
		private void save(boolean ktory) throws FileNotFoundException {
			if(!ktory) {
				this.textField.setText("");
				this.textField_1.setText("");
				this.textField_2.setText("");
				this.textField_3.setText("");
			}
				setDaneZPol();
				try {
					File f= new File("obj.ser");
					if(f.exists()) {
						this.fos = new FileOutputStream(f);
						this.oos = new ObjectOutputStream(fos);
						oos.writeObject(this.dane);
					}else{
                                            f.createNewFile();
                                        }
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					try {
						oos.close();
						fos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
			
				
			
		}



public void updateFont(){
	button_1.setFont(this.getFont());
	button.setFont(this.getFont());
	label_1.setFont(this.getFont());
	label_2.setFont(this.getFont());
	label_3.setFont(this.getFont());
	label_4.setFont(this.getFont());
	label.setFont(this.getFont());
	textField.setFont(this.getFont());
	textField_1.setFont(this.getFont());
	textField_2.setFont(this.getFont());
	textField_3.setFont(this.getFont());
        System.out.print(this.getFont());
}
public FileOutputStream getFos() {
	return fos;
}
public void setFos(FileOutputStream fos) {
	this.fos = fos;
}
public ObjectOutputStream getOos() {
	return oos;
}
public void setOos(ObjectOutputStream oos) {
	this.oos = oos;
}
public JPanel getPanel() {
	return panel;
}
public void setPanel(JPanel panel) {
	this.panel = panel;
}
public JLabel getLabel() {
	return label;
}
public void setLabel(JLabel label) {
	this.label = label;
}
public JPanel getPanel_1() {
	return panel_1;
}
public void setPanel_1(JPanel panel_1) {
	this.panel_1 = panel_1;
}
public JTextField getTextField() {
	return textField;
}
public void setTextField(JTextField textField) {
	this.textField = textField;
}
public JLabel getLabel_2() {
	return label_2;
}
public void setLabel_2(JLabel label_2) {
	this.label_2 = label_2;
}
public JTextField getTextField_1() {
	return textField_1;
}
public void setTextField_1(JTextField textField_1) {
	this.textField_1 = textField_1;
}
public JLabel getLabel_3() {
	return label_3;
}
public void setLabel_3(JLabel label_3) {
	this.label_3 = label_3;
}
public JTextField getTextField_2() {
	return textField_2;
}
public void setTextField_2(JTextField textField_2) {
	this.textField_2 = textField_2;
}
public JLabel getLabel_4() {
	return label_4;
}
public void setLabel_4(JLabel label_4) {
	this.label_4 = label_4;
}
public JTextField getTextField_3() {
	return textField_3;
}
public void setTextField_3(JTextField textField_3) {
	this.textField_3 = textField_3;
}
public JLabel getLabel_1() {
	return label_1;
}
public void setLabel_1(JLabel label_1) {
	this.label_1 = label_1;
}
public JPanel getPanel_2() {
	return panel_2;
}
public void setPanel_2(JPanel panel_2) {
	this.panel_2 = panel_2;
}
public JButton getButton() {
	return button;
}
public void setButton(JButton button) {
	this.button = button;
}
public JButton getButton_1() {
	return button_1;
}
public void setButton_1(JButton button_1) {
	this.button_1 = button_1;
}
public void setDane(ArrayList<String> dane) {
	this.dane = dane;
}
public void setLeftButtonAction(JButton button,ActionListener action){
    for(int i=0;i<button.getActionListeners().length;i++){
        button.removeActionListener(button.getActionListeners()[i]);
    }
    button.addActionListener(action);
    this.setButton(button);
    this.panel_2.remove(0);
    this.panel_2.add(button,0);
}
public void setRightButtonAction(JButton button,ActionListener action){
    for(int i=0;i<button.getActionListeners().length;i++){
        button.removeActionListener(button.getActionListeners()[i]);
    }
    button.addActionListener(action);
    this.setButton_1(button);
    this.panel_2.remove(1);
    this.panel_2.add(button_1,1);
}
}