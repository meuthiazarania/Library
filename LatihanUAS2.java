package main;

import java.util.ArrayList;
import java.util.Scanner;

public class LatihanUAS2 {

	static Scanner sc = new Scanner(System.in);
	static ArrayList<String> listJudul = new ArrayList<>();
	static ArrayList<Integer> listTahun = new ArrayList<>();
	
	public static void main(String[] args) {
		// LKC
		int selection; //inisialiasi menu
		
		do {
			System.out.println("1. Input new data");
			System.out.println("2. View all data");
			System.out.println("3. Search Data");
			System.out.println("4. Exit");
			
			do { //validasi menu buat milih 1-4 aja
				System.out.println(">>>");
				selection = sc.nextInt(); sc.nextLine();
			}while(selection < 1 || selection > 4);
			
			//switch case menu
			switch(selection) {
			case 1:
				addNewData(); //method menu
				break;
			case 2:
				viewAllData();
				break;
			case 3:
				searchData();
				break;
			case 4:
				System.out.println("Thank You For Using This Program!"); //default
				break;
			}
		}while(selection != 4); 
		
		

	}

	private static void searchData() {
		//validasi data lagi
		if(listJudul.isEmpty()) {
			System.out.println("No Data Added. Please Input a Data First!");
			return;
		}
		
		//bikin scanner buat masukin judul buku yg mau kita cari
		System.out.print("Masukkan Judul Buku: ");
		String judulBuku = sc.nextLine();
		
		//nampilin data bukunya
		for(int i = 0; i<listJudul.size(); i++) {
			System.out.println(listJudul.get(i) + " " + listTahun.get(i));
		}
	}

	private static void viewAllData() {
		//validasi dulu datanya ada atau ngga, kalau gaada, tulisan ini bakal muncul:
		if(listJudul.isEmpty()) {
			System.out.println("No Data Added. Please Input a Data First!");
			return; //ky break
		}
		
		//nampilin data
		for(int i = 0; i<listJudul.size(); i++) {
			System.out.println(listJudul.get(i) + " " + listTahun.get(i)); //.get itu buat akses array kita
		}
		
		bubbleSort();
		
	}

	private static void bubbleSort() {
		for(int i = 0; i < listTahun.size(); i++) {
			for(int j = 0; j < listTahun.size()-1-i; j++) {
				if(listTahun.get(j) < listTahun.get(j+1)) {
					
					//swap judul
					String judul = listJudul.get(j);
					listJudul.set(j, listJudul.get(j+1));
					listJudul.set(j+1, judul);
					
					//swap tahun
					Integer tahun = listTahun.get(j);
					listTahun.set(j, listTahun.get(j+1));
					listTahun.set(j+1, tahun);
				}
			}
		}
		
	}

	private static void addNewData() {
		//inisialisasi 
		String judulBuku;
		Integer tahunTerbit;
		
		//scanner
		System.out.println("Masukkan Judul Buku: ");
		judulBuku = sc.nextLine();
		
		System.out.println("Masukkan Tahun Terbit: ");
		tahunTerbit = sc.nextInt();
		
		//nyimpen data dalam array
		listJudul.add(judulBuku);
		listTahun.add(tahunTerbit);
		
		//kalau udah disimpen datanya, bakal nampilin tulisan ini
		System.out.println("Buku Sudah Ditambahkan.");
		
	}

}
