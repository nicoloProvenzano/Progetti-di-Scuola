/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listamultipla;

/**
 *
 * @author Nicolo'
 */
//quello della lista mltipla
public class NodoBidirezzionale {
    	
	protected int info;
	protected NodoBidirezzionale destra;
	protected NodoBidirezzionale sinistra;
        protected NodoBidirezzionale precedente;

	public NodoBidirezzionale(int info, NodoBidirezzionale destra,NodoBidirezzionale sinistra,NodoBidirezzionale prec ) {
		this.info = info;
		this.destra = destra;
		this.sinistra=sinistra;
	}

	public int getInfo() {
		return info;
	}

	public NodoBidirezzionale getDestra() {
		return destra;
	}

	public void setInfo(int info) {
		this.info = info;
	}

	public void setDestra(NodoBidirezzionale destra) {
		this.destra = destra;
	}

        public NodoBidirezzionale getSinistra() {
            return sinistra;
        }

        public void setSinistra(NodoBidirezzionale sinistra) {
            this.sinistra = sinistra;
        }

    public NodoBidirezzionale getPrecedente() {
        return precedente;
    }

    public void setPrecedente(NodoBidirezzionale precedente) {
        this.precedente = precedente;
    }
        
        
        

	@Override
	public String toString() {
		return "Nodo{" + "info=" + info + '}';
	}

}