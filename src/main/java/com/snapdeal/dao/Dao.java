package com.snapdeal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.snapdeal.dto.Labels;
import com.snapdeal.dto.SellerDetails;

public class Dao {

	private DataSource dataSourceShipping;
	private DataSource dataSourceLocal;
	
	public DataSource getDataSourceShipping() {
		return dataSourceShipping;
	}


	public DataSource getDataSourceLocal() {
		return dataSourceLocal;
	}


	public void setDataSourceLocal(DataSource dataSourceLocal) {
		this.dataSourceLocal = dataSourceLocal;
	}


	public void setDataSourceShipping(DataSource dataSourceShipping) {
		this.dataSourceShipping = dataSourceShipping;
	}

	public SellerDetails getSellerDetails( String code)
	{
		Connection connection = null;
		Statement statement = null;
		SellerDetails sellerDetails = null;
		try{
			connection = (Connection) dataSourceShipping.getConnection();
			statement = (Statement) connection.createStatement();
			String query = "Select vd.name as name,AES_DECRYPT(email,'725558a2c301795cccf2ed4b3bfd218baf16a6e9c0154c133051c60c5b74c188') as email,AES_DECRYPT(mobile,'725558a2c301795cccf2ed4b3bfd218baf16a6e9c0154c133051c60c5b74c188') as mobile,concat_ws(' ',address_line1,address_line2) as address , city,address_state," +
					"pin_code from vendor_contact as vc join vendor_detail as vd on vc.vendor_code = vd.code  where vendor_code = '"+ code +"' and vd.code = '"+ code +"' and contact_type = 4";
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()){
				sellerDetails = new SellerDetails();
				sellerDetails.setSellerName(resultSet.getString("name"));
				sellerDetails.setEmailId(resultSet.getString("email"));
				sellerDetails.setMobileNo(resultSet.getString("mobile"));
				sellerDetails.setAddress(resultSet.getString("address"));
				sellerDetails.setCity(resultSet.getString("city"));
				sellerDetails.setState(resultSet.getString("address_state"));
				sellerDetails.setPincode(resultSet.getString("pin_code"));
				break;
			}
			resultSet.close();
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sellerDetails;
	}
	
	public List<Labels> getLabels( )
	{
		Connection connection = null;
		Statement statement = null;
		List<Labels> labelList = new ArrayList<Labels>();
		try{
			connection = (Connection) dataSourceLocal.getConnection();
			statement = (Statement) connection.createStatement();
			System.out.println("sdbshubhds");
			String query = "select parameter as parameter,price from parameterPrice ";
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()){
//				sellerDetails = new SellerDetails();
				Labels labels = new Labels();
				labels.setParameterName(resultSet.getString("parameter"));
				labels.setPrice(resultSet.getDouble("price"));
				labelList.add(labels);
			}
			resultSet.close();
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return labelList;
	}
	
	
	
//	
//	public List<CcStatusDto> getCcStatusList()
//	{
//		Connection connection = null;
//		Statement statement = null;
//		List<CcStatusDto> ccStatusList = null;
//		try{
//			connection = (Connection) dataSourceRms.getConnection();
//			statement = (Statement) connection.createStatement();
//			ResultSet resultSet = statement.executeQuery("Select code, description from cc_status where code not in('DNE','CCREQ')");
//			ccStatusList = new ArrayList<CcStatusDto>();
//			while(resultSet.next()){
//				CcStatusDto ccStatusDto = new CcStatusDto();
//				ccStatusDto.setCode(resultSet.getString("code"));
//				ccStatusDto.setDescription(resultSet.getString("description"));
//				ccStatusList.add(ccStatusDto);
//			}
//			resultSet.close();
//		}catch(SQLException se){
//			se.printStackTrace();
//		}catch(Exception e){
//			//Handle errors for Class.forName
//			e.printStackTrace();
//		}
//		finally{
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return ccStatusList;
//	}
//	
//	public List<IssueCategoryDto> getIssueCategoryList()
//	{
//		Connection connection = null;
//		Statement statement = null;
//		List<IssueCategoryDto> issueCategoryList = null;
//		try{
//			connection = (Connection) dataSourceRms.getConnection();
//			statement = (Statement) connection.createStatement();
//			ResultSet resultSet = statement.executeQuery("Select code, description from issue_category");
//			issueCategoryList = new ArrayList<IssueCategoryDto>();
//			while(resultSet.next()){
//				IssueCategoryDto issueCategoryDto = new IssueCategoryDto();
//				issueCategoryDto.setCode(resultSet.getString("code"));
//				issueCategoryDto.setDescription(resultSet.getString("description"));
//				issueCategoryList.add(issueCategoryDto);
//			}
//			resultSet.close();
//		}catch(SQLException se){
//			se.printStackTrace();
//		}catch(Exception e){
//			//Handle errors for Class.forName
//			e.printStackTrace();
//		}
//		finally{
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return issueCategoryList;
//	}
}
