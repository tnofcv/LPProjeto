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
 
	//Função para limpar a pilha onde são guardados os dados
    public void clear()
    {
        top = null;
    }
 
    //Função para adicionar um numero ou operador à pilha
    public void push(NoTree ptr)
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
 
    //Função para remover um numero ou operador da pilha
    public NoTree pop()
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
 
    //Função para olhar para o topo da pilha
    public NoTree obter() {
		if(estaVazia()) {
			throw new EmptyStackException();
		}else {
			return top.treeNode;	
		}
	}
	
    //Função para verificar se é um digito
    public boolean eDigito(char ch)
    {
        return ch >= '0' && ch <= '9';
    }
 
    ///Função para verificar se é um operador
    public boolean eOperador(char ch)
    {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
	
	
    //Função para avaliar qual a operação a fazer
    public double avaliaOperacao(NoTree no)
    {
        if (no.left == null && no.right == null) {
            return converterParaDigito(no.dados);
        
        }else{
            
        	double res = 0.0;
            double ramoEsquerda = avaliaOperacao(no.left);
            double ramoDireita = avaliaOperacao(no.right);
            char operador = no.dados;
 
            switch (operador)  {
            case '+' : 
	    res = ramoEsquerda + ramoDireita; 
	    break;
            case '-' : 
	    res = ramoEsquerda - ramoDireita; 
	    break;
            case '*' : 
	    res = ramoEsquerda * ramoDireita; 
	    break;
            case '/' :
	    res = ramoEsquerda / ramoDireita; 
	    break;
            }
            return res;
        }

}
