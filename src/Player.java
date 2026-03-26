import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Input;

// public class Player extends GameObject {

//     private int speed = 200;
//     private int jumpSpeed = 4000;
//     float jumpTime = 0.5f;
//     float delayCounter = 0;
//     private int jumpNum = 1;
//     public Player(double x, double y){
//         super(x, y, 20, 40, "assets\\mario.png");
//     }

//     @Override
//     public void move(double deltaTime){
//         if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
//             setX(getX() - (speed * deltaTime));
//         } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
//             setX(getX() + (speed * deltaTime));
//         } 
//     }
//     public void jump(double deltaTime){
//         if(jumpNum < 25){
//             if(Gdx.input.isKeyPressed(Input.Keys.UP)){
//                 setY(getY()+ 5);
//                 jumpNum += 5;
//             }
//         } else if(getY() == 100){
//             jumpNum = 0;
//         } else{
            
//             jumpNum = 0;
//         }
//     }
// }



public class Player extends GameObject {

    private float speed = 200f;
    private float velocityY = 0;
    private final float GRAVITY = -2000f; // Downward force
    private final float JUMP_FORCE = 850f; // Initial upward burst
    private boolean isGrounded = true;

    public Player(double x, double y){
        super(x, y, 70, 700, "assets/mario.png", 3);
    }

    @Override
    public void move(double deltaTime){
        // Horizontal Movement
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            setX(getX() - (speed * deltaTime));
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)){
            setX(getX() + (speed * deltaTime));
        }

        // Apply Gravity
        velocityY += GRAVITY * deltaTime;
        setY(getY() + (velocityY * deltaTime));

        // Basic Floor Collision (Assuming Y=100 is your ground)
        if (getY() <= 100) {
            setY(100);
            velocityY = 0;
            isGrounded = true;
        }

        // Handle Jumping
        if (Gdx.input.isKeyJustPressed(Input.Keys.W) && isGrounded) {
            velocityY = JUMP_FORCE;
            isGrounded = false;
        }
    }

    public Bullet shoot(){
        if(Gdx.input.isKeyJustPressed(Input.Keys.E) && Gdx.input.isKeyPressed(Input.Keys.A)){
            // Create a new bullet at the player's position
            Bullet newBullet = new Bullet(getX(), getY(), true);
            // Add the bullet to the activeObjects list in MyGame
            return newBullet;
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.E)){
            Bullet newBullet = new Bullet(getX(), getY(), false);
            return newBullet;
        }
        else{
            return null;
        }
    }
}
