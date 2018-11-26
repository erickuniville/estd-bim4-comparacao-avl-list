package trabalho.bim4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Bim4TrabMain {
	private static final AVLTree<Integer> AVL = new AVLTree<>();
	private static final LinkedList<Integer> LIST = new LinkedList<>();
	private static final FileWriter file = new FileWriter("grafico.csv");
	private static final String CSV_HEADERS = "N;AVL add;AVL find;List add;List find\n"

	public static void main(String[] args) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(file)) {
			writer.write(CSV_HEADERS);
			for (int n = 1; n <= 100; n++) {
				int avlAdd = AVL.add(n);
				int avlFind = AVL.find(n);
				int listAdd = LIST.add(n);
				int listFind = LIST.find(n);
				
				writer.write(String.format("%d;%d;%d;%d;%d;\n", 
					n, avlAdd, avlFind, listAdd, listFind));
			}
		}
	}

}
