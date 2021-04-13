/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listabidirezzionale;

/**
 *
 * @author nicolo.provenzano
 */
//quello della lista bidirezzionale
public class NodoBidirezzionale {
	
	protected int info;
	protected NodoBidirezzionale successivo;
	protected NodoBidirezzionale precedente;

	public NodoBidirezzionale(int info, NodoBidirezzionale successivo,NodoBidirezzionale precedente) {
		this.info = info;
		this.successivo = successivo;
		this.precedente=precedente;
	}

	public int getInfo() {
		return info;
	}

	public NodoBidirezzionale getSuccessivo() {
		return successivo;
	}

	public void setInfo(int info) {
		this.info = info;
	}

	public void setSuccessivo(NodoBidirezzionale successivo) {
		this.successivo = successivo;
	}

	@Override
	public String toString() {
		return "Nodo{" + "info=" + info + ", link=" + successivo + '}';
	}

}
