package com.ltts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ltts.configuration.MyConnection;
import com.ltts.model.Player;
import com.ltts.model.Team;

public class PlayerDao {
	
	public boolean insertPlayer(Player p) throws Exception {
		Connection mc=MyConnection.getConnection();
		PreparedStatement ps=mc.prepareStatement("insert into player values(?,?,?,?,?)");
		ps.setString(1, p.getName());
		ps.setString(2, p.getDob());
		ps.setInt(3, p.getMatches());
		ps.setInt(4, p.getRuns());
		ps.setInt(5, p.getWickets());
		return ps.execute();
	}
	
	public Player getPlayerByName(String name) throws Exception {
		Player p=new Player();
		List<Player> li=getAllPlayers();
		for(Player p1:li) {
			if(p1.getName() == name) {
				p.setName(name);
				p.setDob(p1.getDob());
				p.setMatches(p1.getMatches());
				p.setRuns(p1.getRuns());
				p.setWickets(p1.getMatches());
			}
		}
		return p;
	}
	
	public boolean updatePlayer(Player p) throws Exception {
		Connection mc=MyConnection.getConnection();
		Statement s = mc.createStatement();
		PreparedStatement ps=mc.prepareStatement("update player set runs = (?), wickets = (?), matches = (?) where name = (?) ; ");	
		ResultSet rs = s.executeQuery("select * from player");
		ps.setInt(1,p.getRuns());
		ps.setInt(2,p.getWickets());
		ps.setInt(3, p.getMatches());
		ps.setString(3, p.getName());
		boolean rs1 = ps.execute();
		return rs1;
	}
	
	public boolean deletePlayer(Player p) throws Exception {
		Connection mc=MyConnection.getConnection();
		Statement s = mc.createStatement();
		PreparedStatement ps=mc.prepareStatement("delete from player where Name = (?); ");
		//ResultSet rs = s.executeQuery("select * from player");	
		ps.setString(1,p.getName());
		boolean rs = ps.execute();
		return rs;
	}
	
	public List<Player> getAllPlayers() throws Exception{
		List<Player> li=new ArrayList<Player>();
		Connection mc=MyConnection.getConnection(); 
		Statement ps=mc.createStatement();
		ResultSet rs=ps.executeQuery("select * from player");
		//Player p=new Player();
		while(rs.next()) {
			li.add(new Player(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5)));	
		}
		return li;
	}	
}