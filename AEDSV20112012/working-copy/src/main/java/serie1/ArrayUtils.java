package serie1;

public class ArrayUtils {

	public static int removeOdd(int[] v, int l, int r){
		throw new UnsupportedOperationException();
	}
	
	public int countEqualTo(int[] v, int l, int r, int a){
		throw new UnsupportedOperationException();
	}
	
	public static int[] findElementsThatSumTo(int[] v, int l, int r, int s){
		//throw new UnsupportedOperationException();
		for(int i=l,j=r; i<j;){
			if(v[i]+v[j]>s) j--;
			else
				if(v[i] +v[j]<s) i++;
				else
					return new int[]{v[i],v[j]};
		}
		return new int[]{};
	}
	
	public static int localMinimum(int[] v, int l, int r){
		int mid;
		int result=0;
		while(l<=r){
			mid=(l+r)/2;
			if(mid==l && mid==r) {result= v[mid];break;}
			else{
				if(mid>l && mid<r && v[mid]< v[mid-1] && v[mid]<v[mid+1] ) {result= v[mid];break;}
				else{
					if(mid>l && v[mid]> v[mid-1]) r=mid-1;
					else{
						l=mid+1;
					}
		}
			}
		}
		return result;
		//throw new UnsupportedOperationException();
	}
	
	public static int findDuplicate(int[] v,int l, int r){
		int i= r, j=r;
		if(l>r) return -1;
		do{
			i=v[i];
			j=v[v[j]];
		}while(i!=j);
		
		j=r;
		do{
			l=i;r=j;
			i=v[i];j=v[j];
		}while(i!=j && l!=r);
	   return l;
	//	throw new UnsupportedOperationException();
	}
}
