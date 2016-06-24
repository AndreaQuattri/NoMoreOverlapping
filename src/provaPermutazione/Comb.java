package provaPermutazione;

import java.util.ArrayList;

public class Comb {


	public static ArrayList<String> getCombinazioni (ArrayList<String> s , int k) { 
		ArrayList<String> l = new ArrayList<String> ();
		int n = s.size();
		StringBuilder sb = new StringBuilder ();
		//1
		if (k >= 1) {
			for (int i=0;i<n;i++) {
				l.add (s.get (i) + "");
			}
		}


		//2
		if (k >= 2) {
			for (int i=0;i<n;i++) {
				for (int j=i+1;j<n;j++) {
					sb.append (s.get (i) + " ");
					sb.append (s.get (j));
					l.add (sb.toString ());
					sb = new StringBuilder ();
				}
			}
		}


		//3
		if (k>=3) {
			for (int i=0;i<n;i++) {
				for (int j=i+1;j<n;j++) {
					sb = new StringBuilder ();
					for (int z=j+1;z<n;z++) {
						sb.append (s.get (i) + " ");
						sb.append (s.get (j) + " ");
						sb.append (s.get (z));
						l.add (sb.toString ());
						sb = new StringBuilder ();
					}
				}
			}
		}


		//4
		if (k >=4) {
			for (int i=0;i<n;i++) {
				for (int j=i+1;j<n;j++) {
					for (int z=j+1;z<n;z++) {
						for (int a=z+1;a<n;a++) {
							sb.append (s.get (i) + " ");
							sb.append (s.get (j) + " ");
							sb.append (s.get (z) + " ");
							sb.append (s.get (a));
							l.add (sb.toString ());
							sb = new StringBuilder ();
						}
					}
				}
			}
		}


		//5
		if (k >= 5) {
			for (int i=0;i<n;i++) {
				for (int j=i+1;j<n;j++) {
					for (int z=j+1;z<n;z++) {
						for (int a=z+1;a<n;a++) {
							for (int b=a+1;b<n;b++) {
								sb.append (s.get (i) + " ");
								sb.append (s.get (j) + " ");
								sb.append (s.get (z) + " ");
								sb.append (s.get (a) + " ");
								sb.append (s.get (b));
								l.add (sb.toString ());
								sb = new StringBuilder ();
							}
						}
					}
				}
			}
		}


		//6
		if (k >= 6) {
			for (int i=0;i<n;i++) {
				for (int j=i+1;j<n;j++) {
					for (int z=j+1;z<n;z++) {
						for (int a=z+1;a<n;a++) {
							for (int b=a+1;b<n;b++) {
								for (int c=b+1;c<n;c++) {
									sb.append (s.get (i) + " ");
									sb.append (s.get (j) + " ");
									sb.append (s.get (z) + " ");
									sb.append (s.get (a) + " ");
									sb.append (s.get (b) + " ");
									sb.append (s.get (c));
									l.add (sb.toString ());
									sb = new StringBuilder ();
								}
							}
						}
					}
				}
			}
		}

		//7
		//STESSA PROCEDURA FATTA SOPRA MA AGGIUNGENDO UN ALTRO FOR ANNIDATO

		//8
		//IDEM PER LA PROCEDURA 7 MA CON 8 FOR ANNIDATI...


		return l;
	}

}
