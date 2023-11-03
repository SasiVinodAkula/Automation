package com.projectName.companyName.testcases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.android.dx.util.IntIterator;

public class Test1 {

	public static void main(String[] args) {

		
		
		
		
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.amazon.in/");
//		driver.findElement(By.xpath("//a[@aria-label=\"Men's shoes\"]")).click();
//		int n = (int) (Math.random()*10);
		System.out.println(Math.random());
//		driver.findElement(By.xpath("(//div[@aria-label='Deals grid']//a[@class]/parent::div/div//a)[1]")).click();
		System.out.println(0.1+0.2);
		
		
		
		
		
		int r,sum=0,temp;
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		int n=Integer.valueOf(name);
			

		temp = n;
		while(n>0) {
			r=n%10;
			sum=(sum*10)+r;
			n=n/10;
		}
		
		
		if(temp==sum) {
			System.err.println(true);
			
		}
		else {
			System.out.println(false);
		}
		
//		String name = "This is Sasi Vinod Akula This is Automation Sasi";
//		String[] arr = name.split(" ");
//		List<String> list= new ArrayList<String>(Arrays.asList(arr));
//		LinkedHashSet<String> listSet=new LinkedHashSet<String>(list);
//		System.out.println(listSet);
//		Iterator<String> itr = listSet.iterator();
//		String word =null;
//		int count = 0;
//		while (itr.hasNext()) {
//			word=itr.next();
//			count = 0;
//			System.out.println(word);
//			for (int i = 0;i<=arr.length-1;i++) {
//				if(word.equals(arr[i]))
//				count++;				
//			}
//			System.out.println("The '"+word+"' has "+count);
//			
//		}
		
		
		

		
				

			
		}

	}


