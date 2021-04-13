package com.dilaygulbagce.stockCardApplication.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JOptionPane;

public class ProductQueries extends DatabaseConnection {
	
	@SuppressWarnings("serial")
	HashMap<String, String> stockTypeMap = new HashMap<String, String>() {{
		put("1", "Süt ve Süt Ürünleri");
		put("2", "Et ve Et Ürünleri");
		put("3", "Yağ");
		put("4", "Meyve ve Sebze Ürünleri");
		put("5", "Konserve Gıda");
		put("6", "Dondurulmuş Gıda");
		put("7", "Kuru Gıda");
		put("8", "Unlu Mamüller");
		put("9", "Su Ürünleri");
	}};
	
	@SuppressWarnings("rawtypes")
	public ArrayList<Vector> List() throws SQLException {
			
			PreparedStatement preparedStatement = null;
			Connection connect = getConnection();
			ResultSet resultSet = null;
			
			ArrayList<Vector> products = new ArrayList<Vector>();
			
			String sql = "SELECT * FROM product";
	
			try {
				preparedStatement = connect.prepareStatement(sql);
				resultSet = preparedStatement.executeQuery();
				
				ResultSetMetaData stData = resultSet.getMetaData();
				
				int dbColumnCount;
				dbColumnCount = stData.getColumnCount();
				
				while(resultSet.next()) {
					Vector<String> columnData = new Vector<String>();
					
					for(int i=1; i<dbColumnCount; i++) {
						columnData.add(resultSet.getString("stock_code"));
	                    columnData.add(resultSet.getString("stock_name"));
	                    columnData.add(stockTypeMap.get(resultSet.getString("stock_type")));
	                    columnData.add(resultSet.getString("unit"));
	                    columnData.add(resultSet.getString("barcode"));
	                    columnData.add(resultSet.getString("VAT_type"));
	                    String date[] = resultSet.getString("creation_date").split(" ");
	                    columnData.add(date[0]);
	                    columnData.add(resultSet.getString("description"));
					}
					products.add(columnData);
				}
				return products;
			} catch (SQLException exception) {
				System.err.println(exception);
				return null;
			} finally {
				try {
					connect.close();
				} catch (SQLException exception) {
					System.err.println(exception);
				}
			}
		}
		
		public boolean Insert(ProductEntiries productEntiries) throws SQLException {
			
			PreparedStatement preparedStatement = null;
			Connection connect = getConnection();
			
			String sql = "INSERT INTO product (stock_code, stock_name, stock_type, unit, "
					+ "barcode, VAT_type, creation_date, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	
			try {
				preparedStatement = connect.prepareStatement(sql);
				
				preparedStatement.setString(1, productEntiries.getStockCode());
				preparedStatement.setString(2, productEntiries.getStockName());
				preparedStatement.setInt(3, productEntiries.getStockType());
				preparedStatement.setString(4, productEntiries.getStockUnit());
				preparedStatement.setString(5, productEntiries.getStockBarcode());
				preparedStatement.setDouble(6, productEntiries.getVatType());
				preparedStatement.setDate(7, productEntiries.getCreationDate());
				preparedStatement.setString(8, productEntiries.getDescription());
				preparedStatement.execute();
				
				return true;
				
			} catch (SQLException exception) {
				System.err.println(exception);
				return false;
				
			} finally {
				try {
					connect.close();
				} catch (SQLException exception) {
					System.err.println(exception);
				}
			}
		}
		
		public boolean Delete(ProductEntiries productEntiries) throws SQLException {
			
			PreparedStatement preparedStatement = null;
			Connection connect = getConnection();
			
			String sql = "DELETE FROM product WHERE stock_code = ?";
			
			try {
				preparedStatement = connect.prepareStatement(sql);
				
				preparedStatement.setString(1, productEntiries.getStockCode());
				preparedStatement.execute();
				
				return true;
				
			} catch (SQLException exception) {
				System.err.println(exception);
				return false;
				
			} finally {
				try {
					connect.close();
					
				} catch (SQLException exception) {
					System.err.println(exception);
				}
			}
		}
		
