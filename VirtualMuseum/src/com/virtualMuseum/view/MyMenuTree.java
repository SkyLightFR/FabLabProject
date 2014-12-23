package com.virtualMuseum.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import com.virtualMuseum.database.Connexion;
import com.virtualMuseum.view.PrincipalPanel.TreeListener;

public class MyMenuTree extends JPanel {
	
	JTree tree;
	DefaultMutableTreeNode root = new DefaultMutableTreeNode("DataBase");
	public MyMenuTree(TreeListener listener){
	
		
		Connexion connexion = new Connexion("Database.db");
		connexion.connect();
		ResultSet resultSet = connexion.query("SELECT * FROM Filegts");
		try {
			while (resultSet.next()) {
				DefaultMutableTreeNode file = new DefaultMutableTreeNode(resultSet.getString("name"));
				root.add(file);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		tree = new JTree(root);
		tree.setPreferredSize(new Dimension(250,500));
		tree.addTreeSelectionListener(listener);
		this.add(new JScrollPane(tree));
	}
	
	

	
	public JTree getTree() {
		return tree;
	}
	public DefaultMutableTreeNode getRoot() {
		return root;
	}
	
}
