package serie2;

public class Utils {

	public static boolean verifyXML(String str){
	char init1end1= '<';
		char init2end2 = '>';
		char end='/';
		String[] stack= new String[ str.length() ];
		int sp = 0; 
		char c;
		for (int i= 0; i < str.length(); ++i ) {
			c = str.charAt( i );
			boolean b=false;
			if ( c==init1end1  ) {
				StringBuffer sb=new StringBuffer();
				//sb.append(c); 
				char d=' ';
				while(i<str.length() && (d=str.charAt(i))!=init2end2){
					if(d==end) b=true;
					sb.append(d);
					i++;
				}
				if(d ==init2end2)
					if(!b) {stack[sp++]=sb.toString(); b=false;}
					else{
						if(sp==0)return false;
						String elem=stack[--sp];
						if(!elem.substring(1).equals(sb.toString().substring(2)))
							return false;	
					}
			}
		}
		return sp == 0;
	}


	public static <K,V> void replace(HashNode<K,V>[] hashMap, HashNode<K,V> list) {
		 while(list!=null){
			 int index=list.key.hashCode()%hashMap.length;
			 if(index<0) index+=hashMap.length;
			 replace(hashMap[index], list);		 
			 list=list.next;
		 }
	}
	
	private static <K,V> void replace(HashNode<K,V> mapEntryList, HashNode<K,V> mapEntry){
		while(mapEntryList!=null){
			if(mapEntryList.key.equals(mapEntry.key)){
				mapEntryList.value=mapEntry.value; break;
			}
			mapEntryList=mapEntryList.next;
		}
	}




}


