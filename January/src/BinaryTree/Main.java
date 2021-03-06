package BinaryTree;

import java.util.*;
public class Main
{
	public static void main(String[] args) {
    int arr[]={1,2,4,-1,5,-1,-1,3,6,-1,7,-1,-1,-1};
	int arr1[]={1,2,-1,-1};

		binarytree bt=new binarytree(arr);
    // bt.NodetoRoot(7);
    // System.out.println(bt.path);
   // bt.removeleafs();
    //bt.display();
    System.out.println("--------");
//    bt.mirror();
   // bt.preiter();
    System.out.println("--------");
    //bt.display();
   // System.out.println(bt.find(3));
	}
}
class binarytree
{
    Node root; 
    int size;
    class Node
    {
        int data;
        Node left;
        Node right;
    }
    binarytree(int arr[])
    {
        Stack<Node> st=new Stack<>();
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==-1)
            {
                st.pop();
            }
            else
            {
                Node node=new Node();
                node.data=arr[i];
                this.size++;
                if(st.size()==0)
                {
                    //st.push(node);
                    root=node;
                }
                else{
                    if(st.peek().left==null)
                    {
                       st.peek().left=node;
                    }
                    else{
                      st.peek().right=node;  
                    }
                    
                }
                st.push(node);
            }
            
        }
    }
    public void display()
    {
        display(root);
    }
    public void display(Node node)
    {
        if(node==null)
        {
            return;
        }
        else{
            String str="";
            str+=node.left!=null ? node.left.data+"->":"->";
            str+=node.right!=null ? node.data+"<-"+node.right.data: node.data+"<-";
            System.out.println(str);
            display(node.left);
            display(node.right);
            
        }
    }
    public int size()
    {
       return size(root);
    }
    public int size(Node node)
    {
        if(node==null)
        {
            return 0;
        }
        int l=size(node.left);
        int r=size(node.right);
        int total=l+r+1;
        return total;
        
    }
    public int max()
    {
        return max(root);
    }
    public int max(Node node)
    {
        if(node==null)
        {
            return 0;
        }
        
        int lmax=max(node.left);
        int rmax=max(node.right);
        int currmax=Math.max(lmax,rmax);
        return Math.max(currmax,node.data);
        
    }
    
    public int min()
    {
        return min(root);
    }
    public int min(Node node)
    {
        if(node==null)
        {
            return Integer.MAX_VALUE;
        }
        int lmin=min(node.left);
        int rmin=min(node.right);
        int curr=Math.min(lmin,rmin);
        return Math.min(curr,node.data);
        
    }
    
    public int height()
    {
        return height(root);
        
    }
    public int height(Node node)
    {
        if(node==null)
        {
            return 0;
        }
        int lh=height(node.left);
        int rh=height(node.right);
        int cur=Math.max(lh,rh);
        return cur+1;
    }
    
     public boolean find(int data)
    {
        return find(root,data);
    }
    public boolean find(Node node,int data)
    {
        if(node==null)
        {
            return false;
        }
        if(node.data==data)
        {
            return true;
        }
        
        boolean bl=find(node.left,data);
        if(bl==true)
        {
            return true;
        }
        
        boolean br=find(node.right,data);
        if(br==true)
        {
            return true;
        }
        return false;
    }
    
    public void removeleafs()
    {
        removeleafs(root);
    }
    public void removeleafs(Node node)
    {
        if(node==null)
        {
            return;
        }
        // if(node.left==null && node.right==null)
        // {
        //     return;
        // }
        if(isSafe(node.left))
        {
            node.left=null;
        }
        if(isSafe(node.right))
        {
            node.right=null;
        }
        removeleafs(node.left);
        removeleafs(node.right);
    }
    
    public boolean isSafe(Node node)
    {
        if(node==null)
        {
            return false;
        }
        if(node.left==null && node.right==null)
        {
            return true;
        }
        return false;
    }
    
    public void removeleafs2()
    {
        removeleafs2(null,root);
        
    }
    public void removeleafs2(Node parent, Node child)
    {
        if(child==null)
        {
            return ;
        }
        if(child.left==null &&child.right==null)
        {
            if(parent.left==child)
            {
                parent.left=null;
            }
            else{
                parent.right=null;
            }
        }
        removeleafs2(child,child.left);
        removeleafs2(child,child.right );
    }
    
    // public void removel()
    // {
    //     removel(root);
        
    // }
    // public void removel(Node parent)
    // {
    //     if(parent==null)
    //     {
    //         return ;
    //     }
    //     if(parent.left==null &&parent.right==null)
    //     {
    //         parent=null;
    //     }
    //     removel(parent.left);
    //     removel(parent.right );
    // }
    
    
    
    
    static ArrayList<Integer> path=new ArrayList<>();
    public boolean NodetoRoot(int data)
    {
        return NodetoRoot(root,data);
    }
    public boolean NodetoRoot(Node node,int data)
    {
        if(node==null)
        {
            
            return false;
        }
        if(node.data==data)
        {
            path.add(node.data);
            return true;
        }
        boolean b=NodetoRoot(node.left,data);
        if(b==true)
        {
            path.add(node.data);
            return true;
        }
        boolean bb= NodetoRoot(node.right,data);
        if(bb==true)
        {
            path.add(node.data);
            return true;
        }
        return false;
    }
    
    
    public void mirror()
    {
        mirror(root);
    }
    public void mirror(Node node)
    {
        if(node==null)
        {
            return ;
        }
        mirror(node.left);
        mirror(node.right);
        Node temp=node.left;
        node.left=node.right;
        node.right=temp;
        
    }
    
    public void levelorder()
    {
    	levelorder(root);
    }
	private void levelorder(Node node) {
		 Queue<Node> qu=new LinkedList<>();		
		 qu.add(node);
		 qu.add(null);
		 while(!qu.isEmpty())
		 {
			 Node curr=qu.poll();
			 if(curr==null)
			 {
				 System.out.println();
				 if(qu.size()!=0)
				 {
					 qu.add(null);
				 }
				 continue;
			 }
			 System.out.print(curr.data+" ");
			 if(curr.left!=null)
			 {
				 qu.add(curr.left);
			 }
			 if(curr.right!=null)
			 {
				 qu.add(curr.right);
			 }
		 }
	}
	
	public void levelorderwithsize()
    {
    	levelorder(root);
    }
	private void levelorderwithsize(Node node) {
		 Queue<Node> qu=new LinkedList<>();		
		 qu.add(node);
		 
		 while(!qu.isEmpty())
		 {
			 int csize=qu.size();
			 while(csize!=0)
			 {
				Node curr=qu.poll();
				 System.out.print(curr.data+" ");
				 if(curr.left!=null)
				 {
					 qu.add(curr.left);
				 }
				 if(curr.right!=null)
				 {
					 qu.add(curr.right);
				 }
				 csize--;
			 }
			 System.out.println();
		 }
	}
	
	public void singlechild()
	{
		singlechild(root,root.left);
		singlechild(root,root.right);

	}
	private void singlechild(Node parent,Node child) {
		if(child==null)
		{
			return;
		}
		// TODO Auto-generated method stub
		 if(parent.left==null && parent.right==child)
		 {
			 System.out.println(child.data);
		 }
		 else if(parent.right==null && parent.left==child)
		 {
			 System.out.println(child.data);
		 }
		 singlechild(child,child.left);
		 singlechild(child,child.right);
	}
	
	public void singlechild2()
	{
		singlechild(root);
		

	}
	private void singlechild2(Node node) {
		if(node==null)
		{
			return;
		}
		// TODO Auto-generated method stub
		 if(node.left==null && node.right!=null)
		 {
			 singlechild2(node.left);
			 singlechild2(node.right);
		 }
		 else if(node.right!=null)
		 {
			 System.out.println(node.right.data);
			 singlechild2(node.right);
		 }
		 else if(node.left!=null)
		 {
			 System.out.println(node.left);
			 singlechild2(node.left);

		 }
		 
	}
	
	public void printlefttorootsum(int lo,int hi)
	{
		printlefttorootsum(root,"",0,lo,hi);
	}
	private void printlefttorootsum(Node node,String res,int sum, int lo, int hi) {
		// TODO Auto-generated method stub
		if(node==null)
		{
			return;
		}
		if(node.left==null && node.right==null)
		{
			res+=node.data+" ";
			sum+=node.data;
			if(sum>lo &&sum<hi)
			{
				System.out.println(res);
			}
			return;
		}
		printlefttorootsum(node.left,res+node.data+" ",sum+node.data,lo,hi);
		printlefttorootsum(node.right,res+node.data+" ",sum+node.data,lo,hi);
	}
	
	public ArrayList<Node> NodetoRoot1(int data)
	{
		return NodetoRoot1(root,data);
	}
	private ArrayList<Node> NodetoRoot1(Node node, int data) {
		// TODO Auto-generated method stub
		if(node==null)
		{
			ArrayList<Node> al=new ArrayList<>();
			return al;
		}
		if(node.data==data)
		{
			ArrayList<Node> res=new ArrayList<>();
			res.add(node);
			return res;
		}
		ArrayList<Node> recl=NodetoRoot1(node.left,data);
		if(recl.size()>0)
		{
			recl.add(node);
			return recl;
		}
		ArrayList<Node> recr=NodetoRoot1(node.right,data);
		if(recr.size()>0)
		{
			 recr.add(node);
			return recr;

		}
		return new ArrayList<Node>();
	}
	public void kwayfromnode()
	{
		kwayfromnode(root,2);
	}
	public void kwayfromnode(Node node,int k)
	{
		if(node==null || k<0)
		{
			return;
		}
		if(k==0)
		{
			System.out.println(node.data);
			return;
			
		}
		kwayfromnode(node.left,k--);
		kwayfromnode(node.right,k--);
	}
    
	
	public void printleftview()
	{
		printleftview(root);
	}
	private void printleftview(Node node) {
		// TODO Auto-generated method stub
		Queue<Node> qu=new LinkedList<>();
		qu.add(node);
		while(qu.size()>0)
		{
			int csize=qu.size();
			//int i=0;
			//while(i++<csize)
			for(int i=1;i<=csize;i++)
			{
				Node temp=qu.poll();
				if(i==i)
				{
					System.out.println(temp.data);
				}
				if(temp.left!=null)
				{
					qu.add(temp.left);
				}
				if(temp.right!=null)
				{
					qu.add(temp.right);
				}
			}
			
		}
			
	}
	
	// print left view using Recurssion
	static int max;
	Map<Integer,Integer> mp=new LinkedHashMap<>();
	public void prinkleftviewRecurssion()
	{
		prinkleftviewRecurssion(root,0);
		System.out.println(mp);
	}
	private void prinkleftviewRecurssion(Node node,int level) {
		// TODO Auto-generated method stub
		if(node==null)
		{
			return;
		}
		//by using hashmap
		mp.put(level, node.data);
		//by using recursion
//		if(max<level)
//		{
//			System.out.println(node.data);
//			max=level;
//		}
		
		
		prinkleftviewRecurssion(node.right,level+1);
		prinkleftviewRecurssion(node.left,level+1);
	}
	
	public void rightview()
	{
		rightview(root);
	}
	private void rightview(Node node) {
		// TODO Auto-generated method stub
		Queue<Node> qu=new LinkedList<>();
		qu.add(node);
		while(qu.size()>0)
		{
			int csize=qu.size();
			for(int i=1;i<=csize;i++)
			{
				Node temp=qu.poll();
				if(i==csize)
				{
					System.out.println(temp.data);
				}
				if(temp.left!=null)
				{
					qu.add(temp.left);
				}
				if(temp.right!=null)
				{
					qu.add(temp.right);
				}
			}
		}
		
	}
	static int minlevel;
	public void rightviewrecursion()
	{
		rightviewrecursion(root,1);
	}
	
	private void rightviewrecursion(Node node,int level) {
		// TODO Auto-generated method stub
		if(node==null)
		{
			return;
		}
		if(minlevel<level)
		{
			System.out.println(node.data);
			minlevel=level;
		}
		rightviewrecursion(node.right,level+1);
		rightviewrecursion(node.left,level+1);
		
	}
	
	public void lowestcommonAnsistors(int l1,int l2)
	{
		lowestcommonAnsistors(root,l1,l2);
	}
	private void lowestcommonAnsistors(Node node,int l1,int l2) {
		// TODO Auto-generated method stub
		if(node==null)
		{
			return;
		}
		ArrayList<Node> p1=NodetoRoot1(node,l1);
		ArrayList<Node> p2=NodetoRoot1(node,l2);
		int i=p1.size()-1;
		int j=p2.size()-1;
		int par=0;
		
		while(i>=0 && j>=0 && (p1.get(i).data==p2.get(j).data) )
		{
			par=p2.get(j).data;
			i--;
			j--;
			
		}
		System.out.println(par);
	}
	public void LCAR(int l1,int l2)
	{
		System.out.println(LCAR(root,l1,l2).data);
	}
	private Node LCAR(Node node, int l1, int l2) {
		// TODO Auto-generated method stub
		if(node==null)
		{
			return null;
		}
		if(node.data==l1||node.data==l2)
		{
			return node;
		}
		Node lef=LCAR(node.left,l1,l2);
		Node rig=LCAR(node.right,l1,l2);
		if(lef!=null && rig!=null)
		{
			return node;
		}
		if(lef==null && rig==null)
		{
			return null;
		}
		return lef!=null ? lef:rig;

	}
	class pair
	{
		Node node;
		int wc;
		pair(Node node,int data)
		{
			this.node=node;
			this.wc=data;
		}
	}
