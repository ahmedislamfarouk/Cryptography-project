import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn= new Scanner(System.in);
        ArrayList<Integer> massage =new ArrayList<>();
        ArrayList<Integer> cipherMassage =new ArrayList<>();
        ArrayList<Integer> originalMassage =new ArrayList<>();
        System.out.println("Entre original massage");
        String normalmassage=scn.nextLine();
        for (int i=0;i<normalmassage.length();i++){
            massage.add( (int) normalmassage.charAt(i));
        }
//        System.out.println(massage);

        System.out.println("Entre two distinct upper limits for the two prime numbers p,q");

        System.out.println("p");
        int p= scn.nextInt();
        System.out.println("q");
        int q=scn.nextInt();
        System.out.println("p= "+UpperLimitPrime(p)+"  q= "+UpperLimitPrime(q));
        int n=UpperLimitPrime(p)*UpperLimitPrime(q);
        System.out.println("n= "+n);
        int m=(UpperLimitPrime(p)-1)*(UpperLimitPrime(q)-1);
        System.out.println("m= "+m);
        int e=1;
        for (int i=2;i<100;i++){
            if (gcd(m,i)==1){
                e=i;
                break;
            }
        }
        System.out.println("e= "+e);
        int d=1;
        for (int i=1;i<100;i++){
            if ((m*i+1)%e==0) {
                d = (m * i + 1 )/ e;
                break;
            }
        }
        System.out.println("d= "+d);


        for (int i=0;i<massage.size();i++){
            cipherMassage.add(CalculateC(massage.get(i),e,n));
        }
//        System.out.println(cipherMassage);
        System.out.println("Original Massage: "+normalmassage);
        String Cmassage="";
        for (int i=0;i<cipherMassage.size();i++){
            int c=cipherMassage.get(i);
            Cmassage+=(char) c;
        }
        System.out.println("Ciphered Massage: "+Cmassage);

        for (int i=0;i<cipherMassage.size();i++){
            originalMassage.add(CalculateC(cipherMassage.get(i),d,n));
        }
//        System.out.println(originalMassage);

        String  OMassage="";
        for (int i=0;i<originalMassage.size();i++){
            int c=originalMassage.get(i);
            OMassage+=(char) c;
        }
        System.out.println("Decrypted Massage: "+OMassage);
    }
    public static int UpperLimitPrime(int upperlimit){
        int prime=upperlimit;
        for (int i=upperlimit;i>=2;i--){
            if (isPrime(i)) {
                prime=i;
                break;
            }
        }
        return prime;
    }
    public static  boolean isPrime(int isprime){
        if (isprime<2) return false;
        for (int i =2;i<Math.sqrt(isprime);i++){
            if (isprime%i==0) return false;
        }
        return true;
    }

    public static int gcd(int m, int e) {
        int x=m;
        int y=e;
        while (y!=0){
            int r=x%y;
            x=y;
            y=r;
        }
        return x;
    }


    public static int CalculateC(int Ascii,int power,int modolo){
        long C=1;
        long y=Ascii;
        while (power>0){
            if (power%2==1){
                C=(C*y)%modolo;
            }
            y=(y*y)%modolo;
            power=power/2;
        }
        return (int)C%modolo;
    }

}