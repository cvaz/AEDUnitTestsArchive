package serie1;

public class Arrays {
	
	public static int[] getMaximumIncreasingSubsequence(int[] v, int l, int r){
		
		if(r<l) return new int[]{0,-1};
		if(l==r) return new int[]{l,l};
		int[] array=new int[2];
		int lastLeft=l;
		int lastRight=l;
		int bestLeft=l;
		int bestRight=l;
		for(int i=l;i<r; i++){
			if(v[i]<=v[i+1]){
				lastRight=i+1;		
			}
			else{
				if( lastRight-lastLeft+1 > bestRight-bestLeft+1){
						bestLeft=lastLeft;
						bestRight=lastRight;	
					}	
					lastLeft=i+1;
					lastRight=i+1;	
			}
		}
		if( lastRight-lastLeft+1 > bestRight-bestLeft+1){
			bestLeft=lastLeft;
			bestRight=lastRight;			
		}
		array[0]=bestLeft;
		array[1]=bestRight;	
		return array;
		
	}
	
	public static int countUniquesPalindromes(String[] v, int l, int r) {
		
		int count = 0;
		for (int i = 0; i < v.length; i++)
			if (isPalindrome(v[i], 0, v[i].length() - 1)) {
				boolean dup = false;
				for (int j = 0; j < v.length && !dup; j++) {
					if (i != j && v[i].toLowerCase().equals(v[j].toLowerCase())) dup = true;
				}
				count += (dup) ? 0 : 1;
			}
		return count;
	}	
	
	private static boolean isPalindrome(String str, int l, int r) {
		// frases com 1 ou 0 caracteres
		if (l >= r) return true;
		// obtem o primeiro e o ultimo caracter convertidos em maiusculas
		char first = str.charAt(l);
		char last = str.charAt(r);
		// verifica se ambos os caracteres s„o letras (A .. Z)
		if (Character.isLetter(first) && Character.isLetter(last)) {
			if (Character.toLowerCase(first) == Character.toLowerCase(last))
				// remove ambos os caracteres e testa a frase resultante
				return isPalindrome(str, l + 1, r - 1);
			else return false;
		}
		else if (!Character.isLetter(first))
			// remove o primeiro caracter e testa a frase resultante
			return isPalindrome(str, l + 1, r);
		else
			// remove o ultimo caracter e testa a frase resultante
			return isPalindrome(str, l, r - 1);
	}
	
	
	public static int greatestAfterRotate(int[] v, int left, int right) {
		
			if (right < left) return -1;
		int mid = left + (right - left) / 2;
		if(mid==left) return (v[mid]>v[right])? v[mid]:v[right];
		if(mid==right) return (v[mid]>v[left])?v[mid]:v[left];
		if (v[mid - 1] > v[mid]) return v[mid-1];
		if(v[mid + 1]< v[mid]) return v[mid];
		if( v[mid + 1]> v[right])
			return greatestAfterRotate(v, mid + 1, right);
		return greatestAfterRotate(v, left, mid - 1);
	}
	
	public static void changeValueInMaxHeap(int[] v, int count, int ix, int newValue){
		
	
		if(ix > v.length-1)
			throw new IllegalArgumentException();

		int elementoSubstituido = v[ix];

		
		v[ix]= newValue;

		--count;

		int pai = (ix - 1)/2;
		
		if (v[pai] < v[ix])
			v = increase(v, pai, ix);
		
		else
			v = maxHeapify(v,ix,count);
			

	}

 private static int[] increase(int[] maxHeap, int pai, int ix) {
		int aux = 0;
		
		while (maxHeap[pai] < maxHeap[ix]) {
			aux = maxHeap[pai];
			maxHeap[pai]=maxHeap[ix];
			maxHeap[ix] = aux;
			
			ix = pai;
			pai = (ix - 1)/2;
		}
		
		return maxHeap;
		
	}
	private static int[] maxHeapify(int[] maxHeap, int ix,int count) {
		
		int fd= 2*ix+2;
		int fe= 2*ix+1;
		int aux =0;
		
		while(true){
			
			aux= maxHeap[ix];
			
			if( fe < count && maxHeap[fd] < maxHeap[fe] && maxHeap[ix] < maxHeap[fe]){
				maxHeap[ix]= maxHeap[fe];
				maxHeap[fe]=aux;
				ix = fe;
			}
			
			else {
				
				if(fd < count && maxHeap[ix] < maxHeap[fd]){
					maxHeap[ix]= maxHeap[fd];
					maxHeap[fd]=aux;
					ix = fd;
				}	
				else
					break;
			}
			
			fd= 2*ix+2;
			fe= 2*ix+1;
		}
		
		return maxHeap;
	}

	

}
