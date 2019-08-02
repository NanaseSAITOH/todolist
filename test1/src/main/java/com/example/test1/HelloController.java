package com.example.test1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class HelloController {
	
	int nowId=0;
    String message=null;
    String message2=null;
    String findWord=null;
    
    @Autowired
    EmployeeRepository empRepository; 
    @RequestMapping(value = "/",method = RequestMethod.GET)
    @Transactional
    public String index(Model model) {
    	List<Employee> emplist = empRepository.findAll(new Sort(Sort.Direction.DESC,"id"));
    	if(emplist.size()==0) {
    		message2="登録されたToDoはございません.";
    	}
    	model.addAttribute("msg",message2);
        model.addAttribute("employeelist", emplist);
        return "index";
    }   
    @RequestMapping(value = "/search",method = RequestMethod.GET)
    @Transactional
    public String search(Model model) {
        return "search";
    }
    @RequestMapping(value = "testform",method = RequestMethod.GET)
	public String text1(
			@RequestParam(name = "text1") String text1,
			@RequestParam(name = "year") String year,
			@RequestParam(name = "month") String month,
			@RequestParam(name = "day") String day,
		Model model) {
    	String Date = year+"-"+month+"-"+day;
		Employee n = new Employee();
		Escape escape = new Escape();
		if(!(escape.error(text1).equals(""))) {
			List<Employee> emplist = empRepository.findAll(new Sort(Sort.Direction.DESC,"id"));
	    	model.addAttribute("msg","エラー");
	        model.addAttribute("employeelist", emplist);
			return "index";
		}
		List<Employee> findlist=empRepository.findBe(text1);
		if(findlist.size()!=0) {
			model.addAttribute("msg","すでにToDoが存在します.");
			List<Employee> emplist=empRepository.findAll(new Sort(Sort.Direction.DESC,"id"));
	        model.addAttribute("employeelist", emplist);
			return "index";
		}else {
			
		}
		text1=escape.change(text1);
		n.setTodoname(text1);
		n.setUntildate(Date);
		n.setColor("red");
		Long i =(long) 0;
		n.setComplete(i);
		LocalDate d = LocalDate.now();
		DateTimeFormatter df1 = 
				DateTimeFormatter.ofPattern("yyyy-MM-dd");
		n.setCreatedate(df1.format(d));
		empRepository.save(n);
		List<Employee> emplist=empRepository.findAll(new Sort(Sort.Direction.DESC,"id"));
        model.addAttribute("employeelist", emplist);
		return "index";
	}
    @RequestMapping(value = "change",method = RequestMethod.GET)
	public String change(@RequestParam("id")Integer id,
		Model model) {
    	List<Employee> emplist=empRepository.findById1(id);
        model.addAttribute("employeelist", emplist);
        nowId=id;
		return "change";
	}
    @RequestMapping(value = "searchcomplete",method = RequestMethod.GET)
	public String searchcomplete(
			@RequestParam("colorid")Integer colorid,
			Model model) {
    	try {
    	if(empRepository.findComp(colorid).equals("blue")) {
    	empRepository.update2(0,"red",colorid);
    	}else {
    	empRepository.update2(1,"blue",colorid);
    	}
    	}catch(NullPointerException e) {
    	empRepository.update2(1,"blue",colorid);
    	}
    	
    	List<Employee> emplist=empRepository.findById2(findWord);
        model.addAttribute("employeelist", emplist);
		return "search";
	}
    @RequestMapping(value = "ch",method = RequestMethod.GET)
	public String ch(
			@RequestParam(name = "text1") String text1,
			@RequestParam(name = "year") String year,
			@RequestParam(name = "month") String month,
			@RequestParam(name = "day") String day,
			Model model) {
    	String Date = year+"-"+month+"-"+day;
    	Escape escape = new Escape();
    	if(!(escape.error(text1).equals(""))) {
	    	model.addAttribute("msg","エラー");
	    	List<Employee> emplist=empRepository.findById1(nowId);
	        model.addAttribute("employeelist", emplist);
			return "change";
		}
    	empRepository.update(text1,Date,nowId);
    	List<Employee> emplist=empRepository.findAll(new Sort(Sort.Direction.DESC,"id"));
        model.addAttribute("employeelist", emplist);
		return "index";
	}
    @RequestMapping(value = "complete",method = RequestMethod.GET)
	public String complete(
			@RequestParam("colorid")Integer colorid,
			Model model) {
    	try {
    	if(empRepository.findComp(colorid).equals("blue")) {
    	empRepository.update2(0,"red",colorid);
    	}else {
    	empRepository.update2(1,"blue",colorid);
    	}
    	}catch(NullPointerException e) {
    	empRepository.update2(1,"blue",colorid);
    	}
    	
    	List<Employee> emplist=empRepository.findAll(new Sort(Sort.Direction.DESC,"id"));
        model.addAttribute("employeelist", emplist);
		return "index";
	}
    @RequestMapping(value = "se",method = RequestMethod.GET)
	public String search(@RequestParam(name = "text1") String text1,
		Model model) {
    	findWord=text1;
    	Escape escape = new Escape();
    	text1=escape.change(text1);
    	List<Employee> emplist=empRepository.findById2(text1);
        model.addAttribute("employeelist", emplist);
        if(CollectionUtils.isEmpty(emplist)) {
        	System.out.println("empty");
        	message="対象のToDoは見つかりません.";
        }else {
        	message="ToDoが"+emplist.size()+"件見つかりました";
        }
        model.addAttribute("msg",message);
		return "search";
	}
    public void sortAll(){
    	
    }
    /*
     * CREATE TABLE `test3` (
  `listno` bigint(20) NOT NULL AUTO_INCREMENT,
  `todoname` varchar(31) NOT NULL DEFAULT "TODO",
  `untildate` varchar(10) NOT NULL DEFAULT "2018-01-01",
  `createdate` varchar(10) NOT NULL DEFAULT "2018-01-01",
  `complete` boolean NOT NULL DEFAULT 0 ,
  `color` varchar(10) NOT NULL DEFAULT "red",
  PRIMARY KEY (`listno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
sudo vi /etc/my.cnf
+ [mysqld]
+ character_set_server=utf8

insert into ASA.test
(todoname,untildate,complete)
values
('従業員A','10101001',0)
,('従業員B','10101001',0)
,('従業員C','10101002',0)
,('従業員D','10101003',0)
     * 
     */   
}
