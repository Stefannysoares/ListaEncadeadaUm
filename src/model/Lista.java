package model;

public class Lista {

	No primeiro;
	
	public Lista () {
		primeiro = null;
	}
	
	public boolean isEmpty() {
		if(primeiro == null) {
			return true;
		}else {
			return false;
		}
	}
	
	public int size () {
		int cont =0;
		if (!isEmpty()) {
			No auxiliar = primeiro;
			while (auxiliar != null) {
				cont++;
				auxiliar = auxiliar.proximo;
			}
		}
		return cont;
	}
	
	private No getNo(int pos)throws Exception {
		if (isEmpty()) {
			throw new Exception ("Lista Vazia");
		}
		int tamanho = size();
		if(pos < 0 || pos> tamanho-1) {
			throw new Exception ("Posição Inválida");
		}
		No auxiliar = primeiro;
		int cont = 0;
		while (cont < pos) {
			auxiliar = auxiliar.proximo;
			cont ++;
		}
		return auxiliar;
	}
	
	public void addFirst(int valor) {
		No elemento = new No();
		elemento.dado = valor;
		elemento.proximo = primeiro;
		primeiro = elemento;
	}
	
	
	public void addLast(int valor)throws Exception {
		int tamanho = size();
		if (isEmpty()) {
			throw new Exception ("Lista Vazia");
		}
		No elemento = new No ();
		elemento.dado = valor;
		elemento.proximo = null;
		
		No ultimo = getNo(tamanho-1);
		ultimo.proximo= elemento;
		
	}
	
	public void add (int valor, int posicao) throws Exception{
		if (isEmpty()) {
			throw new Exception ("Lista Vazia");
		}
		int tamanho = size();
		if (posicao < 0 || posicao > tamanho) { //Usar o tamanho permite inserir na ultima posição
			throw new Exception ("Posição Inválida");
		}
		if (posicao == 0){ // Inserir no inicio da lista
			addFirst(valor);
		}else if (posicao == tamanho ) { // Inserir no final da lista
			addLast(valor);
		}
		
		No elemento = new No();
		elemento.dado = valor; // o ponteiro será definido pela posição
		No anterior = getNo(posicao-1); // O anterior apontará para o novo e o novo apontará para onde o anterior estava apontando
		elemento.proximo = anterior.proximo;
		anterior.proximo = elemento;
		
	}
	
	public void removeFirst() throws Exception{
		if (isEmpty()) {
			throw new Exception ("Lista Vazia");
		}
		primeiro = primeiro.proximo;
		
	}
	
	public void removeLast() throws Exception{
		if (isEmpty()) {
			throw new Exception ("Lista Vazia");
		}
		int tamanho = size ();
		if (tamanho ==1) { //Lista de um elemento, remover o ultimo é remover o primeiro
			removeFirst();
		}else { //Lista de dois ou mais elementos, o penúltimo nó passa a ser o último.
			No penultimo = getNo(tamanho-2);
			penultimo.proximo=null ;
		}
	}
	
	public void remove(int posicao)throws Exception{
		int tamanho = size();
		if (isEmpty()) {
			throw new Exception ("Lista Vazia");
		}
		if (posicao < 0 || posicao > tamanho-1) {
			throw new Exception ("Posição Inválida");
		}
		if (posicao == 0) {
			removeFirst();
		}else if (posicao == tamanho -1) {
			removeLast();
		}else {
			No anterior = getNo(posicao-1);
			No atual = getNo(posicao);
			anterior.proximo = atual.proximo;
		}
	}
	
	public int get(int posicao)throws Exception{
		if (isEmpty()) {
			throw new Exception ("Lista Vazia");
		}
		int tamanho = size();
		if (posicao <0 || posicao > tamanho -1) {
			 throw new Exception ("Posição Inválida");
		}
		No auxiliar = primeiro;
		int cont = 0;
		while (cont < posicao) {
			auxiliar = auxiliar.proximo;
			cont ++;
		}
		int valor = auxiliar.dado;
		return valor;
		
	}
	
	
	
	
	
	
	
	
	
}
