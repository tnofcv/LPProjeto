package projetoLP;


public class PilhaNos {
	
	//ATRIBUTOS
	
	NoTree noArvore;
    PilhaNos proximo;

    //ACESSORES
	public NoTree getnoArvore() {
		return noArvore;
	}

	public void setnoArvore(NoTree noArvore) {
		this.noArvore = noArvore;
	}

	public PilhaNos getProximo() {
		return proximo;
	}

	public void setProximo(PilhaNos proximo) {
		this.proximo = proximo;
	}
	
    //CONSTRUTORES
	
	public PilhaNos(NoTree noArvore) {
        this.noArvore = noArvore;
        proximo = null;
    }
}


