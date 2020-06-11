package projetoLP;

public class NoTree {
     	
		//ATRIBUTOS
        char dados;
        NoTree left, right;

        //ACESSORES
		public char getDados() {
			return dados;
		}

		public void setDados(char dados) {
			this.dados = dados;
		}

		public NoTree getLeft() {
			return left;
		}

		public void setLeft(NoTree left) {
			this.left = left;
		}

		public NoTree getRight() {
			return right;
		}

		public void setRight(NoTree right) {
			this.right = right;
		}
		//CONSTRUTORES

        public NoTree(char dados)
        {
            this.dados = dados;
            this.left = null;
            this.right = null;
        }
}
