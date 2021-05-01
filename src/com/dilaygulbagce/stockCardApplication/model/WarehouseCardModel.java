package com.dilaygulbagce.stockCardApplication.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import com.dilaygulbagce.stockCardApplication.utility.DatabaseConnection;

public class WarehouseCardModel {
		
	private String warehouseID;
	private String warehouseCode;
	private String warehouseName;
	private String warehouseDescription;
	
	public String getWarehouseID() {
		return warehouseID;
	}
	public void setWarehouseID(String warehouseID) {
		this.warehouseID = warehouseID;
	}
	public String getWarehouseCode() {
		return warehouseCode;
	}
	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}
	public String getWarehouseName() {
		return warehouseName;
	}
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}
	public String getWarehouseDescription() {
		return warehouseDescription;
	}
	public void setWarehouseDescription(String warehouseDescription) {
		this.warehouseDescription = warehouseDescription;
	}
	
	@SuppressWarnings("rawtypes")
	public ArrayList<Vector> list() throws SQLException {
	
		ResultSet resultSet = null;
			
		ArrayList<Vector> warehouseCardList = new ArrayList<Vector>();
			
		String sql = "SELECT * FROM warehouse_card";
	
		try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(sql)) {
				
			resultSet = preparedStatement.executeQuery();
			
			ResultSetMetaData stData = resultSet.getMetaData();
				
			int dbColumnCount;
			dbColumnCount = stData.getColumnCount();
				
			while(resultSet.next()) {
				Vector<String> columnData = new Vector<String>();
					
				for(int i=1; i<dbColumnCount; i++) {
					columnData.add(resultSet.getString("warehouse_id"));
	                columnData.add(resultSet.getString("warehouse_code"));
	                columnData.add(resultSet.getString("warehouse_name"));
	                columnData.add(resultSet.getString("warehouse_description"));
				}
				warehouseCardList.add(columnData);
			}
			return warehouseCardList;
			
		} catch (SQLException exception) {
			System.err.println(exception);
			return null;
		} finally {
			DatabaseConnection.getConnection().close();
		}
	}

	public boolean insert() throws SQLException {
		
		String sql = "INSERT INTO warehouse_card (warehouse_id, warehouse_code, warehouse_name, warehouse_description) "
				+ "VALUES (?, ?, ?, ?)";

		try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(sql)) {
			
			preparedStatement.setString(1, getWarehouseID());
			preparedStatement.setString(2, getWarehouseCode());
			preparedStatement.setString(3, getWarehouseName());
			preparedStatement.setString(4, getWarehouseDescription());
			preparedStatement.execute();
			
			return true;
			
		} catch (SQLException exception) {
			System.err.println(exception);
			return false;
		} finally {
			DatabaseConnection.getConnection().close();
		}
	}
	
	public boolean delete() throws SQLException {
				
		String sql = "DELETE FROM warehouse_card WHERE warehouse_code = ?";
		
		try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(sql)) {
			
			preparedStatement.setString(1, getWarehouseCode());
			preparedStatement.execute();
			
			return true;
			
		} catch (SQLException exception) {
			System.err.println(exception);
			return false;
		} finally {
			DatabaseConnection.getConnection().close();
		}
	}
	
	public boolean update() throws SQLException {
				
		String sql = "UPDATE warehouse_card SET warehouse_name = ?, warehouse_description = ? WHERE warehouse_code = ?";
		
		try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(sql)) {
			
			preparedStatement.setString(1, getWarehouseName());
			preparedStatement.setString(2, getWarehouseDescription());
			preparedStatement.setString(3, getWarehouseCode());
			preparedStatement.execute();
			
			return true;
			
		} catch (SQLException exception) {
			System.err.println(exception);
			return false;
		} finally {
			DatabaseConnection.getConnection().close();
		}
	}
	
	public boolean search() throws SQLException {
		
		ResultSet resultSet = null;
		
		String sql = "SELECT * FROM warehouse_card WHERE warehouse_code = ?";
		
		try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(sql)) {
			
			preparedStatement.setString(1, getWarehouseCode());
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				setWarehouseCode(resultSet.getString("warehouse_code"));
				setWarehouseName(resultSet.getString("warehouse_name"));
				setWarehouseDescription(resultSet.getString("warehouse_description"));
				
				return true;
			}
			return false;
		} catch (SQLException exception) {
			System.err.println(exception);
			return false;
		} finally {
			DatabaseConnection.getConnection().close();
		}
	}
	
	public ArrayList<String> fillWarehouseCodeCombobox() throws SQLException {
		
		ResultSet resultSet = null;
			
		ArrayList<String> warehouseCodeList = new ArrayList<String>();
		warehouseCodeList.add(null);
			
		String sql = "SELECT warehouse_code FROM warehouse_card";
	
		try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(sql)) {
			resultSet = preparedStatement.executeQuery();
				
			while(resultSet.next()) {					
				warehouseCodeList.add(resultSet.getString("warehouse_code"));
			}
			return warehouseCodeList;
		} catch (SQLException exception) {
			System.err.println(exception);
			return null;
		} finally {
			DatabaseConnection.getConnection().close();
		}			
	}
}
