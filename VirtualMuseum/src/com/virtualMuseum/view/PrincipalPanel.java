package com.virtualMuseum.view;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import com.virtualMuseum.controler.HorizontalRotation;
import com.virtualMuseum.controler.OpenFiles;
import com.virtualMuseum.controler.ResearchFile;
import com.virtualMuseum.controler.ResearchFileByDate;
import com.virtualMuseum.controler.ResearchFileByKeyWords;
import com.virtualMuseum.controler.SaveFiles;
import com.virtualMuseum.controler.SimpleFilter;
import com.virtualMuseum.controler.TranslationCenter;
import com.virtualMuseum.controler.TranslationX;
import com.virtualMuseum.controler.TranslationY;
import com.virtualMuseum.controler.VerticalRotation;
import com.virtualMuseum.database.Connexion;
import com.virtualMuseum.database.GtsFile;


public class PrincipalPanel extends JPanel {
	Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	int height = (int)screenSize.getHeight();
	int width = (int)screenSize.getWidth();
	JPanel print = new JPanel();
	JPanel info=new JPanel();
	MyMenuBar menuBar;
	MyMenuTools menuTools;
	MyMenuTree menuTree;
	MyMenuChanges menuChanges;
	MyMenuInformations menuInfo;
	
	JCheckBox lightBox=new JCheckBox("Lumiere",false);
	JMenuItem fileResearch=new JMenuItem("");
	FileFilter gts = new SimpleFilter("Fichiers gts", ".gts");
	JFileChooser chooser = new JFileChooser(new File("."));
	JFileChooser saveChooser = new JFileChooser(new File("."));

	File currentFile;
	Print printer;
	OpenFiles readFile=null;
	
