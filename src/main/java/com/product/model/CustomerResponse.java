package com.product.model;

import java.util.Calendar;
import java.util.Date;
import lombok.Data;

@Data
public class CustomerResponse {

	public int custId;
	
	private String firstName;

	private String lastName;

	private Date joiningDate;

	private Date expiryDate;

	private Address address;
	
	private Status status;

	public enum Status {
		NEW, EXPERIENCED, EXPIRED, INVALID;
	}

	public Status setStatus(Date joiningDate, Date expiryDate) {

		Calendar c = Calendar.getInstance();
		Date currentDate = c.getTime();

		c.setTime(joiningDate);
		c.add(Calendar.YEAR, 2);
		Date experienceDate = c.getTime();

		if ((currentDate.after(expiryDate)))
			status = Status.EXPIRED;
		else if (currentDate.after(experienceDate))
			status = Status.EXPERIENCED;
		else if (currentDate.before(experienceDate))
			status = Status.NEW;
		else
			status = Status.INVALID;
		return status;
	}

}
