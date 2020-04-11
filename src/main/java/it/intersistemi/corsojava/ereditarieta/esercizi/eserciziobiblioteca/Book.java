package it.intersistemi.corsojava.ereditarieta.esercizi.eserciziobiblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import it.intersistemi.corsojava.ConsoleInput.ConsoleInputStringa;

public class Book {
	private int chapterIndex = 0, chapterNumber = 0;
	private String chapterTitle, chapterContent;
	BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
	public Book(int chapterIndex, int chapterNumber, String chapterTitle, String chapterContent) {
		super();
		this.chapterIndex = chapterIndex;
		this.chapterNumber = chapterNumber;
		this.chapterTitle = chapterTitle;
		this.chapterContent = chapterContent;
	}
	
	public int getChapterIndex() {
		return chapterIndex;
	}
	
	public void setChapterIndex(int chapterIndex) {
		this.chapterIndex = chapterIndex;
	}
	
	public int getChapterNumber() {
		return chapterNumber;
	}
	
	public void setChapterNumber(int chapterNumber) {
		this.chapterNumber = chapterNumber;
	}
	
	public String getChapterTitle() {
		return chapterTitle;
	}
	
	public void setChapterTitle(String chapterTitle) {
		this.chapterTitle = chapterTitle;
	}
	
	public String getChapterContent() {
		return chapterContent;
	}
	
	public void setChapterContent(String chapterContent) {
		this.chapterContent = chapterContent;
	}
	
	public void addChapter() throws IOException {
		String chapterName, nowchapterContent;
		this.chapterIndex = this.chapterIndex + 1;
		this.chapterNumber++;
		chapterName = ConsoleInputStringa.leggiStringa(console, "Inserisci titolo capitolo: ");
		chapterTitle = chapterName;
		nowchapterContent = ConsoleInputStringa.leggiStringa(console, "Inserisci contenuto capitolo: ");
		chapterContent = nowchapterContent;
	}

	@Override
	public String toString() {
		return "Book [chapterIndex=" + chapterIndex + ", chapterNumber=" + chapterNumber + ", chapterTitle="
				+ chapterTitle + ", chapterContent=" + chapterContent + ", console=" + console + "]";
	}
	
	public static void main(String[] args) throws IOException{
		Book capitolo = new Book (0, 0, null, null);
		capitolo.addChapter();
		System.out.println(capitolo);
		capitolo.addChapter();
		System.out.println(capitolo);
	}
}