//	public void preiter()
//	{
//		preiter(root);
//	}
//	private void preiter(Node node) {
//		// TODO Auto-generated method stub
//		Stack<pair> st=new Stack<>();
//		st.push(new pair(node,0));
//		while(st.size()>0)
//		{
//			pair temp=st.peek();
//			System.out.println(temp.node.data+" "+temp.wc);
//			if(temp.wc==0)
//			{
//				System.out.println("Step1: ");
//				System.out.println("Result: "+temp.node.data);
//				temp.wc++;
//			}
//			else if(temp.wc==1)
//			{
//				if(temp.node.left!=null)
//				{
//					System.out.println("Step2: ");
//					pair left=new pair(temp.node.left,0);
//					st.push(left);
//					
//				}
//				temp.wc++;
//			}
//			else if(temp.wc==2)
//			{
//				if(temp.node.right!=null)
//				{
//					System.out.println("Step3: ");
//					pair right=new pair(temp.node.right,0);
//					st.push(right);
//					
//				}
//				temp.wc++;
//			}
//			else
//			{
//				System.out.println("Step4: ");
//				st.pop();
//			}
//		}
//		
//		
//	}
	
	public  void converttolinklist()
	{
		converttolinklist(root);
	}
private void converttolinklist(Node node ) {
	// TODO Auto-generated method stub
	if(node==null)
	{
		return ;
	}
	if(node.left==null && node.right==null)
	{
		return;
	}
	if(node.left!=null)
	{
		converttolinklist(node.left);
		Node temp=node.right;
		node.right=node.left;
		node.left=null;
		
		Node curr=node.right;
		while(curr.right!=null)
		{
			curr=curr.right;
		}
		curr.right=temp;
	}
	converttolinklist(node.right);
}


	
	
}