	protected int clicx;
	protected int clicy;
	String format = "dd/MM/yy";
	SimpleDateFormat formater = new SimpleDateFormat(format);
	public PrincipalPanel() {	
		info.setPreferredSize(new Dimension(240,400));
		print.setPreferredSize(new Dimension(860,600));	
		ButtonListener listener = new ButtonListener();
		TreeListener treeListener = new TreeListener();
		Zoom zoomListener = new Zoom();
		Drag dragListener = new Drag();
		MListener Mlistener = new MListener();
		menuTools = new MyMenuTools(listener);
		menuTree=new MyMenuTree(treeListener);
		menuBar = new MyMenuBar(listener);
		menuInfo = new MyMenuInformations();
		menuChanges = new MyMenuChanges(printer,listener,Mlistener);
		if(printer==null){
			menuChanges.getTransX().setEnabled(false);
			menuChanges.getTransY().setEnabled(false);
			menuChanges.getTransLowerX().setEnabled(false);
			menuChanges.getTransLowerY().setEnabled(false);
			menuChanges.getTransCenter().setEnabled(false);

		}
		menuChanges.getZoomSlider().addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				int zoom=menuChanges.getZoomSlider().getValue();
				if(printer!=null){
					printer.setZoom(zoom);
					repaint();
					
				}
				
			}
		
		});
		
		print.addMouseWheelListener(zoomListener);
		print.addMouseMotionListener(dragListener);
		print.addMouseListener(Mlistener);
		fileResearch.addActionListener(listener);
		
		chooser.addChoosableFileFilter(gts);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=0;	
		gbc.gridwidth =  GridBagConstraints.REMAINDER;
		gbc.gridheight=1;
		this.add(menuBar, gbc);
		
		gbc.gridx = 0;
	    gbc.gridy = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight=1;
		this.add(menuTools, gbc);
		
		
		gbc.gridx = 2;
	    gbc.gridy = 2;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight=1;
		this.add(lightBox,gbc);
		
		gbc.gridx = 0;
	    gbc.gridy = 2;
	    gbc.gridwidth = 3;
	    gbc.gridheight=3;
	    gbc.insets = new Insets(10,0,0,0);
		this.add(menuTree, gbc);

		gbc.gridx=4;
		gbc.gridy=2;
		gbc.gridheight=5;
		gbc.gridwidth=5;
		this.add(print,gbc);
			
		gbc.gridx=11;
		gbc.gridy=2;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight=4;
		gbc.insets = new Insets(10,0,0,0);
		this.add(menuChanges,gbc);

		gbc.gridx=0;
		gbc.gridy=5;
		gbc.gridwidth=3;
		gbc.gridheight=GridBagConstraints.REMAINDER;
		this.add(info,gbc);


	}
	public void research(){
		new ResearchFile(this);	
	}
	public void researchByKeyWords(){
		new ResearchFileByKeyWords(this);
	}
	public void researchByDate(){
		new ResearchFileByDate(this);
	}
	
	public class ButtonListener implements ActionListener {
		File fileChoose=null;
		

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if (e.getSource() == menuBar.getOpen() || e.getSource()==menuTools.getToolopen()) {
				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					fileChoose = chooser.getSelectedFile();
					if (gts.accept(fileChoose)) {
						try {	
							printFile(fileChoose.getName());
						} catch (Exception a) {
							System.out.println(a.getMessage());
						}							
					} else {
						JOptionPane.showMessageDialog(null,
								"Extension non valide", "Attention",
								JOptionPane.ERROR_MESSAGE);
					}
					
				}
			}
			
			if(e.getSource()==menuTools.getTooladd()){
				
			
				if(readFile!=null ){
					new MyMenuAddFile(readFile).addWindowListener(new WindowListener(){

						@Override
						public void windowActivated(WindowEvent arg0) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void windowClosed(WindowEvent arg0) {
							// TODO Auto-generated method stub
							boolean everAdd=false;
							GtsFile g =new GtsFile(currentFile.getName(),readFile.getNbPoints(),readFile.getNbSegments(),readFile.getNbFaces(),readFile.getKeyWords().toString(),formater.format(readFile.getDate()));	
							Connexion con = new Connexion("Database.db");
							con.connect();  
							String select="Select name from Filegts";
							ResultSet rs = con.query(select);
							JPopupMenu popup = new JPopupMenu();
							try {
								while(rs.next()){
									if(rs.getString(1).equals(currentFile.getName())){
										everAdd=true;
									}
									
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					    	
							if(!everAdd){
								con.addGtsFile(g);
							
								menuTree.getRoot().add(new DefaultMutableTreeNode(fileChoose.getName()));
								((DefaultTreeModel) menuTree.getTree().getModel()).reload();
								
							}else{
								JOptionPane.showMessageDialog(null,
										"Fichier déjà ajouté à la base de donée", "Attention",
										JOptionPane.ERROR_MESSAGE);
								
							}
							
							con.close();
							
						}

						@Override
						public void windowClosing(WindowEvent arg0) {
							// TODO Auto-generated method stub
							
							
						}

						@Override
						public void windowDeactivated(WindowEvent arg0) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void windowDeiconified(WindowEvent arg0) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void windowIconified(WindowEvent arg0) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void windowOpened(WindowEvent arg0) {
							// TODO Auto-generated method stub
							
						}
						
					});
					
				}
				
			}
			if(e.getSource()==menuTools.getToolremove()){
				if(menuTree.getTree().getLastSelectedPathComponent() != null){
					Connexion con = new Connexion("Database.db");
					con.connect();
					con.remove(menuTree.getTree().getLastSelectedPathComponent().toString());
					DefaultMutableTreeNode nodeName = (DefaultMutableTreeNode)menuTree.getTree().getLastSelectedPathComponent(); 
					DefaultTreeModel  model = (DefaultTreeModel)menuTree.getTree().getModel(); 
					model.removeNodeFromParent(nodeName); 
					((DefaultTreeModel) menuTree.getTree().getModel()).reload();
					con.close();
				}
			}
			if(e.getSource()==menuTools.getToolresearch()){
				if(menuTools.getKeyWordsResearch().isSelected()){
					researchByKeyWords();
				}else if(menuTools.getDateResearch().isSelected()){
					researchByDate();
					
				}else{
					research();
				}	
			}
			if(e.getSource()==menuTools.getKeyWordsResearch()){
				menuTools.getDateResearch().setSelected(false);
			}
			if(e.getSource()==menuTools.getDateResearch()){
				menuTools.getKeyWordsResearch().setSelected(false);
			}
		
			if(e.getSource()==menuTools.getToolsave() || e.getSource()==menuBar.getSaveAs()){
				if (saveChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					new SaveFiles(saveChooser.getSelectedFile().getName(), printer);
					
				}				
			}
			if(e.getSource()==menuBar.getSave()){
				new SaveFiles(currentFile.getName(), printer);
			}
			if(e.getSource()==menuBar.getHelp()){
				new MyMenuHelp();
				
			}
			if(e.getSource()==menuBar.getExit()){
				System.exit(0);
			}
			if(e.getSource()==fileResearch){
				try{
					printFile(fileResearch.getText());
		
				}catch(Exception a){
					System.out.println(a.getMessage());
				}
				
			}
			if(e.getSource()==menuChanges.getTransX()){
				boolean doTranslation=false;
				for(int i=0; i<readFile.getNbPoints(); i++){
					if((readFile.getTabPoints()[i].getX()*printer.getZoom())+printer.getXsize()/2<print.getWidth()-70 ){
						doTranslation=true;
						break;
					}
				}
				if(doTranslation){
					new TranslationX(printer,-1);
					repaint();
				}	
			}
			if(e.getSource()==menuChanges.getTransY()){
				boolean doTranslation=false;
				for(int i=0; i<readFile.getNbPoints(); i++){
					if((readFile.getTabPoints()[i].getY()*printer.getZoom())+printer.getYsize()/2>print.getY()-100){
						doTranslation=true;
						break;
					}
				}
				if(doTranslation){
					new TranslationY(printer,1);
					repaint();
				}
			}
			if(e.getSource()==menuChanges.getTransLowerX()){
				boolean doTranslation=false;
				for(int i=0; i<readFile.getNbPoints(); i++){
					if((readFile.getTabPoints()[i].getX()*printer.getZoom())+printer.getXsize()/2>print.getX()-200){
						doTranslation=true;
						break;
					}
				}
				if(doTranslation){
					new TranslationX(printer,1);
					repaint();
				}	
			}
			if(e.getSource()==menuChanges.getTransLowerY()){
				boolean doTranslation=false;
				for(int i=0; i<readFile.getNbPoints(); i++){
					if((readFile.getTabPoints()[i].getY()*printer.getZoom())+printer.getYsize()/2<print.getHeight()-50){
						doTranslation=true;
						break;
					}
				}
				if(doTranslation){
					new TranslationY(printer,-1);
					repaint();
				}
			}
			if(e.getSource()==menuChanges.getTransCenter()){
				new TranslationCenter(printer,PrincipalPanel.this);
				repaint();
				
			}
			
			
		}
	}
	public class TreeListener implements TreeSelectionListener{

		@Override
		public void valueChanged(TreeSelectionEvent e) {
			// TODO Auto-generated method stub
			if(menuTree.getTree().getLastSelectedPathComponent() != null){
				try{
					printFile(menuTree.getTree().getLastSelectedPathComponent().toString());		
				}catch(Exception a){
					System.out.println(a.getMessage());
				}
				print.repaint();
			}
				
		}
		
	}
	
	
	public class Zoom implements MouseWheelListener{
		int zoom=0;
		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			// TODO Auto-generated method stub
			if(printer!=null){
				zoom=printer.getZoom();
				if(e.getWheelRotation()<0){
					zoom+=5;
					printer.setZoom(zoom);
					repaint();
				}else if(zoom>5){
					zoom-=5;
					printer.setZoom(zoom);
					repaint();
				}
			}
		}
		
	}
	
	public class MListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==print){
				clicx=e.getX();
				clicy=e.getY();	
			}	
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
			
		}	
	}
	
	public class Drag implements MouseMotionListener{
		
		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			new HorizontalRotation(printer,((clicx-e.getX())*5)/120);
			new VerticalRotation(printer,((clicy-e.getY())*5)/120);
			repaint();	
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub		
		}		
	}
	
	public void printFile(String filename) throws Exception{
		print.removeAll();
		readFile=new OpenFiles(filename);
		printer=new Print(readFile);
		printer.setPreferredSize(new Dimension(850,590));
		printer.setBorder(BorderFactory.createLoweredBevelBorder());
		print.add(printer);
		print.revalidate();
		print.repaint();
		menuChanges.getTransX().setEnabled(true);
		menuChanges.getTransY().setEnabled(true);
		menuChanges.getTransLowerX().setEnabled(true);
		menuChanges.getTransLowerY().setEnabled(true);
		menuChanges.getTransCenter().setEnabled(true);
		currentFile=new File(filename);	
		info.removeAll();
		info.add(new MyMenuInformations(printer,menuTree,currentFile));	

	}
	public File getCurrentFile() {
		return currentFile;
	}

	public MyMenuTools getMenuTools() {
		return menuTools;
	}

	public JMenuItem getFileResearch() {
		return fileResearch;
	}

	public void setFileResearch(JMenuItem fileResearch) {
		this.fileResearch = fileResearch;
	}
	
	
	
}
