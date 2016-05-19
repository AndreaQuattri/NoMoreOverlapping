/*package provaPermutazione;

import java.util.Arrays;
import java.util.ArrayList;

class Disp {

	//disposizioni semplici di n elementi su k posizioni
	public static void dispSemplici(int[] arr, int k, ArrayList<char[]> out) {
		dispSemplici(arr,k,out,new String());	
	}

	//metodo di supporto per dispSemplici
	public static void dispSemplici(int[] arr, int k, ArrayList<char[]> out, String a) {
		if (a.length() == k) {
			char[] temp = a.toCharArray();
			out.add(temp);
			//System.out.println("debug "); //debug
			//stampaArrayList(out); //debug
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			dispSemplici(arr,k,out,a+arr[i]);
		}
	}

	//metodo per la stampa di ArrayList<char[]>
	public static void stampaArrayList(ArrayList<char[]> arrList) {
		for (char[] temp : arrList)
			System.out.println(Arrays.toString(temp));
	}

	//metodo main di prova
	public static void main(String[] args) {
		int[] alf = {1,2,3,4};
		ArrayList<char[]> out = new ArrayList<char[]>();
		dispSemplici(alf,2,out);
		System.out.println("dispSemplici");
		stampaArrayList(out);
		System.out.println(out.size());
	}
}*/