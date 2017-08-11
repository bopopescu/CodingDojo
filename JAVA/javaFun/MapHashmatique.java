import java.lang.*;
import java.util.*;
public class MapHashmatique {

//	public HelloWorld() {
//		// TODO Auto-generated constructor stub
//	}

	/**
	 * @param args
	 */
	public static void FirstMethod(){
		HashMap<String, String> trackList = new HashMap<>();
		trackList.put("Wild", "Wah Wah Wah");
		trackList.put("Despacito", "Despacitoooooo");
		trackList.put("Alaska", "I was walking on wasted lands");
		trackList.put("Anybody else but you", "Part time friend");
		String title = trackList.get("Alaska");
		System.out.println(title);
		System.out.println(trackList);
//		System.out.println(trackList[0]);
		for(String key : trackList.keySet()){
			
			String gettitle = trackList.get(key);
			System.out.println("Track: "+key+" | Lyrics: "+gettitle);
		}
    

}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstMethod();

	}

}
