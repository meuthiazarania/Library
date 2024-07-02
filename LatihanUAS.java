package main;

import java.util.ArrayList;
import java.util.Scanner;

public class LatihanUAS {

	//bikin scanner global
	static Scanner sc = new Scanner(System.in);
	
	 //bikin array global
	static ArrayList<String> listNama = new ArrayList<>();
	static ArrayList<Integer> listNilai = new ArrayList<>();
	
	public static void main(String[] args) {
		//bikin menu
		int menu;

		do {
			System.out.println("1. Input Data");
			System.out.println("2. Search Data");
			System.out.println("3. View All Data");
			System.out.println("4. Exit");
			
			//validasi
			do {
				System.out.println(">>>");
				menu = sc.nextInt(); sc.nextLine();
			}while(menu < 1 || menu > 4);
			
			switch(menu) {
			case 1:
				addNewData();
				break;
			case 2:
				searchData();
				break;
			case 3:
				viewAllData();
				break;
			case 4:
				System.out.println("Thank you for using this program!");
				break;
			}
		} while(menu != 4);

	}

	private static void viewAllData() {
		//validasi datanya udah ada/belum
		if(listNama.isEmpty()) {
			System.out.println("Please Insert a Data First!");
			return; //sama kaya break fungsinya
		} 
		
		
		//tampilin data
		for(int i = 0; i < listNama.size(); i++ ) {
			System.out.println(listNama.get(i) + " " + listNilai.get(i));
		}
		
		//sorting
		bubbleSort();
		
	}

	private static void bubbleSort() {
		for(int i = 0; i < listNilai.size(); i++) {
			for(int j = 0; j < listNilai.size() -1-i; j++) {
				if(listNilai.get(j) < listNilai.get(j+1)) {
					
					//Swap nama
					String nama = listNama.get(j);
					listNama.set(j, listNama.get(j+1));
					listNama.set(j+1, nama);
					
					//Swap nilai
					Integer nilai = listNilai.get(j);
					listNilai.set(j, listNilai.get(j+1));
					listNilai.set(j+1, nilai);
					
				}
			}
		}
	
	}

	private static void searchData() {
		//validasi datanya udah ada/belum
				if(listNama.isEmpty()) {
					System.out.println("Please Insert a Data First!");
					return; //sama kaya break fungsinya
				}
				
				//bikin scanner buat nyari namanya
				System.out.println("Search Name: ");
				String nama = sc.nextLine();
				
				for(int i = 0; i < listNama.size(); i++) {
					if(listNama.get(i).equalsIgnoreCase(nama)) {
						System.out.println(listNama.get(i) + " " + listNilai.get(i));
					}
				}
		
	}

	private static void addNewData() {
		//1bikin scanner
		String nama;
		Integer nilai;
		
		System.out.println("Input Nama: ");
		nama = sc.nextLine();
		
		do {
			System.out.println("Input Nilai: ");
			nilai = sc.nextInt(); sc.nextLine();
		}while(nilai < 0 || nilai > 100); //validasi angka yg harus dimasukkan
		
		//nyimpen array
		listNama.add(nama);
		listNilai.add(nilai);
		
		System.out.println("New Successfully Added!");
		
		
	}

}
