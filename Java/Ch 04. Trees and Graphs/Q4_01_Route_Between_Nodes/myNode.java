public class myNode{
    myNode[] adjacent;
    String vertex;
    State state;
    public int adjacent_cnt = 0;
    //this is actually like a typedef
    public enum State{
        Visited, unVisited
    }

    public myNode( String vertex, int adjacentlength ){
        this.vertex = vertex;
        adjacent = new myNode[ adjacentlength ];
        state = State.unVisited;
    }

    public myNode(){
        this( "default", 5 );
    }

    public void addAdjacent( myNode newNode ){
        if( adjacent_cnt < adjacent.length ){
            this.adjacent[ adjacent_cnt ] = newNode;
            adjacent_cnt++;
        }
        else{
            System.out.print( "adjacent full\n" );
        }

    }
    public myNode[] getAdjacent(){
        return adjacent;
    }
    public String getVertex(){
        return vertex;
    };

    public State get_state(){
        return this.state;
    }

    public void set_state( State st ){
        this.state = st;
    }
}