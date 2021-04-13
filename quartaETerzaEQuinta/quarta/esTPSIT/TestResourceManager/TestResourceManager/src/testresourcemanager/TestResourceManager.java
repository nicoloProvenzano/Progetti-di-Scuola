/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testresourcemanager;

/**
 *
 * @author Nicolo'
 */
public class TestResourceManager
{
	static int NUM_READERS = 10;
	static int NUM_WRITERS = 10;
	static long MAX_WRITE_TIME = 1000;
	static long MAX_READ_TIME  = 1000;
	
	static class Writer extends Thread
	{
		public Writer(String name)
		{
			super(name);
		}
		public void run()
		{
			while (true) try
			{	sleep((long) (Math.random() * MAX_READ_TIME));
				r.beginWrite();
				System.out.println("\t\t\tINIZIO " + this.getName());
				sleep((long) (Math.random() * MAX_WRITE_TIME));
				System.out.println("\t\t\tFINE   " + this.getName());
				r.endWrite();
			}
			catch (InterruptedException e) {}
		}
	}
	static class Reader extends Thread
	{
		public Reader(String name)
		{
			super(name);
		}
		public void run()
		{	
			while (true) try
			{	r.beginRead();
				System.out.println("INIZIO " + this.getName());
				sleep((long) (Math.random() * MAX_READ_TIME));
				System.out.println("FINE   " + this.getName());
				r.endRead();
				sleep((long) (Math.random() * MAX_WRITE_TIME));
			}
			catch (InterruptedException e) {}
		}
	}
	static ResourceManager r;
	
	public static void main(String[] args)
	{
		r = new ResourceManager();
		for (int i = 1; i <= NUM_READERS; i++)
			new Reader("LETTORE " + i).start();
		for (int i = 1; i <= NUM_WRITERS; i++)
			new Writer("SCRITTORE " + i).start();
	}
}
