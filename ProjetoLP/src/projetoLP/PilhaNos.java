package projetoLP;


public class PilhaNos {
	
	//ATRIBUTOS
	
	NoTree treeNode;
    PilhaNos proximo;

    //ACESSORES
	public NoTree getTreeNode() {
		return treeNode;
	}

	public void setTreeNode(NoTree treeNode) {
		this.treeNode = treeNode;
	}

	public PilhaNos getProximo() {
		return proximo;
	}

	public void setProximo(PilhaNos proximo) {
		this.proximo = proximo;
	}
	
    //CONSTRUTORES
	
	public PilhaNos(NoTree treeNode)
    {
        this.treeNode = treeNode;
        proximo = null;
    }
    
   
}
