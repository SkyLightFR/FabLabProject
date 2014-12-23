package com.virtualMuseum.controler;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import com.virtualMuseum.database.Connexion;
import com.virtualMuseum.view.PrincipalPanel;

public class ResearchFileByKeyWords {
	PrincipalPanel panel;
	public ResearchFileByKeyWords(PrincipalPanel panel){
		this.panel=panel;
		int size=25;
		Connexion con = new Connexion("Database.db");
		con.connect();
		String query="SELECT * FROM Filegts WHERE motCle like '%"+panel.getMenuTools().getSearch().getText()+"%';";
		ResultSet rs = con.query(query);
		JPopupMenu popup = new JPopupMenu();

		try {
			while(rs.next()){
				popup.setPreferredSize(new Dimension(panel.getMenuTools().getSearch().getWidth(),size));
				panel.setFileResearch(new JMenuItem(rs.getString("name")));
				panel.getFileResearch().addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try{
							ResearchFileByKeyWords.this.panel.printFile(ResearchFileByKeyWords.this.panel.getFileResearch().getText());
						}catch(Exception a){
							System.out.println(a.getMessage());
						}
					}

				});

				popup.add(panel.getFileResearch());
				size+=30;

			}
			popup.show(panel, panel.getMenuTools().getSearch().getX()+7, panel.getMenuTools().getSearch().getY()+57);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		con.close();

	}
}


