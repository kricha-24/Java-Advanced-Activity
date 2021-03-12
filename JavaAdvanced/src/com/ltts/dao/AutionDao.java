package com.ltts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ltts.configuration.*;
import com.ltts.model.*;

public class AutionDao {
	public Aution getAutionById(int id) throws Exception {
		Aution p=new Aution();
		List<Aution> li= getAllAutions();
		for(Aution p1:li) {
			if(p1.getAutionId() == id) {
				p.setAutionId(id);
				p.setPlayerID(p1.getPlayerID());
				p.setTeamId(p1.getTeamId());
				p.setYear(p1.getYear());
				p.setPrice(p1.getPrice());
			}
		}
		return p;
	}
	
	public boolean insertAution(Aution a, Player p, Team t) throws Exception {
		Connection mc=MyConnection.getConnection();
		Statement s = mc.createStatement();
		PreparedStatement ps=mc.prepareStatement("insert into auction values (?,?,?,?,?)");
		//ResultSet rs = s.executeQuery("select * from aution");
		System.out.println("Aution Id is inserted");
		//ps.executeUpdate();
		ps.setInt(1,a.getAutionId());
		ps.setString(2,p.getName());
		ps.setInt(3,t.getTeamId());
		ps.setString(4,a.getYear());
		ps.setDouble(5,a.getPrice());		
		//ResultSet rs =s.executeQuery(null);
		//return s.execute(null);
		return ps.execute();
	}
	
	public boolean updateAution(Aution a) throws Exception {
		Connection mc=MyConnection.getConnection();
		Statement s = mc.createStatement();		
		PreparedStatement ps=mc.prepareStatement("update aution  set price = (?)  where autionId = (?); ");		
		//ResultSet rs = s.executeQuery("select * from aution");
		ps.setDouble(1,a.getPrice());
		ps.setInt(2,a.getAutionId());		
		boolean rs = ps.execute();
	    return rs;
	}
	
	public boolean deleteAution(Aution p) throws Exception {
		Connection mc=MyConnection.getConnection();
		Statement s = mc.createStatement();		
		PreparedStatement ps=mc.prepareStatement("delete from aution where autionId = (?); ");		
		//ResultSet rs = s.executeQuery("select * from aution");		
		ps.setInt(1,p.getAutionId());		
		boolean rs = ps.execute();	    
		return rs;
	}
	
	public List<Aution> getAllAutions() throws Exception{
	List<Aution> li=new ArrayList<Aution>();
	Connection mc=MyConnection.getConnection();
	Statement ps = mc.createStatement();
	ResultSet rs = ps.executeQuery("select * from aution;");
	while(rs.next()){
		li.add(new Aution(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getInt(5)));
	}	
	return li;
	}
}