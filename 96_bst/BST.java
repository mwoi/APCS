/**
 * class BST
 * v1:partial
 * SKELETON
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT)
 *
 * A BST maintains the invariant that, for any node N with value V,
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value,
 *  and any value in its right subtree must be greater.)
 *
 * This BST implementation only holds ints (its nodes have int cargo)
 */

public class BST
{

  //instance variables / attributes of a BST:
  TreeNode _root;

  /**
   * default constructor
   */
  BST()
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    this._root = null;
  }


  /**
   * void insert( int )
   * Adds a new data element to tree.
   */
  public void insert( int newVal )
  {
    TreeNode newNode = new TreeNode( newVal );

    if ( _root == null ) {
      _root = newNode;
      return;
    }
    insert( _root, newNode );
  }
  //recursive helper for insert(int)
  public void insert( TreeNode stRoot, TreeNode newNode )
  {
    if ( newNode.getValue() < stRoot.getValue() ) {
      //if no left child, make newNode the left child
      if ( stRoot.getLeft() == null )
        stRoot.setLeft( newNode );
      else //recurse down left subtree
        insert( stRoot.getLeft(), newNode );
      return;
    }
    else { // new val >= curr, so look down right subtree
      //if no right child, make newNode the right child
      if ( stRoot.getRight() == null )
        stRoot.setRight( newNode );
      else //recurse down right subtree
        insert( stRoot.getRight(), newNode );
      return;
    }
  }//end insert()





  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

  // each traversal should simply print to standard out
  // the nodes visited, in order

  //process root, recurse left, recurse right
  public void preOrderTrav()
  {
    preOrderTrav( _root );
  }
  public void preOrderTrav( TreeNode currNode )
  {
    if ( currNode == null )
	    return;
    System.out.print( currNode.getValue() + " " );
    preOrderTrav( currNode.getLeft() );
    preOrderTrav( currNode.getRight() );
  }

  //recurse left, process root, recurse right
  public void inOrderTrav()
  {
    inOrderTrav( _root );
  }
  public void inOrderTrav( TreeNode currNode )
  {
    if ( currNode == null )
      return;
    inOrderTrav( currNode.getLeft() );
    System.out.print( currNode.getValue() + " " );
    inOrderTrav( currNode.getRight() );
  }

  //recurse left, recurse right, process root
  public void postOrderTrav()
  {
    postOrderTrav( _root );
  }
  public void postOrderTrav( TreeNode currNode )
  {
    if ( currNode == null )
      return;
    postOrderTrav( currNode.getLeft() );
    postOrderTrav( currNode.getRight() );
    System.out.print( currNode.getValue() + " "  );
  }


    /*****************************************************
     * TreeNode search(int)
     * returns pointer to node containing target,
     * or null if target not found
     *****************************************************/
    TreeNode search( int target )
    {
    	/*** YOUR IMPLEMENTATION HERE ***/
      return search(_root, target);
    }

    TreeNode search(TreeNode _root, int target) {
      if (_root.getValue() == target) {return _root;}
      if (target < _root.getValue() && _root.getLeft() != null) {
        return search(_root.getLeft(), target);
      } else if (target > _root.getValue() && _root.getRight() != null) {
        return search(_root.getRight(), target);
      }
      return null; // root is not found ! go back!
      
      //if we are here then we have traversed through the thing but have not found target!!
    }


    /*****************************************************
     * int height()
     * returns height of this tree (length of longest leaf-to-root path)
     * eg: a 1-node tree has height 1
     *****************************************************/
    public int height()
    {
    	/*** YOUR IMPLEMENTATION HERE ***/
      // need to find the longest subtree strip so need math.max
      return height(_root);
    }

    public int height(TreeNode _root) {
      if (_root == null) return 0; // you have reached bottom / lowest level
      else return Math.max(height(_root.getLeft()) + 1, height(_root.getRight()) + 1);
    }

    /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
    public int numLeaves()
    {
    	/*** YOUR IMPLEMENTATION HERE ***/
      return numLeaves(_root);
      
    }

    public int numLeaves(TreeNode _root) {
      if (_root == null) return 0; // you have hit no such things nothing exists go back
      if (_root.getLeft() == null && _root.getRight() == null) return 1; //this is a leaf
      else return numLeaves(_root.getLeft()) + numLeaves(_root.getRight()); // binary tree so much traverse left and right subtrees
    }

    

  //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  //main method for testing
  public static void main( String[] args )
  {
    
      BST arbol = new BST();

      //PROTIP: sketch state of tree after each insertion
      //        ...BEFORE executing these.
      arbol.insert( 4 );
      arbol.insert( 2 );
      arbol.insert( 5 );
      arbol.insert( 6 );
      arbol.insert( 1 );
      arbol.insert( 3 );
      arbol.insert(2);

      // System.out.println( "\n-----------------------------");
      // System.out.println( "pre-order traversal:" );
      // arbol.preOrderTrav();

      // System.out.println( "\n-----------------------------");
      // System.out.println( "in-order traversal:" );
      // arbol.inOrderTrav();

      // System.out.println( "\n-----------------------------");
      // System.out.println( "post-order traversal:" );
      // arbol.postOrderTrav();

      // System.out.println( "\n-----------------------------");
      /*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~

      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
      System.out.println(arbol._root.getLeft());
      System.out.println(arbol.numLeaves());
      System.out.println(new TreeNode(3));
  }

}//end class
