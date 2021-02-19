import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Table(name = "Employee")
public class POJO 
{
	@Id
	private int eid;
	@Column
	private String ename;
	@Column
	private String email;
	@Override
	public String toString() {
		return "POJO [eid=" + eid + ", ename=" + ename + ", email=" + email + "]";
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
