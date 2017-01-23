package tests;

import static org.junit.Assert.*;

import classes.Cell;

import org.junit.Test;

public class CellTest {
	
	@Test
	public void cellShouldHaveLiveNeighboards(){
		Cell c = new Cell(0, 0, true);
		Cell x = new Cell(0, 1, true);
		Cell[][] cells = new Cell[3][3];
		cells[0][0]=c;
		cells[0][1]=x;
		c.setNumberOfAliveNeighbors(cells);
		assertEquals(1, c.getNumberOfAliveNeighbords());
	}
	
	@Test
	public void cellShouldNotHaveLiveNeighboards(){
		Cell c = new Cell(0, 0, true);
		Cell x = new Cell(2, 0, true);
		Cell[][] cells = new Cell[3][3];
		cells[0][0]=c;
		cells[0][1]=x;
		c.setNumberOfAliveNeighbors(cells);
		assertEquals(0, c.getNumberOfAliveNeighbords());
	}
	
	
	@Test
	public void liveCellWith2or3LiveNeighborsShouldSurvive() {
		Cell c = new Cell(0, 0, true);
		Cell x = new Cell(0, 1, true);
		Cell y = new Cell(1, 0, true);
		Cell z = new Cell(0, 2, true);
		Cell[][] cells = new Cell[3][3];
		cells[0][0]=c;
		cells[0][1]=x;
		cells[1][0]=y;
		cells[0][2]=z;
		c.setNumberOfAliveNeighbors(cells);
		assertTrue(c.willSurvive());
		assertFalse(c.willDie());
		assertFalse(c.willRevive());
	}
	
	@Test
	public void liveCellWithMoreThan3LiveNeighborsShouldDie(){
		Cell c = new Cell(2, 2, true);
		Cell x = new Cell(2, 1, true);
		Cell y = new Cell(2, 3, true);
		Cell w = new Cell(1, 2, true);
		Cell z = new Cell(1, 3, true);
		Cell[][] cells = new Cell[4][4];
		cells[2][2]=c;
		cells[2][1]=x;
		cells[2][3]=y;
		cells[1][2]=w;
		cells[1][3]=z;
		c.setNumberOfAliveNeighbors(cells);
		assertTrue(c.willDie());
		assertFalse(c.willSurvive());
		assertFalse(c.willRevive());
	}
	
	@Test
	public void liveCellWithFewerThen2LiveNeighboardsShouldDie(){
		Cell c = new Cell(2, 2, true);
		Cell x = new Cell(2, 1, true);
		Cell[][] cells = new Cell[3][3];
		cells[2][2]=c;
		cells[2][1]=x;
		c.setNumberOfAliveNeighbors(cells);
		assertTrue(c.willDie());		
		assertFalse(c.willSurvive());
		assertFalse(c.willRevive());
	}
	
	@Test
	public void deadCellWith3LiveNeighboardsShouldRevive(){
		Cell c = new Cell(2, 2, false);
		Cell x = new Cell(2, 1, true);
		Cell y = new Cell(2, 3, true);
		Cell z = new Cell(1, 2, true);
		Cell[][] cells = new Cell[4][4];
		cells[2][2]=c;
		cells[2][1]=x;
		cells[2][3]=y;
		cells[1][2]=z;
		c.setNumberOfAliveNeighbors(cells);
		assertTrue(c.willRevive());
		assertFalse(c.willDie());
		assertFalse(c.willSurvive());
	}
	

}
