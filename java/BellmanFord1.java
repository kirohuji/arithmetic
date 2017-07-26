package Graph;

public class BellmanFord1 {    
    private static final int m = 10000;    
    public static void main(String[] args) {    
            
        Adge a1 = new Adge(0, 1, -1);    
        Adge a2 = new Adge(0, 2, 4);    
        Adge a3 = new Adge(1, 2, 3);     
        Adge a4 = new Adge(3, 1, 1);    
        Adge a5 = new Adge(1, 3, 2);    
        Adge a6 = new Adge(3, 2, 5);    
        Adge a7 = new Adge(1, 4, 2);    
        Adge a8 = new Adge(4, 3, -3);    
        Adge[] as = new Adge[]{a1, a2, a3, a4, a5, a6, a7, a8};    
            
        int[] d = new int[5];    
        int[] p = new int[5];    
        d[0] = 0;    
        p[0] = 0;    
        for (int i = 1; i < d.length; i++) {    
            d[i] = m;    
            p[i] = -1;    
        }    
        bellman_Ford(as, d, p);    
            
        for (int i = 0; i < d.length; i++) {    
            System.out.println(d[i]);    
        }    
    }    
    private static void bellman_Ford(Adge[] as, int[] d, int[] p){    
        for(int i = 1; i < d.length; i++) {    
            for (int j = 0; j < as.length; j++) {    
                if (d[as[j].getV()] > d[as[j].getU()] + as[j].getW()) {    
                    d[as[j].getV()] = d[as[j].getU()] + as[j].getW();    
                    p[as[j].getV()] = as[j].getU();    
                }    
            }    
        }    
        for (int j = 0; j < as.length; j++) {    
            if (d[as[j].getV()] > d[as[j].getU()] + as[j].getW()) {    
                System.out.println("ÓÐ¸º»·");    
            }    
        }    
    
            
    }    
}    
class Adge {    
    private int u;    
    private int v;    
    private int w;    
        
    public Adge(int u, int v, int w) {    
        this.u = u;    
        this.v = v;    
        this.w = w;    
    }    
    
    public int getU() {    
        return u;    
    }    
    
    public void setU(int u) {    
        this.u = u;    
    }    
    
    public int getV() {    
        return v;    
    }    
    
    public void setV(int v) {    
        this.v = v;    
    }    
    
    public int getW() {    
        return w;    
    }    
    
    public void setW(int w) {    
        this.w = w;    
    }    
        
        
}    