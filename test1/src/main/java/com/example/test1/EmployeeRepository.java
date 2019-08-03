package com.example.test1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	@Query(value="select * from test3 where listno=?1", nativeQuery = true)
    public List<Employee> findById1(int listno);
	
	@Query(value="select * from test3 where todoname like %?1% AND complete=0 ORDER BY listno DESC", nativeQuery = true)
    public List<Employee> findById2(String todoname);
	
	@Query(value="select color from test3 where listno=?1", nativeQuery = true)
    public String findComp(int listno);
	
	@Query(value="select * from test3 where todoname=?1", nativeQuery = true)
    public List<Employee> findBe(String todoname);
	
	@Modifying
	@Transactional
	@Query(value = "update test3 t set"
			+ " t.todoname = :todoname,"
			+ " t.untildate = :untildate"
			+ " where t.listno = :listno", nativeQuery = true)

    public int update(@Param("todoname") String todoname,
    		@Param("untildate") String untildate,
    		@Param("listno") int listno);
	

	@Modifying
	@Transactional
	@Query(value = "update test3 t set"
			+ " t.complete = :complete,"
			+ " t.color = :color"
			+ " where t.listno = :listno", nativeQuery = true)
	public int update2(
			@Param("complete") int complete,
    		@Param("color") String color,
    		@Param("listno") int listno);
}
