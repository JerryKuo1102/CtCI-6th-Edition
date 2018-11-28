public class myGraph{
    int MAX_VERTICES = 11;
    private myNode[] vertices;
    public int vertices_cnt;

    public myGraph(){
        vertices = new myNode[ MAX_VERTICES ];
        vertices_cnt = 0;
    }

    public void add_nodes( myNode newNode ){
        if( vertices_cnt < MAX_VERTICES ){
            vertices[ vertices_cnt ] = newNode;
            vertices_cnt++;
        }
        else{
            System.out.print( "Exceed max vertices\n" );
        }
    }

    public myNode[] get_nodes(){
        return vertices;
    }
}