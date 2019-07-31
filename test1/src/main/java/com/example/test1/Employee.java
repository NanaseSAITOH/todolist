package com.example.test1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="test3")
public class Employee {
	@Id
    @Column(name="listno")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
    private String todoname;
    private String untildate;
    private String createdate;
    private Long complete;
    private String color;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTodoname() {
        return todoname;
    }
    public void setTodoname(String todoname) {
        this.todoname = todoname;
    }
    public String getUntildate() {
        return untildate;
    }
    public void setUntildate(String untildate) {
        this.untildate = untildate;
    }
    public String getCreatedate() {
        return createdate;
    }
    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }
    public String getComplete() {
    	try{
    	if(complete!=1) {
    		return("未完了");
    	}
    	}catch(NullPointerException e) {
    		return("未完了");
    	}
    	return("完了");
    }
    public void setComplete(Long complete) {
        this.complete = complete;
    }
    public String getColor() {
    	try{
    	if(!(color.equals("blue"))) {
    		return("background-color:salmon;");
    	}
    	}catch(NullPointerException e) {
    		return("background-color:salmon;");
    	}
    	return("background-color:blue;");
    }
    public void setColor(String color) {
        this.color = color;
    }
}