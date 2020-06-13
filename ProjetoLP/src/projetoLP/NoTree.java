package projetoLP;

public class NoTree {
     	
		//ATRIBUTOS
        char dados;
        NoTree esquerda, direita;

        //ACESSORES
		public char getDados() {
			return dados;
		}

		public void setDados(char dados) {
			this.dados = dados;
		}

		public NoTree getEsq() {
			return esquerda;
		}

		public void setEsq(NoTree esquerda) {
			this.esquerda = esquerda;
		}

		public NoTree getDir() {
			return direita;
		}

		public void setDir(NoTree direita) {
			this.direita = direita;
		}
		//CONSTRUTORES

        public NoTree(char dados)
        {
            this.dados = dados;
            this.esquerda = null;
            this.direita = null;
        }
}
