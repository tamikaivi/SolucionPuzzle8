import java.util.*;

class ConG {

    Queue<String> q = new LinkedList<String>();   
    Map<String,Integer> map = new HashMap<String, Integer>(); 

    public static void main(String args[]){


        String str="123056478";                

        
        ConG e = new ConG();      
        e.add(str,0);                          

        while(e.q.peek()!=null){

            e.up(e.q.peek());                  
            e.down(e.q.peek());                
            e.left(e.q.peek());                 
            e.right(e.q.remove());             
        }
        System.out.println("No existe solucion");
    }

    void add(String str,int n){
        if(!map.containsKey(str)){
            map.put(str,n);
            q.add(str);
        }
    }

   
    void up(String str){
        int a = str.indexOf("0");
        if(a>2){
            String s = str.substring(0,a-3)+"0"+str.substring(a-2,a)+str.charAt(a-3)+str.substring(a+1);
            add(s,map.get(str)+1);
            if(s.equals("123456780")) {
                System.out.println("La solucion esiste en el nivel  "+map.get(s)+" del arbol");
                System.exit(0);
            }
        }
    }
    void down(String str){
        int a = str.indexOf("0");
        if(a<6){
            String s = str.substring(0,a)+str.substring(a+3,a+4)+str.substring(a+1,a+3)+"0"+str.substring(a+4);
            add(s,map.get(str)+1);
            if(s.equals("123456780")) {
                System.out.println("La solucion esiste en el nivel  "+map.get(s)+" del arbol");
                System.exit(0);
            }
        }
    }
    void left(String str){
        int a = str.indexOf("0");
        if(a!=0 && a!=3 && a!=6){
            String s = str.substring(0,a-1)+"0"+str.charAt(a-1)+str.substring(a+1);
            add(s,map.get(str)+1);
            if(s.equals("123456780")) {
                System.out.println("La solucion esiste en el nivel  "+map.get(s)+" del arbol");
                System.exit(0);
            }
        }
    }
    void right(String str){
        int a = str.indexOf("0");
        if(a!=2 && a!=5 && a!=8){
            String s = str.substring(0,a)+str.charAt(a+1)+"0"+str.substring(a+2);
            add(s,map.get(str)+1);
            if(s.equals("123456780")) {
                System.out.println("La solucion esiste en el nivel "+map.get(s)+" del arbol");
                System.exit(0);
            }
        }
    }
}
