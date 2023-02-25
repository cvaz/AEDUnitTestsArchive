package teste1;

public class Complexidade {
    public static int[] xpto(int[] a, int l, int r){
        int n=r-l+1;
        if(n<=0) return null;
        else
        if(n==1) return new int[]{a[l],a[l]};
        else if(n==2) return (a[l]<a[r])? new int[]{a[l],a[r]}:new int[]{a[r],a[l]};
        else{
            int mid=l + (r-l)/2;
            int[] mLeft=xpto(a,l,mid);
            int[] mRight=xpto(a,mid+1,r);
            int[] result=new int[2];
            result[0]=(mLeft[0]<mRight[0])?mLeft[0]:mRight[0];
            result[1]=(mLeft[1]>mRight[1])?mLeft[1]:mRight[1];
            return result;
        }
    }

    public static void main(String[] args){
        int[] a=new int[]{1,4,3,2};
        int[] res=xpto(a,0,3);
        System.out.println(java.util.Arrays.toString(res));
    }
}
