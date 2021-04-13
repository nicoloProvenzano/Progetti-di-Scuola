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
public interface MultipleBuffer<E>
{
/*	Preleva e restituisce il primo elemento inserito nel buffer
	ma non ancora prelevato. Se il buffer è vuoto, blocca il thread
	invocante fino all'inserimento nel buffer di un nuovo elemento
	da parte di un altro thread. Questo metodo può sollevare una
	eccezione di classe InterruptedException.
*/
	E take() throws InterruptedException;
/*
	Inserisce nel buffer un nuovo elemento. Se il buffer è pieno,
	blocca il thread invocante fino al prelevamento dal buffer di
	un elemento da parte di un altro thread. Questo metodo può
	sollevare una eccezione di classe InterruptedException.
*/	
	void put(E e) throws InterruptedException;
}
