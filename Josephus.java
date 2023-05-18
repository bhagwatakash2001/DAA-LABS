import java.io.*;
import java.util.*;

public class Josephus {

    static class Node {  //LL 
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    static void jl(int m, int n) {
        Node head = new Node(1);
        Node prev = head;
        for (int i = 2; i <= n; i++) {
            prev.next = new Node(i);
            prev = prev.next;
        }

        prev.next = head;
        Node ptr1 = head, ptr2 = head;

        while (ptr1.next != ptr1) {
            int count = 1;
            while (count != m) {
                ptr2 = ptr1;
                ptr1 = ptr1.next;
                count++;
            }
            ptr2.next = ptr1.next;
            ptr1 = ptr2.next;
        }
        System.out.println("Last person left standing " +
                "(Josephus Position) :- " + ptr1.data);
    }

    public static int ja(int n, int k) {  
         k--;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = 1; 
        }
        int cnt = 0, cut = 0,num = 1; 
        while (
            cnt< (n- 1)) 
        {
            while (num<= k) 
            {
                cut++;
                cut = cut% n; 
              
                if (arr[cut] == 1) {
                    num++; 
                }
            }
            num = 1; 
            arr[cut] = 0; 
            cnt++; 
            cut++;
            cut = cut % n; 
            while (arr[cut]== 0) 
            
            {
                cut++;
                cut = cut% n; 
            }
        }
        return cut+ 1; 
     
    }

    public int jr(int n, int k) {
        if (n == 1)
            return 1;
        else            
            return (jr(n - 1, k) + k - 1) % n + 1;//(start + k) % size

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("**** Josephus Problem ****");
        System.out.println("1.Array Implementation\n2.LL  Implementation\n3.Recursive Approach\nEnter your choice:-");
        int ch = Integer.parseInt(br.readLine());
        // System.out.println(ch);
        Josephus j = new Josephus();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of people :-");
        int n = sc.nextInt();
        System.out.println("Enter value of k :-");
        int k = sc.nextInt();      

        switch (ch) {
            case 1:
                System.out.println("Safe position is:-" + ja(n, k));
                break;
            case 2:
                j.jl(n, k);
                break;
            case 3:
                System.out.println("Safe position is:-"+j.jr(n, k));
                break;
        }

        br.close();
        sc.close();
    }

}
