package com.forex.wizard.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.forex.wizard.entity.Data;

@Component
public interface DataDao extends JpaRepository<Data, Long> {

	//Query to fetch the data by id
	@Query("SELECT d FROM Data d WHERE d.id = :id")
	public Data getDataById(@Param("id") long id);
	
	
	//Query to fetch the msgIdOfVipChannel of a signal which is stored in data table in database
	@Query("SELECT d.msgIdOfVipChannel FROM Data d WHERE d.id = :id")
	public int getTheVipMsgIdOfSignalPairById(@Param("id") long id);
	
	//Query to fetch the msgIdOfFreeChannel of a signal which is stored in data table in database
	@Query("SELECT d.msgIdOfFreeChannel FROM Data d WHERE d.id = :id")
	public int getTheFreeMsgIdOfSignalPairById(@Param("id") long id);
	
//	@Query("DELETE d FROM Data d WHERE d.id = :id")
//	public Data deleteDataById(@Param("id") long id);
}
