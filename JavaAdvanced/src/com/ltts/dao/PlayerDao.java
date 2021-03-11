package com.ltts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ltts.configuration.MyConnection;
import com.ltts.model.Player;

public class PlayerDao {
	
	public boolean insertPlayer(Player p) throws Exception {
		//fill your code
		Connection mc=MyConnection.getConnection(); // TRanfers control to another 
		PreparedStatement ps=mc.prepareStatement("insert into web_player values(?,?,?,?,?)");
		
		ps.setString(1, p.getName());
		ps.setString(2, p.getDob());
		ps.setInt(3, p.getMatches());
		ps.setInt(4, p.getRuns());
		ps.setInt(5, p.getWickets());
		
		return ps.execute();
	}
	
	public List<Player> getAllPlayers() throws Exception{
		List<Player> li=new ArrayList<Player>();
		Connection mc=MyConnection.getConnection(); // TRanfers control to another 
		Statement ps=mc.createStatement();
		ResultSet rs=ps.executeQuery("select * from web_player");
		//Player p=new Player();
		while(rs.next()) {
			li.add(new Player(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5)));
			
		}
		return li;
		
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

}
