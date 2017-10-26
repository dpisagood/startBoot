package cn.iamdp.startBoot.jpa.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * 用户实体类
 * @author DP
 *
 */
@Entity(name="boot_user")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")    
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid") //hibernate提供的主键生成策略 
	private String id;
	
	@Column(name="userName",length=36,nullable=false)
	private String userName;
	
	@Column(name="passWord",length=36,nullable=false)
	private String passWord;
	
	@Column(name="email",length=36,nullable=false)
	private String email;
	
	@Column(name="nickName",length=36,nullable=false)
	private String nickName;
	
	@Column(name="company",length=36,nullable=true)
	private String company;
	
	/**
	 * 不更新的时间戳，
	 */
	@Column(name="createTime",updatable = false)
	@org.hibernate.annotations.CreationTimestamp 
	@Temporal(TemporalType.TIMESTAMP)  
	private Date createTime;
	
	/**
	 * 更新的时间戳
	 */
	@Column(name="updateTime")  
	@org.hibernate.annotations.UpdateTimestamp  
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTime;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", email=" + email
				+ ", nickName=" + nickName + ", company=" + company + ", createTime=" + createTime + ", updateTime="
				+ updateTime + "]";
	}
	
}
