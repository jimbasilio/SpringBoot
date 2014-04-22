package jim.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hello")
public class HelloEntity {

	@Id
	Long id;
	
	@Column(name = "my_hello", nullable=false)
	String myHello;

	public String getMyHello() {
		return myHello;
	}

	public void setMyHello(String myHello) {
		this.myHello = myHello;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
