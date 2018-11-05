import java.util.*;

public class myQuestion{
    public static void main( String[] args ){
        myGraph graph = new myGraph();

        myNode[] temp = new myNode[ 11 ];
        temp[0] = new myNode("a", 2);
        temp[1] = new myNode("b", 2);
        temp[2] = new myNode("c", 2);
        temp[3] = new myNode("d", 2);
        temp[4] = new myNode("e", 1);
        temp[5] = new myNode("f", 2);

        temp[6] = new myNode("g", 1);
        temp[7] = new myNode("h", 2);
        temp[8] = new myNode("i", 1);
        temp[9] = new myNode("j", 1);
        temp[10] = new myNode("k", 1);

        temp[0].addAdjacent( temp[1] ); //A->B
        temp[0].addAdjacent( temp[2] ); //A->C
        temp[1].addAdjacent( temp[2] ); //B->C
        temp[1].addAdjacent( temp[3] ); //B->D
        temp[2].addAdjacent( temp[4] ); //C->E
        temp[2].addAdjacent( temp[5] ); //C->F
        temp[3].addAdjacent( temp[8] ); //D->I
        temp[3].addAdjacent( temp[9] ); //D->J
        temp[4].addAdjacent( temp[5] ); //E->F
        temp[5].addAdjacent( temp[6] ); //F->G
        temp[5].addAdjacent( temp[7] ); //F->H
        temp[6].addAdjacent( temp[4] ); //G->E
        temp[7].addAdjacent( temp[8] ); //H->I
        temp[7].addAdjacent( temp[10] ); //H->K
        temp[8].addAdjacent( temp[9] ); //I->J
        temp[9].addAdjacent( temp[10] ); //J->K
        temp[10].addAdjacent( temp[8] ); //K->I

        for( int i = 0; i < 11; i++ ) {
            graph.add_nodes( temp[i] );
        }

        List<myNode> ret = new ArrayList<myNode>();
        ret.add( temp[0] );
        dfs( graph, temp[0], temp[10], ret );

        if( bfs( graph, temp[0], temp[10] )){
            System.out.println( "Found a route in BFS\n" );
        }
        else{
            System.out.println( "BFS route not found\n" );
        }
    }

    public static boolean bfs( myGraph g, myNode start, myNode end ){
        // use linked list to implement a queue (add, removeFirst, isEmpty)
        LinkedList<myNode> q = new LinkedList<myNode>();
        myNode temp_node_add;
        q.add( start );
        while( !q.isEmpty() ){
            // get the first element in the queue
            temp_node_add = q.removeFirst();
            temp_node_add.state = myNode.State.Visited;
            for( myNode temp_node : temp_node_add.adjacent ){
                if( temp_node.state == myNode.State.unVisited ){
                    if( end.vertex.equals( temp_node.vertex ) ){
                        // note that the bfs finding sequence DOESN'T contain backtracking so we cannot find a route
                        // (weighted graph)Dijkstra's algorithm renew all node's state on adding a node to th result
                        return true;
                    }
                    else{
                        // add its adjacent node to queue
                        q.add( temp_node );
                    }
                }
            }
        }
        return false;
    }

    //dfs return a List from start to end
    public static void dfs( myGraph g, myNode start, myNode end, List<myNode> ret ){
        //System.out.printf( "Checking %s\n", start.vertex );
        for( myNode mn : start.adjacent ){
            //if cannot find any unVisited node, the loop goes on
            if( mn.get_state() == myNode.State.unVisited ){
                if( end.vertex.equals( mn.vertex ) ){
                    //System.out.printf( "%s\n", mn.vertex );
                    System.out.printf( "DFS:\n" );
                    ret.add( mn );
                    print_list( ret );
                    ret.remove( ret.get( ret.size() - 1 ) );
                    return;
                }
                else{
                    ret.add( mn );
                    mn.set_state( myNode.State.Visited );
                    dfs( g, mn, end, ret );
                    /* For case reaching here, the dfs is returned, so no need to maintain the visit state */
                    ret.remove( ret.get( ret.size() - 1 ) ); // remove method removes certain object
                    mn.set_state( myNode.State.unVisited );
                }
            }
        }
    }

    public static void print_list( List<myNode> l ){
        for( myNode i : l ){
            System.out.print( i.vertex + "->" );
        }
        System.out.print("\n");
    }
}