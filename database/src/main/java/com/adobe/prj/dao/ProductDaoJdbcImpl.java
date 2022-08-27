package com.adobe.prj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.adobe.prj.entity.Product;

public class ProductDaoJdbcImpl implements ProductDao {
	private static String DRIVER  = Messages.getString("DRIVER");	 //$NON-NLS-1$
	private static String URL = Messages.getString("URL"); //$NON-NLS-1$
	private static String USER = Messages.getString("USER"); //$NON-NLS-1$
	private static String PWD = Messages.getString("PWD"); //$NON-NLS-1$
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	 
	@Override
	public void addProduct(Product p) throws DaoException {
		String SQL = "INSERT INTO products (id, name, price, quantity) VALUES (0, ?, ?, ?)"; //$NON-NLS-1$
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PWD);
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setString(1, p.getName());
			ps.setDouble(2, p.getPrice());
			ps.setInt(3, p.getQuantity());
			ps.executeUpdate(); // INSERT, DELETE, UPDATE
		} catch (SQLException e) {
			if(e.getErrorCode() == 1062) {
				throw new DaoException("product with id " + p.getId() + " already exist!!",  e); //$NON-NLS-1$ //$NON-NLS-2$
			} else
			throw new DaoException(Messages.getString("PRD_NOT_AVILABLE_MSG"), e); //$NON-NLS-1$
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public List<Product> getProducts() throws DaoException {
		List<Product> products = new ArrayList<>();
		String SQL = "SELECT id, name, price, quantity FROM products"; //$NON-NLS-1$
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PWD);
			Statement stmt = con.createStatement();
			ResultSet rs  = stmt.executeQuery(SQL); // SELECT
			while(rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("ID")); //$NON-NLS-1$
				p.setName(rs.getString("NAME")); //$NON-NLS-1$
				p.setPrice(rs.getDouble("PRICE")); //$NON-NLS-1$
				p.setQuantity(rs.getInt("QUANTITY")); //$NON-NLS-1$
				products.add(p);
			}
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
			throw new DaoException("unable to get products", e); //$NON-NLS-1$
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return products;
	}

	@Override
	public Product getProduct(int id) throws DaoException {
		// TODO
		String SQL = "SELECT id, name, price, quantity FROM products WHERE id = ?";  //$NON-NLS-1$
		return null;
	}

}
