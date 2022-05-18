package com.vtest.dataObjects;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.vtest.constants.PageConstant;
import com.vtest.reusemethods.ExcelParserUtil;


/**
 * 
 * @author ThulasiPrasad
 *
 */
public class ContactusDO {
	
	
	private static final ExcelParserUtil xlsParser = new ExcelParserUtil(PageConstant.LEADTESTDATA, "Contactus");
	
	private String name;
	private String companyName;
	private String emailAddress;
	private String phoneNumber;
	private String requirementDescription;
	
	public void loadContactus(int rowNumber){
		
		try
		{
			this.setName(xlsParser.getExcelData(rowNumber, 1));
			this.setCompanyName(xlsParser.getExcelData(rowNumber, 2));
			this.setEmailAddress(xlsParser.getExcelData(rowNumber, 3));
			this.setPhoneNumber(xlsParser.getExcelData(rowNumber, 4));
			this.setComments(xlsParser.getExcelData(rowNumber, 5));
		}
		catch (InvalidFormatException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRequirementDescription() {
		return requirementDescription;
	}

	public void setComments(String requirementDescription) {
		this.requirementDescription = requirementDescription;
	}

}
