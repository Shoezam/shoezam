package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints= {@UniqueConstraint(columnNames= {"email", "pass"})})
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userIdSequence")
	@SequenceGenerator(name="userIdSequence", allocationSize=1, sequenceName="SEQ_USER_ID")
	@Column(name="CLIENT_ID")
	private Integer id;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String email;
	@Column
	private String pass;
	@Column
	private String address;
	@Column
	private Integer postalCode;
	@Column
	private String country;
	@Column
	private String phoneNumber;
	@Column
	@org.hibernate.annotations.Type(type="true_false")
	private Boolean isAdmin;
	
	
	/** Constructor with no fields for failed logins */
	public Client() {
		super();
	}
	/** Constructor with only email and password for generating bean with login data*/
	public Client(String email, String pass) {
		super();
		this.email	= email;
		this.pass	= pass;
	}
	
	public Client(String firstName, String lastName, String email, String pass, String address, Integer postalCode,
			String country, String phoneNumber) {
		super();
		this.firstName		= firstName;
		this.lastName		= lastName;
		this.email			= email;
		this.pass			= pass;
		this.address		= address;
		this.postalCode		= postalCode;
		this.country		= country;
		this.phoneNumber	= phoneNumber;
	}
	/** Constructor with all fields is used for generating a bean with data from the DB.*/
	public Client(Integer userid, String firstName, String lastName, String email, String pass, String address,
			Integer postalCode, String country, String phoneNumber, Boolean isAdmin) {
		super();
		this.id			= userid;
		this.firstName		= firstName;
		this.lastName		= lastName;
		this.email			= email;
		this.pass			= pass;
		this.address		= address;
		this.postalCode		= postalCode;
		this.country		= country;
		this.phoneNumber	= phoneNumber;
		this.isAdmin		= isAdmin;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result	= prime * result + ((address == null) ? 0 : address.hashCode());
		result	= prime * result + ((country == null) ? 0 : country.hashCode());
		result	= prime * result + ((email == null) ? 0 : email.hashCode());
		result	= prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result	= prime * result + ((isAdmin == null) ? 0 : isAdmin.hashCode());
		result	= prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result	= prime * result + ((pass == null) ? 0 : pass.hashCode());
		result	= prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result	= prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
		result	= prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (isAdmin == null) {
			if (other.isAdmin != null)
				return false;
		} else if (!isAdmin.equals(other.isAdmin))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (postalCode == null) {
			if (other.postalCode != null)
				return false;
		} else if (!postalCode.equals(other.postalCode))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [userid=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", pass=" + pass + ", address=" + address + ", postalCode=" + postalCode + ", country=" + country
				+ ", phoneNumber=" + phoneNumber + ", isAdmin=" + isAdmin + "]";
	}
	public Integer getUserid() {
		return id;
	}
	public void setUserid(Integer userid) {
		this.id = userid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
