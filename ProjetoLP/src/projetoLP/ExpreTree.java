package projetoLP;

public class ExpreTree{
	//ATRIBUTOS
	
    private static PilhaNos raiz;
 
    //ACESSORES
    
    public static PilhaNos getRaiz() {
		return raiz;
	}
    
	public static void setRaiz(PilhaNos raiz) {
		ExpreTree.raiz = raiz;
	}
    
    //CONSTRUTOR
    public ExpreTree() {
        raiz = null;
    }//ExpreTree
    
    //METODOS
    
    public boolean estaVazia() {
		return raiz==null;
	}//estaVazia
 
	//Função para limpar a arvore
    public void limpar() {
        raiz = null;
    }//limpar
 
    //Função para adicionar um numero ou operador à arvore
    public void adicionar(NoTree no)
    {
        if (estaVazia())
            raiz = new PilhaNos(no);
        else
        {
            PilhaNos novoNo = new PilhaNos(no);
            novoNo.proximo = raiz;
            raiz = novoNo;
        }
    }//adicionar
 
    //Função para remover um numero ou operador da árvore
    public NoTree remover() throws Exception {
        if (estaVazia())
            throw new Exception("Árvore vazia");
        else
        {
            NoTree noRemover = raiz.noArvore;
            raiz = raiz.proximo;
            return noRemover;
        }
    }//remover
 
    //Função para olhar para o topo da árvore
    public NoTree obter() {
		
    	return raiz.getnoArvore();
	}//obter
    
    //Função para verificar se é um digito
    public boolean eDigito(char c)  {
        return c >= '0' && c <= '9';
    }//eDigito
 
    ///Função para verificar se é um operador
    public boolean eOperador(char c)  {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }//eOperador
 
    //Função para converter o char para digito
    public int converterParaDigito(char c) {
        return c - '0';
    }//converterParaDigito
    
    //Função para inserir um caractere na árvore
    public void inserir(char valor) {
        try
        {
            if (eDigito(valor))
            {
                NoTree no = new NoTree(valor);
                adicionar(no);
            }
            else if (eOperador(valor))
            {
                NoTree no = new NoTree(valor);
                no.esquerda = remover();
                no.direita = remover();
                adicionar(no);
            }
        }
        catch (Exception e)
        {
            System.out.println("Expressão Inválida");
        }
    }//inserir
    
    public double avaliaOperacao() {
        return avaliaOperacao(obter());
    }//avaliaOperacao
    
    //Função para avaliar qual a operação a fazer
    public double avaliaOperacao(NoTree no) {
        if (no.getEsq() == null && no.getDir() == null) {
            return converterParaDigito(no.getDados());
        
        }else{
            
        double res = 0.0;
        double ramoEsquerda = avaliaOperacao(no.getEsq());
        double ramoDireita = avaliaOperacao(no.getDir());
        char operador = no.getDados();
 
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
    }//avaliaOperacao
   
    
    /*Função para criar a árvore consoante a equação dada pelo utilizador
    Devido a multiplos problemas e após consulta de vários documentos na internet, só conseguimos fazer isto através da notação prefix
    Mas depois de o utilizador fornecer a equação em notação prefix, através das travessias das árvores conseguimos obter a equação na notação infix 
    */
    public void buildTree(String equacao)  {
        for (int i = equacao.length() - 1; i >= 0; i--)
            inserir(equacao.charAt(i));
    }//buildTree
    
    // Função para obter a expressão em notação infix
    public void infix()  {
        inOrdem(obter());
    }//infix
  
    //Travessia inOrdem (Esquerda, Raiz, Direita)
    public void inOrdem(NoTree no) {
        if (no != null)
        {
            inOrdem(no.getEsq());
            System.out.print(no.getDados());
            inOrdem(no.getDir());            
        }    

    }//inOrdem
    
    //Funçao para obter a expressão em notação prefix
    public void prefix()  {
        preOrdem(obter());
    }//prefix
 
    //Travessia preOrdem (Raiz, Esquerda, Direita)
    private void preOrdem(NoTree no) {
        if (no != null)
        {
            System.out.print(no.getDados());
            preOrdem(no.getEsq());
            preOrdem(no.getDir());            
        }    
    }//preOrdem
}
