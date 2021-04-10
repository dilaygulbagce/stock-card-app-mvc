package com.dilaygulbagce.stockCardApplication.controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

import com.dilaygulbagce.stockCardApplication.model.ProductEntiries;
import com.dilaygulbagce.stockCardApplication.model.ProductQueries;
import com.dilaygulbagce.stockCardApplication.view.MainFrame;

public class ProductController implements ActionListener, KeyListener, InternalFrameListener {
	
	private ProductEntiries productEntiries;
	private ProductQueries productQueries;
	private MainFrame mainFrame;
	
	public ProductController (ProductEntiries productEntiries, ProductQueries productQueries, 
			MainFrame mainFrame) {
		
		this.productEntiries = productEntiries;
		this.productQueries = productQueries;
		this.mainFrame = mainFrame;
		
		this.mainFrame.menuItemOperation.addActionListener(this);
		this.mainFrame.menuItemList.addActionListener(this);
		this.mainFrame.iFrameOperation.insertButton.addActionListener(this);
		this.mainFrame.iFrameOperation.deleteButton.addActionListener(this);
		this.mainFrame.iFrameOperation.updateButton.addActionListener(this);
		this.mainFrame.iFrameOperation.copyButton.addActionListener(this);
		this.mainFrame.iFrameOperation.searchButton.addActionListener(this);
		this.mainFrame.iFrameOperation.cleanButton.addActionListener(this);
		this.mainFrame.iFrameOperation.tfSearchBar.addKeyListener(this); 
		this.mainFrame.iFrameList.listButton.addActionListener(this);
		this.mainFrame.iFrameList.addInternalFrameListener(this);

	}
	
	public void start() {
		mainFrame.setVisible(true);
	}
	
	@Override
	public void actionPerformed (ActionEvent event) {
		if(event.getSource() == mainFrame.menuItemOperation) {
			mainFrame.iFrameOperation.setLocation(15, 60);
			mainFrame.iFrameOperation.setVisible(true);
		}
		
		if(event.getSource() == mainFrame.menuItemList) {
			mainFrame.iFrameList.setLocation(490, 60);
			mainFrame.iFrameList.setVisible(true);
		}
		
		if (event.getSource() == mainFrame.iFrameOperation.insertButton) {
			control();
			insert();
		}
		
		if (event.getSource() == mainFrame.iFrameOperation.deleteButton) {
			delete();
		}
		
		if (event.getSource() == mainFrame.iFrameOperation.updateButton) {
			control();
			update();
		}
		
		if (event.getSource() == mainFrame.iFrameOperation.searchButton) {
			search();
		}
		
		if(event.getSource() == mainFrame.iFrameOperation.cleanButton) {
			clean();
		}
		
		if(event.getSource() == mainFrame.iFrameList.listButton) {
			list();
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			search();
		}
	}
	
	@Override
	public void internalFrameClosing(InternalFrameEvent e) {
		DefaultTableModel recordTable = (DefaultTableModel) mainFrame.iFrameList.table.getModel();
        recordTable.setRowCount(0);
	}
	
