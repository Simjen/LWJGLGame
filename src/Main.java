/**
 * Created with IntelliJ IDEA.
 * User: B
 * Date: 14-11-13
 * Time: 20:29
 * To change this template use File | Settings | File Templates.
 */
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;


public class Main {

    public Main(){

        try {

         Display.create();

        } catch (LWJGLException e) {

            e.printStackTrace();

        }
    }


    public static void main(String[] args){
        new Main();
    }
}