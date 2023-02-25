package serie1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.Test;
import serie1.ArrayUtils;
import static org.junit.Assert.*;


public class PrintEachTreeElementsThatSumToTest {
	
	public static File getFolder() {
		URL url = ClassLoader.getSystemResource("serie1");
		File targetSerie1Folder = new File(url.getFile());
		File folder= new File(targetSerie1Folder,"../../../src/test/java/serie1" );
		return folder;
	}

	public static String[] getTriples(File folder, String filename) throws IOException{
		BufferedReader br=new BufferedReader(new FileReader(new File(folder, filename)));
		return getTriples( br );
	}
	public static String[] getTriples(BufferedReader br) throws IOException{
		ArrayList<String> array =new ArrayList<String>();
		String s;
		while((s=br.readLine())!=null){
			if(s!=null)array.add(s);
		}
		if(array.size()!=0)Collections.sort(array);
		return array.toArray(new String[0]);
	}
	
	@Test
	public void printEachTreeElements_onAnEmptyArray() throws IOException{
		File folder = getFolder();
		int[] v=new int[0];
		PrintWriter pw=new PrintWriter(folder.getAbsolutePath()+"/onAnEmptyArray2.txt");
		ArrayUtils.printEachTreeElementsThatSumTo(pw, v, 0, -1, 10);
		pw.close();
		String[] array1=PrintEachTreeElementsThatSumToTest.getTriples(folder, "onAnEmptyArray1.txt");
		String[] array2=PrintEachTreeElementsThatSumToTest.getTriples(folder, "onAnEmptyArray2.txt");	
		assertArrayEquals(array1,array2);
	}
	
	@Test
	public void printEachTreeElements_onArrayWithLenght1() throws IOException{
		File folder = getFolder();
		int[] v=new int[]{0};
		PrintWriter pw=new PrintWriter(folder.getAbsolutePath()+"/onArrayWithLenght12.txt");
		ArrayUtils.printEachTreeElementsThatSumTo(pw, v, 0, 0, 0);
		pw.close();
		String[] array1=PrintEachTreeElementsThatSumToTest.getTriples(folder, "onArrayWithLenght11.txt");
		String[] array2=PrintEachTreeElementsThatSumToTest.getTriples(folder, "onArrayWithLenght12.txt");
		assertArrayEquals(array1,array2);
	}

	@Test
	public void printEachTreeElements_onASmallArray() throws IOException{
		File folder = getFolder();
		int[] v={1,2,3,6,8,10,12,15,16,20};
		PrintWriter pw=new PrintWriter(folder.getAbsolutePath()+"/onASmallArray2.txt");
		ArrayUtils.printEachTreeElementsThatSumTo(pw, v, 0, v.length-1, 24);
		pw.close();
		String[] array1=PrintEachTreeElementsThatSumToTest.getTriples(folder,"onASmallArray1.txt");
		String[] array2=PrintEachTreeElementsThatSumToTest.getTriples(folder,"onASmallArray2.txt");
		assertArrayEquals(array1,array2);
	}


}