	public void list() {
		try {
			ArrayList<Vector> productList = productQueries.List();
			
			if(productList != null) {
				DefaultTableModel recordTable = (DefaultTableModel) mainFrame.iFrameList.table.getModel();
	            recordTable.setRowCount(0);
	      
	            for (Vector<String> s : productList) {
	                   recordTable.addRow(s);
	            }
			}
			else {
				JOptionPane.showMessageDialog(null, "Hata!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insert() {
		productEntiries.setStockCode(mainFrame.iFrameOperation.tfStockCode.getText());
		productEntiries.setStockName(mainFrame.iFrameOperation.tfStockName.getText());
		productEntiries.setStockType(mainFrame.iFrameOperation.cbStockType.getSelectedIndex());
		productEntiries.setStockUnit(mainFrame.iFrameOperation.cbUnit.getSelectedItem().toString());
		productEntiries.setStockBarcode(mainFrame.iFrameOperation.tfBarcode.getText());
		productEntiries.setVatType(Double.parseDouble((String) mainFrame.iFrameOperation.cbVATType.getSelectedItem().toString()));
		Date date = new Date(mainFrame.iFrameOperation.jdcCreationDate.getDate().getTime());
		productEntiries.setCreationDate(date);
		productEntiries.setDescription(mainFrame.iFrameOperation.taDescription.getText());
		
		try {
			if (productQueries.Insert(productEntiries)) {
				JOptionPane.showMessageDialog(null, "Kayıt İşlemi Başarılı!");
				clean();
			}
			else {
				JOptionPane.showMessageDialog(null, "Bu Stok Kodu Zaten Kayıtlı!");
				clean();
			}
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete() {
		productEntiries.setStockCode(mainFrame.iFrameOperation.tfStockCode.getText());
		
		try {
			if (productQueries.Delete(productEntiries)) {
				JOptionPane.showMessageDialog(null, "Silme İşlemi Başarılı!");
				clean();
			}
			else {
				JOptionPane.showMessageDialog(null, "Hata!");
				clean();
			}
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		productEntiries.setStockCode(mainFrame.iFrameOperation.tfStockCode.getText());
		productEntiries.setStockName(mainFrame.iFrameOperation.tfStockName.getText());
		productEntiries.setStockType(mainFrame.iFrameOperation.cbStockType.getSelectedIndex());
		productEntiries.setStockUnit(mainFrame.iFrameOperation.cbUnit.getSelectedItem().toString());
		productEntiries.setStockBarcode(mainFrame.iFrameOperation.tfBarcode.getText());
		productEntiries.setVatType(Double.parseDouble((String) mainFrame.iFrameOperation.cbVATType.getSelectedItem().toString()));
		Date date = new Date(mainFrame.iFrameOperation.jdcCreationDate.getDate().getTime());
		productEntiries.setCreationDate(date);
		productEntiries.setDescription(mainFrame.iFrameOperation.taDescription.getText());
		
		try {
			if (productQueries.Update(productEntiries)) {
				JOptionPane.showMessageDialog(null, "Güncelleme İşlemi Başarılı!");
				clean();
			}
			else {
				JOptionPane.showMessageDialog(null, "Hata!");
				clean();
			}
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void search() {
		productEntiries.setStockCode(mainFrame.iFrameOperation.tfSearchBar.getText().toUpperCase());
		
		try {
			if (productQueries.Search(productEntiries)) {
				mainFrame.iFrameOperation.tfStockCode.setText(productEntiries.getStockCode());
				mainFrame.iFrameOperation.tfStockName.setText(productEntiries.getStockName());
				mainFrame.iFrameOperation.cbStockType.setSelectedIndex(productEntiries.getStockType());
				mainFrame.iFrameOperation.cbUnit.setSelectedItem(productEntiries.getStockUnit());
				mainFrame.iFrameOperation.tfBarcode.setText(productEntiries.getStockBarcode());
				mainFrame.iFrameOperation.cbVATType.setSelectedItem(productEntiries.getVatType());
				mainFrame.iFrameOperation.jdcCreationDate.setDate(productEntiries.getCreationDate());
				mainFrame.iFrameOperation.taDescription.setText(productEntiries.getDescription());
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Kayıt Bulanamadı!");
				clean();
			}
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void control() {
		if(mainFrame.iFrameOperation.tfStockCode.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Stok Kodu Alanı Boş Bırakılamaz");
        }
        
        else if (mainFrame.iFrameOperation.tfStockName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Stok Adı Alanı Boş Bırakılamaz");
        }
        
        else if (mainFrame.iFrameOperation.cbStockType.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Stok Tipi Alanı Boş Bırakılamaz");
        }
        
        else if (mainFrame.iFrameOperation.cbUnit.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Stok Birimi Alanı Boş Bırakılamaz");
        }
        
        else if (mainFrame.iFrameOperation.tfBarcode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Barkod Alanı Boş Bırakılamaz");
        }
        
        else if (mainFrame.iFrameOperation.cbVATType.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "KDV Tipi Alanı Boş Bırakılamaz");
        }
        
        else if (mainFrame.iFrameOperation.jdcCreationDate.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Oluşturma Tarihi Alanı Boş Bırakılamaz");
        }
	}
	
	public void clean() {
		mainFrame.iFrameOperation.tfStockCode.setText(null);
		mainFrame.iFrameOperation.tfStockName.setText(null);
		mainFrame.iFrameOperation.cbStockType.setSelectedIndex(-1);
		mainFrame.iFrameOperation.cbUnit.setSelectedItem(null);
		mainFrame.iFrameOperation.tfBarcode.setText(null);
		mainFrame.iFrameOperation.cbVATType.setSelectedItem(null);
		mainFrame.iFrameOperation.jdcCreationDate.setDate(null);
		mainFrame.iFrameOperation.taDescription.setText(null);
		mainFrame.iFrameOperation.tfSearchBar.setText(null);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameOpened(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameClosed(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameIconified(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameActivated(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}
}
