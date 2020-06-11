package projetoLP;

import java.util.EmptyStackException;

public class ExpreTree{
	//ATRIBUTOS
	
    private static PilhaNos top;
 
    //ACESSORES
    
    public static PilhaNos getTop() {
		return top;
	}
    
	public static void setTop(PilhaNos top) {
		ExpreTree.top = top;
	}
    
    //CONSTRUTOR
    public ExpreTree()
    {
        top = null;
    }
    
    public boolean estaVazia() {
		return top==null;
	}
 
	//Fun��o para limpar a pilha onde s�o guardados os dados
    public void clear()
    {
        top = null;
    }
 
    //Fun��o para adicionar um numero ou operador � pilha
    private void push(NoTree ptr)
    {
        if (estaVazia())
            top = new PilhaNos(ptr);
        else
        {
            PilhaNos nptr = new PilhaNos(ptr);
            nptr.proximo = top;
            top = nptr;
        }
    }
 
    //Fun��o para remover um numero ou operador da pilha
    private NoTree pop()
    {
        if (top == null)
            throw new EmptyStackException();
        else
        {
            NoTree ptr = top.treeNode;
            top = top.proximo;
            return ptr;
        }
    }
 
    //Fun��o para olhar para o topo da pilha
    public NoTree obter() {
		if(estaVazia()) {
			throw new EmptyStackException();
		}else {
			return top.treeNode;	
		}
	}


}