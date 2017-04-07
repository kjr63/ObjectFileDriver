import java.io.*;

/**
 * Oliotietokannan ajuri
 * @author kaj risberg
 * @version 1.00 2017/7/4
 */
public class ObjectFileDriver {

    private FileOutputStream fos;
    private ObjectOutputStream out;
    private FileInputStream fis;
    private ObjectInputStream in;
    private File f;

    public ObjectFileDriver (File f) {
    	this.f = f;
    }  
    
    public void writeObject (Object o) {
    	try { 
            //Avaa objektitiedosto kirjoitusta varten
            fos = new FileOutputStream(f);
            out = new ObjectOutputStream (fos);
            //Tallenna objektitiedostoon uusi olio
            out.writeObject (o);
            //Sulje objektitiedostot
            out.close();
    	}
    	catch (Exception e) {
            e.printStackTrace();
    	}
    }   

    public Object readObject () {
    	Object o = null;
    	try {
            //Avaa objektitiedosto
            fis = new FileInputStream(f);
            in = new ObjectInputStream (fis);
            //Lue olio
            o = in.readObject();
            in.close();
    	}
    	catch (Exception e) {
            e.printStackTrace();
    	}
    	return o;
    }    
}
