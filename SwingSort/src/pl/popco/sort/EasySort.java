package pl.popco.sort;

import java.util.ArrayList;

public class EasySort implements Runnable{

	public static int tableSize;
	int zmiana=1;
	int sprawdzenie=0;
	ArrayList<Integer> array= new ArrayList<Integer>();
	
	public EasySort(ArrayList<Integer> array){
		
		this.array=array;
		run();
			
	}
	
	public void run(){
		
		tableSize = array.size();
		
		System.out.print("Pe³na tablica: [");
		for (int i=0 ; i<tableSize-1 ; i++){
			System.out.print(array.get(i)+", ");
		}
		System.out.print(array.get(tableSize-1)+"]\n");
				
		do {
			zmiana=sprawdzenie;
		for (int i=0 ; i<tableSize-1 ; i++) {
			if (array.get(i)>array.get(i+1)) {
				int temp = array.get(i+1);
				array.set(i+1, array.get(i));
				array.set(i,temp);
				sprawdzenie++;
			} 
			
		}
		
			// WYPISANIE TABLICY
			System.out.print("Gotowa tablica: [");
			for (int u=0 ; u<tableSize-1 ; u++){
				System.out.print(array.get(u)+", ");
			}
			System.out.print(array.get(tableSize-1)+"]\n");
		
		} while (zmiana!=sprawdzenie);

		System.out.println("koniec!");
		
	}
	
	public ArrayList<Integer> getList(){
		return array;
	}
	
	
}
