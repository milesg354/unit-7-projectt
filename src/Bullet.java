import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Input;

public class Bullet extends GameObject {
    private float speed = 500f;
    private float horizVelo = 0;
    private final float GRAVITY = -2000f; // Downward force
    private boolean isGrounded = false;
    private boolean left;

    public Bullet(double x, double y, boolean direction){
        super(x, y, 10, 10, "assets/bullet.png", Integer.MAX_VALUE);
        left = direction;
    }

    @Override
    public void move(double deltaTime){
        if(left){
            setX(getX() - 2);
        }
        else{
            setX(getX() - 2);
        }
    }
    public void shoot(double deltaTime){
        
    }
}