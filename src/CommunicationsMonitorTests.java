package src;

import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;


public class CommunicationsMonitorTests {
	
	
	static int communications1[][] = {
			{1,2,2},
			{2,3,2},
			{3,4,5},
			{3,5,7},
			{4,6,8},
			{2,7,9},
			{6,9,11},
			{6,10,11},
			{7,11,13},
			{6,8,13},
			{8,12,14}
	};
	
	static int communications2[][] = {
			{1,2,1},
			{1,3,5},
			{2,3,6},
			{2,4,7},
			{1,5,7},
			{2,1,8},
			{3,4,8},
			{4,5,8},
			{5,6,9},
			{3,7,9},
			{4,8,10},
			{5,9,13},
			{9,10,12},
			{8,10,12},
			{11,12,13},
			{11,13,13},
			{13,14,16},
			{13,15, 16},
			{14,12,94},
	};
	
	@Test
	public void query1a(){
		CommunicationsMonitor comMonitor1 = new CommunicationsMonitor();
		int i;
		for(i=0 ; i<communications1.length ; i++ ){
			comMonitor1.addCommunication(communications1[i][0], communications1[i][1], communications1[i][2]);
		}
		
		comMonitor1.createGraph();
				
		List<ComputerNode> path = comMonitor1.queryInfection(1, 7, 1, 9);
		System.out.println("Test query1a found the following infection path:");
		for(i=0 ; i<path.size() ; i++){
			System.out.println(path.get(i).toString());
		} // prints path in the form (c, t)
		System.out.println();
		String expected[] = { "(1, 2)", "(2, 2)", "(2, 9)", "(7, 9)"};
		assertArrayEquals(expected, listToStringArr(path));
	}
	
	@Test
	public void query1b(){
		CommunicationsMonitor comMonitor1 = new CommunicationsMonitor();
		int i;
		for(i=0 ; i<communications1.length ; i++ ){
			comMonitor1.addCommunication(communications1[i][0], communications1[i][1], communications1[i][2]);
		}
		
		comMonitor1.createGraph();
				
		List<ComputerNode> path = comMonitor1.queryInfection(3, 12, 4, 15);
		System.out.println("Test query1b found the following infection path:");
		for(i=0 ; i<path.size() ; i++){
			System.out.println(path.get(i).toString());
		} // prints path in the form (c, t)
		System.out.println();
		String expected[] = { "(3, 5)", "(4, 5)", "(4, 8)", "(6, 8)", "(6, 13)", "(8, 13)", "(8, 14)", "(12, 14)"};
		assertArrayEquals(expected, listToStringArr(path));
	}
	
	@Test
	public void query1c(){
		CommunicationsMonitor comMonitor1 = new CommunicationsMonitor();
		int i;
		for(i=0 ; i<communications1.length ; i++ ){
			comMonitor1.addCommunication(communications1[i][0], communications1[i][1], communications1[i][2]);
		}
		
		comMonitor1.createGraph();
				
		List<ComputerNode> path = comMonitor1.queryInfection(2, 9, 1, 7);
		
		assertEquals(null, path); 
	}
	
	@Test
	public void query1d(){
		CommunicationsMonitor comMonitor1 = new CommunicationsMonitor();
		int i;
		for(i=0 ; i<communications1.length ; i++ ){
			comMonitor1.addCommunication(communications1[i][0], communications1[i][1], communications1[i][2]);
		}
		
		comMonitor1.createGraph();
				
		List<ComputerNode> path = comMonitor1.queryInfection(1, 11, 1, 9);
				
		assertEquals(null, path); 
	}
	
	@Test
	public void query2a(){
		CommunicationsMonitor comMonitor2 = new CommunicationsMonitor();
		int i;
		for(i=0 ; i<communications2.length ; i++ ){
			comMonitor2.addCommunication(communications2[i][0], communications2[i][1], communications2[i][2]);
		}
		
		comMonitor2.createGraph();
				
		List<ComputerNode> path = comMonitor2.queryInfection(1, 10, 1, 12);
		System.out.println("Test query2a found the following infection path:");
		for(i=0 ; i<path.size() ; i++){
			System.out.println(path.get(i).toString());
		} // prints path in the form (c, t)
		System.out.println();
		
		String expected1[] = { "(1, 1)", "(2, 1)", "(2, 6)", "(3, 6)", "(3, 8)", "(4, 8)", "(4, 10)", 
								"(8, 10)", "(8, 12)", "(10, 12)"};
		String expected2[] = { "(1, 1)", "(2, 1)", "(2, 6)", "(2, 7)", "(4, 7)", "(4, 8)", "(4, 10)", 
				"(8, 10)", "(8, 12)", "(10, 12)"};
		
		assertTrue(Arrays.equals(expected1, listToStringArr(path)) || Arrays.equals(expected2, listToStringArr(path)));
	}
	
	
	
	public String[] listToStringArr(List<ComputerNode> list){
		String strArr[] = new String[list.size()];
		int i;
		for(i=0 ; i<list.size() ; i++){
			strArr[i] = list.get(i).toString();
		}
		return strArr;
	}

}
