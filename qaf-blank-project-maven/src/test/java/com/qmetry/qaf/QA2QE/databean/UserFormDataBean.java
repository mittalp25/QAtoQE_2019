package com.qmetry.qaf.QA2QE.databean;

import java.util.Date;

import com.qmetry.qaf.automation.data.BaseDataBean;
import com.qmetry.qaf.automation.util.RandomStringGenerator.RandomizerTypes;
import com.qmetry.qaf.automation.util.Randomizer;

public class UserFormDataBean extends BaseDataBean{

	@Randomizer()
	private String fName;
	@Randomizer
	private String lName;
	
	@Randomizer(type=RandomizerTypes.LETTERS_ONLY, minval=-720, maxval=-0)
	private Date doj;
	
	@Randomizer(type=RandomizerTypes.LETTERS_ONLY, minval=20, maxval=65)
	private int age;
	
	@Randomizer(dataset={"Male","Female"})
	private String gender;
	
	@Randomizer(suffix="@domain.com")
	private String email;

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public Date getDoj() {
		return doj;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public static void main(String[] args) {
		String json = "{'age':25,'fName':'ABC','doJ':1}";
		UserFormDataBean bean = new UserFormDataBean();
		
		//bean.fillRandomData();
		bean.fillData("data.register.user");

		System.out.println(bean);
	}
}
