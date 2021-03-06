package BinaryTree;
import java.util.*;
public class HomeworkBinaryTree {
	public static void main(String[] args) {
	    int arr[]={1,2,4,-1,5,-1,-1,3,6,-1,11,-1,-1,-1};
	     int arr3[]={1,2,4,-1,5,-1,-1,2,5,-1,4,-1,-1,-1};
	    int arr1[]={1,2,3,4,-1,-1,6,-1,-1,-1};
	    binarytreehomework bt=new binarytreehomework(arr);
	   
	    System.out.println("--------");
	  // ***count subtrees given sum equal: 2 ***
//	    bt.countsubtree(11);
//	    System.out.println(bt.count);
//	    
//	   //3]*** INORDER WITHOUT RECURSION***  3
//	    
//	    //bt.inorder();
//	    
//	    //4]5] MOOris Algorithm for in and preorder
//	   // bt.morrispreorder();
//	    //bt.morrisinorder();
//	    //vertical and diagonal
//	    bt.diagonatreerecursive();
//	    bt.vertical();
	    
	 //   bt.boundarytree();
	//    bt.perfectbinarytree();
	 //   bt.topview();
	    bt.bottomview();
 
		}
}
class binarytreehomework
{
    Node root;
    int size;
    class Node
    {
        int data;
        Node left;
        Node right;
       
    }
    binarytreehomework(int arr[])
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
    static Node tempnode;
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
            tempnode=node;
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
    
