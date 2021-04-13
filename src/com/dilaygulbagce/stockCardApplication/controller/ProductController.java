package com.dilaygulbagce.stockCardApplication.controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

import com.dilaygulbagce.stockCardApplication.model.ProductEntiries;
import com.dilaygulbagce.stockCardApplication.model.ProductQueries;
import com.dilaygulbagce.stockCardApplication.view.MainFrame;

public class ProductController implements ActionListener, KeyListener, InternalFrameListener, MouseListener {
	
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
		this.mainFrame.iFrameOperation.addInternalFrameListener(this);
		
		this.mainFrame.iFrameList.listButton.addActionListener(this);
		this.mainFrame.iFrameList.table.addMouseListener((MouseListener) this);
		this.mainFrame.iFrameList.addInternalFrameListener(this);
	}
	
	public void start() {
		mainFrame.setVisible(true);
	}
	
	@Override
	public void actionPerformed (ActionEvent event) {
		if (event.getSource() == mainFrame.menuItemOperation) {
			mainFrame.iFrameOperation.setLocation(15, 60);
			mainFrame.iFrameOperation.setVisible(true);
		}
		
		if (event.getSource() == mainFrame.menuItemList) {
			mainFrame.iFrameList.setLocation(490, 60);
			mainFrame.iFrameList.setVisible(true);
		}
		
		if (event.getSource() == mainFrame.iFrameOperation.insertButton) {
			if (control() == true) {
				insert();
			}
		}
		
		if (event.getSource() == mainFrame.iFrameOperation.deleteButton) {
			if (mainFrame.iFrameOperation.tfStockCode.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Silinecek Kaydı Seçiniz");
			}
			else {
				int dialog = JOptionPane.showConfirmDialog(null, "Silmek istediğinize emin misiniz?", "Uyarı", JOptionPane.YES_NO_OPTION);
				
				if (dialog == JOptionPane.YES_OPTION) {
					delete();
				}
			}
		}
	
		if (event.getSource() == mainFrame.iFrameOperation.updateButton) {
			if (control() == true) {
				int dialog = JOptionPane.showConfirmDialog(null, "Güncellemeyi Onaylayınız", "Uyarı", JOptionPane.YES_NO_OPTION);
				
				if (dialog == JOptionPane.YES_OPTION) {
					update();
				}
			}
		}
		
		if (event.getSource() == mainFrame.iFrameOperation.copyButton) {
			if(mainFrame.iFrameOperation.tfStockCode.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Kopyalanacak Kaydı Seçiniz");
			}
			else {
				if (control() == true) {
					copy();
				}
			}
		}
		
		if (event.getSource() == mainFrame.iFrameOperation.searchButton) {
			if (mainFrame.iFrameOperation.tfSearchBar.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Aranacak Kaydın Stok Kodunu Giriniz");
			}
			else {
				search();
			}
		}
		
		if (event.getSource() == mainFrame.iFrameOperation.cleanButton) {
			clean();
		}
		
		if (event.getSource() == mainFrame.iFrameList.listButton) {
			list();
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		DefaultTableModel recordTable = (DefaultTableModel) mainFrame.iFrameList.table.getModel();
		int selectedRows = mainFrame.iFrameList.table.getSelectedRow();
		
		try {
			mainFrame.iFrameOperation.tfStockCode.setText(recordTable.getValueAt(selectedRows, 0).toString());
			mainFrame.iFrameOperation.tfStockName.setText(recordTable.getValueAt(selectedRows, 1).toString());
			mainFrame.iFrameOperation.cbStockType.setSelectedItem(recordTable.getValueAt(selectedRows, 2).toString());
			mainFrame.iFrameOperation.cbUnit.setSelectedItem(recordTable.getValueAt(selectedRows, 3).toString());
			mainFrame.iFrameOperation.tfBarcode.setText(recordTable.getValueAt(selectedRows, 4).toString());
			mainFrame.iFrameOperation.cbVATType.getModel().setSelectedItem(recordTable.getValueAt(selectedRows, 5).toString());
			java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(recordTable.getValueAt(selectedRows, 6).toString());
			mainFrame.iFrameOperation.jdcCreationDate.setDate(date);
			mainFrame.iFrameOperation.taDescription.setText(recordTable.getValueAt(selectedRows, 7).toString());
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			search();
		}
	}
	
	@Override
	public void internalFrameClosing(InternalFrameEvent e) {
		DefaultTableModel recordTable = (DefaultTableModel) mainFrame.iFrameList.table.getModel();
        recordTable.setRowCount(0);
        clean();
	}
	
	public void list() {
		try {
			ArrayList<Vector> productList = productQueries.List();
			
			if (productList != null) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void copy() {
		productEntiries.setStockCode(mainFrame.iFrameOperation.tfStockCode.getText());
		
		try {
			if (productQueries.Copy(productEntiries)) {
				JOptionPane.showMessageDialog(null, "Kopyalama İşlemi Başarılı!");
				clean();
			}
			else {
				JOptionPane.showMessageDialog(null, "Bu Stok Kodu Zaten Kayıtlı!");
				clean();
			}
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean control() {
		if(mainFrame.iFrameOperation.tfStockCode.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Stok Kodu Alanı Boş Bırakılamaz");
			return false;
        }
        
        else if (mainFrame.iFrameOperation.tfStockName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Stok Adı Alanı Boş Bırakılamaz");
            return false;
        }
        
        else if (mainFrame.iFrameOperation.cbStockType.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Stok Tipi Alanı Boş Bırakılamaz");
            return false;
        }
        
        else if (mainFrame.iFrameOperation.cbUnit.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Stok Birimi Alanı Boş Bırakılamaz");
            return false;
        }
        
        else if (mainFrame.iFrameOperation.tfBarcode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Barkod Alanı Boş Bırakılamaz");
            return false;
        }
        
        else if (mainFrame.iFrameOperation.cbVATType.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "KDV Tipi Alanı Boş Bırakılamaz");
            return false;
        }
        
        else if (mainFrame.iFrameOperation.jdcCreationDate.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Oluşturma Tarihi Alanı Boş Bırakılamaz");
            return false;
        }
		
		return true;
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
	public void internalFrameOpened(InternalFrameEvent e) {
	}

	@Override
	public void internalFrameClosed(InternalFrameEvent e) {
	}

	@Override
	public void internalFrameIconified(InternalFrameEvent e) {
	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent e) {
	}

	@Override
	public void internalFrameActivated(InternalFrameEvent e) {
	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
