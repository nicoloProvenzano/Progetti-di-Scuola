/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testcircularbuffer;

/**
 *
 * @author Nicolo'
 */
public class TestCircularBuffer
{
	private static MultipleBuffer<String> buffer;
	
	static class Producer extends Thread
	{
		private int n = 0;
		
		private String text;
		
		public Producer(String msg)
		{
			text = msg;
		}
		public void run()
		{
			String msg;
			while (true) try
			{	msg = produce();	    //produci un nuovo messaggio
				buffer.put(msg);		//ed inseriscilo nel buffer. 
			}
			catch (InterruptedException e) {}
		}
		private String produce()
		{
			try {sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {}
			n += 1;
			return text + n;
		}
	}
	static class Consumer extends Thread
	{
		public void run()
		{	
			String msg;
			while (true) try
			{	msg = buffer.take();	//preleva un messaggio dal
				consume(msg);		    //dal buffer e consumalo.
			}
			catch (InterruptedException e) {}
		}
		private void consume(String msg)
		{
			try {sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {}
			System.out.println(msg);
		}
	}
	public static void main(String[] args)
	{
		buffer = new CircularBuffer<String>(10);
		new Producer("TIZIO ").start();
		new Producer("            CAIO ").start();
		new Consumer().start();
		new Consumer().start();
	}
}