    public static ArrayList<Node> nodetoRoot(Node node, int data) {
		if (node == null) {
			ArrayList<Node> br = new ArrayList<Node>();
			return br;
		}

		if (node.data == data) {
			ArrayList<Node> br = new ArrayList<Node>();
			br.add(node);
			return br;
		}
		ArrayList<Node> myres = nodetoRoot(node.left, data);
		if (myres.size() > 0) {
			myres.add(node);
			return myres;
		}

		ArrayList<Node> myres1 = nodetoRoot(node.right, data);
		if (myres1.size() > 0) {
			myres1.add(node);
			return myres1;
		}

		return new ArrayList<Node>();
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
    public void printkdown(Node node,int k)
    
    {
        if(node==null)
        {
            return;
        }
        if(k==0)
        {
            System.out.println(node.data);
        }
        printkdown(node.left,k--);
        printkdown(node.right,k--);
    }
    
    public void printkway(int data,int k)
    {
        printkway(root,data,k);
    }
    public void printkway(Node node,int data,int k)
    {
         ArrayList<Node> path=nodetoRoot(node,data);
        printkdown(path.get(0),k);
        for(int i=1;i<path.size()&& i<k;i++)
        {
           Node n=path.get(i); 
           Node nm=path.get(i-1);
           if(n.left==nm)
           {
               printkdown(n.right,k-i-1);
           }
           else{
               printkdown(n.left,k-i-1);

           }
        }
        
        if(path.size()>k)
        {
            System.out.println(path.get(k).data);
        }
    }
    
    public void leftview()
    {
        leftview(root);
    }
    public void leftview(Node node)
    {
        Queue<Node> qu=new LinkedList<>();
        Queue<Node> sub=new LinkedList<>();
        qu.add(node);
        int n=qu.size();
        while(n!=0)
        {
            Node r=qu.poll();
            if(r.left!=null)
            {
                sub.add(node.left);
            }
            if(r.right!=null)
            {
                sub.add(node.right);
            }
            n--;
        }
    }
    static boolean flag=true;
    public void isBalancedtree()
    {
         isBalancedtree(root);
          System.out.println(flag);
    }
    public void isBalancedtree(Node node)
    {
        if(node==null)
        {
            return ;
        }
       
        int lheight=height(node.left);
        int rheight=height(node.right);
        int gap=Math.abs(lheight-rheight);
        if(gap>1)
        {
            flag=false;
        }
        
    }
    
    class pair
    {
        int height;
        boolean balance;
        pair(int height,boolean balance)
        {
            this.height=height;
            this.balance=balance;
        }
    }
    
    public boolean isbalancetreesmart()
    {
        return isbalancetreesmart(root).balance;
    }
    public pair isbalancetreesmart(Node node)
    {
        if(node==null)
        {
            return new pair(0,true);
        }
        pair left=isbalancetreesmart(node.left);
        pair right=isbalancetreesmart(node.right);
        if(left.balance==false || right.balance==false)
        {
            return new pair(Math.max(left.height,right.height)+1,false);
        }
        if(left.height-right.height>=-1 && left.height-right.height<2)
        {
            return new pair(Math.max(left.height,right.height)+1,true);
        }
         return new pair(Math.max(left.height,right.height)+1,false);
    }
    
    class pair2
   {
       int height;
       int diameter;
       pair2(int h,int d)
       {
           this.height=h;
           this.diameter=d;
       }
   }
    public int maxdiameter()
    {
        return maxdiameter(root).diameter;
    }
    public pair2 maxdiameter(Node node)
    {
        if(node==null)
        {
            return new pair2(0,0);
        }
        pair2 l=maxdiameter(node.left);
        pair2 r=maxdiameter(node.right);
        int he=Math.max(l.height,r.height)+1;
        int maxd=l.height+r.height+1;
        return new pair2(he,Math.max(maxd,Math.max(l.diameter,r.diameter)));
    }
    
    
    public void invertree()
    {
        invertree(root);
    }
    public void invertree(Node node)
    {
        if(node==null)
        {
            return ;
        }
        invertree(node.left);
        invertree(node.right);
        
        Node temp=node.left;
        node.left=node.right;
        node.right=temp;
    }
    
   public boolean ISINVERTTREE()
   {
       return ISINVERTTREE(root,tempnode);
   }
   public boolean ISINVERTTREE(Node node1,Node node2)
   {
       if(node1==null && node2==null)
       {
           return true;
       }
       if(node1.data!=node2.data)
       {
           return false;
       }
       boolean b=ISINVERTTREE(node1.left,node2.left);
       if(b==false)
       {
           return false;
       }
       boolean b2=ISINVERTTREE(node1.right,node2.right);
        if(b2==false)
       {
           return false;
       }
       return true;
       
   }
   
   public Node findnode(int data)
   {
       return findnode(root,data);
   }
   public Node findnode(Node node,int data)
   {
       if(node==null)
       {
           return null;
       }
       if(node.data==data)
       {
           return node;
       }
       Node left=findnode(node.left,data);
       Node right=findnode(node.right,data);
       
       
       if(left!=null)
       {
           return left;
       }
       if(right!=null)
       {
           return right;
       }
    return null;

   }
   
   public void deeplevelsum()
   {
        deeplevelsum(root);
   }
   public void deeplevelsum(Node node)
   {
      Queue<Node> qu = new LinkedList<>();
      ArrayList<Integer> al=new ArrayList<>();
		qu.add(node);
       int sum=0;
       //qu.push(node);
       while(qu.size()>0)
       {
        sum=0;
           int n=qu.size();
           for(int i=1;i<=n;i++)
           {
               Node temp=qu.poll();
              sum+=temp.data;
               //System.out.print(temp.data+" ");
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
        System.out.println(sum);
     
      // return sum;
   }
   
   class pair3
   {
       boolean isbst;
       int min;
       int max;
    //   pair3(boolean isbst,int min,int max)
    //   {
    //       this.isbst=isbst;
    //       this.min=min;
    //       this.max=max;
    //   }
   }
   public boolean isBST()
   {
       return isBST(root).isbst;
   }
   public pair3 isBST(Node node)
   {
       if(node==null)
       {
           pair3 p = new pair3();
			p.isbst = true;
			p.max = Integer.MIN_VALUE;
			p.min = Integer.MAX_VALUE;
			return p;
       }
       
       pair3 left=isBST(node.left);
       pair3 right=isBST(node.right);
       if(left.isbst==false ||right.isbst==false)
       {  
           pair3 x=new pair3();
           x.isbst=false;
           return x;
       }
       pair3 y=new pair3();
       y.max=Math.max(Math.max(left.max,right.max),node.data);
       y.min=Math.min(Math.min(left.min,right.min),node.data);
       if(left.min<node.data && node.data>right.max)
       {
           y.isbst=true;
       }
       else{
           y.isbst=false;
       }
       return y;
      
   }
   public boolean issubtee()
   {
       return issubtee(root,root);
   }
   
   public boolean issubtee(Node root,Node sub)
   {
       if(root==null)
       {
           return false;
       }
       if(sub==null)
       {
           return false;
       }
       if(isequal(root,sub))
       {
           return true;
       }
       return issubtee(root.left,sub) || issubtee(root.right,sub);
   }
   public boolean isequal(Node root,Node sub)
   {
       if(root.left==null && sub.left==null)
       {
           return true;
       }
       if(root.left==null || root.right==null)
       {
           return false;
       }
       if(root.data==sub.data)
       {
           boolean l=isequal(root.left,sub.left);
           boolean r=isequal(root.right,sub.right);
           if(l==true && r==true)
           {
               return true;
           }
       }
       return false;
   }
   
   public boolean isSymmetric()
   {
       return isSymmetric(root,root);
   }
   public boolean isSymmetric(Node node1,Node node2)
   {
       if(node1==null && node2==null)
       {
           return true;
       }
       if(node1==null && node2!=null)
       {
           return false;
       }
       if(node2==null && node1!=null)
       {
           return false;
       }
       if(node1.data==node2.data)
       {
           boolean left=isSymmetric(node1.left,node2.right);
           boolean right=isSymmetric(node1.right,node2.left);
           if(left==true&& right==true)
           {
               return true;
           }
       }
       return false;
   }
   int count=0;
   public void countsubtree(int x)
   {
       countsubtree(root,x);
   }
   public void countsubtree(Node node,int x)
   {   
       if(node==null)
       {
           return;
       }
       int res=sum(node);
       if(res==x)
       {
          count++;
       }
       countsubtree(node.left,x);
       countsubtree(node.right,x);
   }
   public int sum(Node node)
   {
       if(node==null)
       {
           return 0;
       }
       int left=sum(node.left);
       int right=sum(node.right);
       return (left+right+node.data);
   }
   class pair4
   {
       Node node;
       int wc;
       pair4(Node node,int wc)
       {
           this.node=node;
           this.wc=wc;
       }
   }
   public void inorder()
   {
       inorder(root);
   }
   public void inorder(Node node)
   {
       Stack<pair4> st=new Stack<>();
       st.push(new pair4(node,0));
       while(st.size()>0)
       {
           pair4 ele=st.peek();
           if(ele.wc==1)
           {
               System.out.println(ele.node.data);
               ele.wc++;
           }
           else if(ele.wc==0)
           {
               if(ele.node.left!=null)
               {
                   st.push(new pair4(ele.node.left,0));
               }
               ele.wc++;
           }
           else if(ele.wc==2)
           {
               if(ele.node.right!=null)
               {
                   st.push(new pair4(ele.node.right,0));
               }
               ele.wc++;
           }
           else{
               st.pop();
           }
           
       }
   }
   
   public void morrispreorder()
   {
	   morrispreorder(root);
   }
	private void morrispreorder(Node curr) {
		// TODO Auto-generated method stub
		while(curr!=null)
		{
			System.out.println(curr.data);
			if(curr.left!=null)
			{
				Node temp=curr.left;
				while(temp.right!=null)
				{
					temp=temp.right;
				}
				temp.right=curr.right;
				curr=curr.left;
				
			}
			else
			{
				curr=curr.right;
			}
		}	
	}
	
	public void morrisinorder()
	{
		morrisinorder(root);
	}
	private void morrisinorder(Node curr) {
		// TODO Auto-generated method stub
		while(curr!=null)
		{
			if(curr.left!=null)
			{
				Node temp=curr.left;
				
				Node lp=curr.left;
				while(temp.right!=null)
				{
					temp=temp.right;
				}
				temp.right=curr;
				curr.left=null;
				curr=lp;
			}
			else
			{
				System.out.println(curr.data);
				curr=curr.right;
			}
		}
		
	}

   public void diagonaltree()
   {
	   diagonaltree(root);
   }
private void diagonaltree(Node node) {
	// TODO Auto-generated method stub
	Queue<Node> qu=new LinkedList<>();
	Node temp=node;
	while(temp!=null)
	{
		qu.add(temp);
		temp=temp.right;
	}
	for(Node ele:qu)
	{
		System.out.print(ele.data+" ");
	}
	System.out.println();
	while(qu.size()>0)
	{
		int size=qu.size();
		while(size>0)
		{
			Node var=qu.poll();
			if(var.left!=null)
			{
				//qu.add(var.left);
				Node fun=var.left;
				while(fun!=null)
				{
					qu.add(fun);
					fun=fun.right;
				}
			}
			
			size--;
		}
		for(Node ele:qu)
		{
			System.out.print(ele.data+" ");
		}
		System.out.println();
	}
	
	
}

	public void diagonatreerecursive()
	{
		diagonatreerecursive(root);
	}
	private void diagonatreerecursive(Node node) {
		// TODO Auto-generated method stub
		HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>();
		performrecursion(node,0,hm);
//		for(int i=0;i<hm.size();i++)
//		{
//			System.out.println(hm.get(i));
//		}
		for(int gg:hm.keySet())
		{
			System.out.println(hm.get(gg));
		}
		
	}
	private void performrecursion(Node node, int d, HashMap<Integer, ArrayList<Integer>> hm) {
		// TODO Auto-generated method stub
		if(node==null)
		{
			return;
		}
		hm.putIfAbsent(d,new ArrayList<Integer>());
		hm.get(d).add(node.data);
		performrecursion(node.left,d+1,hm);
		performrecursion(node.right,d ,hm);
	}
	class pairqu
	{
		Node node;
		int distance;
		pairqu(Node node,int distance)
		{
			this.node=node;
			this.distance=distance;
		}
	}
	public void vertical()
	{
		vertical(root);
	}
	private void vertical(Node node) {
		// TODO Auto-generated method stub
		if(node==null)
		{
			return;
		}
		TreeMap<Integer,List<Integer>> shm=new TreeMap<>();
		Queue<pairqu> qu=new LinkedList<>();
		qu.add(new pairqu(node,0));
		while(qu.size()>0)
		{
			Node tempnode=qu.peek().node;
			int temdata=qu.peek().distance;
			qu.poll();
			shm.putIfAbsent(temdata, new LinkedList<>());
	        shm.get(temdata).add(tempnode.data);
			if(tempnode.left!=null)
			{
				qu.add(new pairqu(tempnode.left,temdata-1));
			}
			if(tempnode.right!=null)
			{
				qu.add(new pairqu(tempnode.right,temdata+1));
			}
		}
		for(int gg:shm.keySet())
		{
			System.out.println(shm.get(gg));
		}	
	}
	
	public void boundarytree()
	{
		boundarytree(root);
	}
	private void boundarytree(Node node) {
		// TODO Auto-generated method stub
		if(node==null)
		{
			
			return;
		}
		System.out.print(node.data+" ");
		leftboundary(root.left);
		Leafnodes(root);
		Righttree(node.right);
	}
	private void Leafnodes(Node node) {
		if(node==null)
		{
			return;
		}
		if(node.left==null && node.right==null)
		{
			System.out.print(node.data+" ");
		}
		Leafnodes(node.left);
		Leafnodes(node.right);
		
	}
	private void Righttree(Node node) {
		// TODO Auto-generated method stub
		if(node==null)
		{
			return;
		}
		if(node.right!=null)
		{
			Righttree(node.right);
			System.out.print(node.data+" ");
		}
		else if(node.left!=null)
		{
			Righttree(node.left);
			System.out.print(node.data+" ");	
		}
	}
	private void leftboundary(Node node) {
		// TODO Auto-generated method stub
		if(node==null)
		{
			return;
		}
		if(node.left!=null)
		{
			System.out.print(node.data+" ");
			leftboundary(node.left);
		}
		else if(node.right!=null)
		{
			System.out.print(node.data+" ");
			leftboundary(node.right);
			
		}
	
	}
	
	public void perfectbinarytree()
	{
		perfectbinarytree(root);
	}
	private void perfectbinarytree(Node node) {
		// TODO Auto-generated method stub
		if(node==null)
		{
			return;
		}
		System.out.print(node.data+" ");
		Queue<Node> qu=new LinkedList<>();
		if(node.left!=null)
		{
			System.out.print(node.left.data+" ");
			qu.add(node.left);
		}
		if(node.right!=null)
		{
			System.out.print(node.right.data+" ");
			qu.add(node.right);
		}
		while(qu.size()>0)
		{
			LinkedList<Node> anotherqu=new LinkedList<>();
			int size=qu.size();
			while(size>0)
			{
				Node temp=qu.peek();
				qu.poll();
				if(temp.left!=null)
				{
					qu.add(temp.left);
					anotherqu.add(temp.left);
				}
				if(temp.right!=null)
				{
					qu.add(temp.right);
					anotherqu.add(temp.right);
				}
				size--;
			}
			while(anotherqu.size()!=0)
			{
				Node first=anotherqu.removeFirst();
				Node sec=anotherqu.removeLast();
				
				System.out.print(first.data+" "+sec.data+" ");	
			}
		}
		
	}
	
	public void topview()
	{
		topview(root,0);
	}
	private void topview(Node node,int d) {
		// TODO Auto-generated method stub
		if(node==null)
		{
			return;
		}
		Map<Integer,Integer> hm=new TreeMap<>();

		Queue<pairqu> qu=new LinkedList<>();
		qu.add(new pairqu(node,0));
		while(qu.size()>0)
		{
			Node tnode=qu.peek().node;
			int tdistance=qu.peek().distance;
			
			qu.poll();
			if(!hm.containsKey(tdistance))
			{
				hm.put(tdistance, tnode.data);
			}
			if(tnode.left!=null)
			{
			qu.add(new pairqu(tnode.left,tdistance-1));
			}
			if(tnode.right!=null)
			{
			qu.add(new pairqu(tnode.right,tdistance+1));
			}
		}
		
		for(int gg:hm.keySet())
		{
			System.out.print(hm.get(gg)+" ");
		}
	}
	
	
	public void bottomview()
	{
		bottomview(root);
	}
	private void bottomview(Node node) {
		// TODO Auto-generated method stub
		if(node==null)
		{
			return;
		}
		Map<Integer,Integer> hm=new TreeMap<>();
		Queue<pairqu> qu=new LinkedList<>();
		qu.add(new pairqu(node,0));
		while(qu.size()>0)
		{
			Node tnode=qu.peek().node;
			int tdistance=qu.peek().distance;
			qu.poll();
			if(!hm.containsKey(tdistance))
			{
				hm.put(tdistance, tnode.data);
			}
			else
			{
				hm.put(tdistance, tnode.data);
			}
			if(tnode.left!=null)
			{
				qu.add(new pairqu(tnode.left,tdistance-1));
			}
			if(tnode.right!=null)
			{
				qu.add(new pairqu(tnode.right,tdistance+1));
			}
		}
		for(int gg:hm.keySet())
		{
			System.out.print(hm.get(gg)+" ");
		}	
	}
	
	
   
}




