package dsa.com.gl;
import java.util.*;
import java.util.Scanner;

public class FindSumPair 
{
		static class Node 
		{
			int nodeData;
			Node leftNode, rightNode;
		}

		static Node NewNode(int nodeData)
		{
			Node temp = new Node();
			temp.nodeData = nodeData;
			temp.leftNode = null;
			temp.rightNode = null;

			return temp;
		}

		public Node insert(Node root, int key)
		{
			if (root == null)
				return NewNode(key);
			if (key < root.nodeData)
				root.leftNode = insert(root.leftNode, key);
			else
				root.rightNode = insert(root.rightNode, key);
			return root;
		}

		public boolean findpair(Node root, int sum,
				HashSet<Integer> set){
	       if(root == null){
			   return false;
		   }

		   if(findpair(root.leftNode, sum, set)){
			   return true;
		   }
		   //check if the sum - root.nodeData
		   if(set.contains(sum - root.nodeData))
		   {
			   System.out.println("Pair that make up the sum are "+ (sum - root.nodeData) + ", "+ root.nodeData);
			   return true;
		   }
		   else {
			   set.add(root.nodeData);
			   return findpair(root.rightNode, sum, set);
		   }
		}

		public void findPairWithGivenSum(Node root, int sum){
			HashSet<Integer> set = new HashSet<>();
			if(!findpair(root, sum, set)){
				System.out.println("Nodes are not found");
			}
		}
		public static void main(String[] args)
		{
			int option=1;
			Node root = null;
			
			FindSumPair findsum = new FindSumPair();
			root = findsum.insert(root, 10);
			root = findsum.insert(root, 20);
			root = findsum.insert(root, 30);
			root = findsum.insert(root, 40);
			root = findsum.insert(root, 50);
			root = findsum.insert(root, 60);
			root = findsum.insert(root, 70);

			Scanner sc = new Scanner(System.in);
			int sum=130;
			findsum.findPairWithGivenSum(root, sum);
			while(option==1)
			{
				System.out.println("Do you want to enter the sum /n 1.Yes /n 2.exit");
				option =sc.nextInt();
				if(option!=1)
				{
					System.out.println("Exited\n");
					break;
				}
				System.out.println("Enter the sum required: ");
				int sum1 = sc.nextInt();
				findsum.findPairWithGivenSum(root, sum1);
				
			}

		}
}
			
			

		
	


