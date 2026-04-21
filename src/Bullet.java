import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Input;

public class Bullet extends GameObject {
    private float speed = 500f;
    private float horizVelo = 0;
    private final float GRAVITY = 0f; // Downward force
    private boolean isGrounded = false;
    private boolean left;

    public Bullet(double x, double y, boolean left){
        super(x, y, 40, 40, "assets/bullet.png", Integer.MAX_VALUE);
        this.left = left;
    }

    @Override
    public void move(double deltaTime){
        if(left){
            setX(getX() - 9);
        }
        else{
            setX(getX() + 9);
        }
    }
    public Bullet shoot(){
        return null;
    }
}