		public boolean Update(ProductEntiries productEntiries) throws SQLException {
				
				PreparedStatement preparedStatement = null;
				Connection connect = getConnection();
				
				String sql = "UPDATE stock_card.product SET stock_name = ?, stock_type = ?, unit = ?, "
						+ "barcode = ?, VAT_type = ?, creation_date = ?, description = ? WHERE stock_code = ?";
				
				try {
					preparedStatement = connect.prepareStatement(sql);
					
					preparedStatement.setString(1, productEntiries.getStockName());
					preparedStatement.setInt(2, productEntiries.getStockType());
					preparedStatement.setString(3, productEntiries.getStockUnit());
					preparedStatement.setString(4, productEntiries.getStockBarcode());
					preparedStatement.setDouble(5, productEntiries.getVatType());
					preparedStatement.setDate(6, productEntiries.getCreationDate());
					preparedStatement.setString(7, productEntiries.getDescription());
					preparedStatement.setString(8, productEntiries.getStockCode());
					preparedStatement.execute();
					
					return true;
					
				} catch (SQLException exception) {
					System.err.println(exception);
					return false;
					
				} finally {
					try {
						connect.close();
						
					} catch (SQLException exception) {
						System.err.println(exception);
					}
				}
		}
		
		public boolean Copy(ProductEntiries productEntiries) throws SQLException {
			PreparedStatement preparedStatement = null;
			Connection connect = getConnection();
			
			String stockCode = productEntiries.getStockCode();
			
			String copyItem = JOptionPane.showInputDialog(null, "Kopyanın Stok Kodu?");
			
			String sql = "INSERT INTO product (stock_code, stock_name, stock_type, unit, barcode, VAT_type, creation_date, description)"
	                + "SELECT ?, stock_name, stock_type, unit, barcode, VAT_type, creation_date, description FROM product WHERE stock_code = ?";
			
			if(copyItem!= null) {
				try {
			
					preparedStatement = connect.prepareStatement(sql);
				
					preparedStatement.setString(1, copyItem);
					preparedStatement.setString(2, stockCode);
		        
					preparedStatement.executeUpdate();
		        
					return true;
				} catch (SQLException exception) {
					System.err.println(exception);
					return false;
				
				} finally {
					try {
						connect.close();
					
					} catch (SQLException exception) {
						System.err.println(exception);
					}
				}
			}
			return false;
		}
		
		public boolean Search(ProductEntiries productEntiries) throws SQLException {
				
				PreparedStatement preparedStatement = null;
				ResultSet resultSet = null;
				Connection connect = getConnection();
				
				String sql = "SELECT * FROM product WHERE stock_code = ?";
				
				try {
					preparedStatement = connect.prepareStatement(sql);
					
					preparedStatement.setString(1, productEntiries.getStockCode());
					resultSet = preparedStatement.executeQuery();
					
					if (resultSet.next()) {
						productEntiries.setStockCode(resultSet.getString("stock_code"));
						productEntiries.setStockName(resultSet.getString("stock_name"));
						productEntiries.setStockType(resultSet.getInt("stock_type"));
						productEntiries.setStockUnit(resultSet.getString("unit"));
						productEntiries.setStockBarcode(resultSet.getString("barcode"));
						productEntiries.setVatType(resultSet.getDouble("VAT_type"));
						productEntiries.setCreationDate(resultSet.getDate("creation_date"));
						productEntiries.setDescription(resultSet.getString("description"));
						
						return true;
					}
					return false;
				} catch (SQLException exception) {
					System.err.println(exception);
					return false;
					
				} finally {
					try {
						connect.close();
						
					} catch (SQLException exception) {
						System.err.println(exception);
					}
				}
		}
		
}