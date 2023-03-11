package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import SelectionSortAlgoritmo.Algoritmo;

class testesSelection {
	
	private Integer[] vetor;
	private Integer[] vetor2;
	
	@BeforeEach
	void iniciador() {
		this.vetor = new Integer[] {5, 4, 1, 2 };
		this.vetor2 = new Integer[] {5, 2, 1, 2 };
	}
	
	@Test
	void testSelectionSort() {
		Algoritmo algoritmo = new Algoritmo();
		algoritmo.selectionSort(this.vetor, 0, 3);
		assertArrayEquals(new Integer[] {1, 2, 4, 5}, this.vetor); 
	}
	
	@Test
	void testSelectionSortIguais() {
		Algoritmo algoritmo = new Algoritmo();
		algoritmo.selectionSort(this.vetor2, 0, 3);
		assertArrayEquals(new Integer[] {1, 2, 2, 5}, this.vetor2); 
	}

}
