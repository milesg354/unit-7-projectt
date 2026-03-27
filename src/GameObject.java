
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class GameObject {
    // AP Standard: private instance variables
    private double x;
    private double y;
    private int isPlayer;
    private int lives;

    protected float width;
    protected float height;
    private Texture image;
    private Rectangle hitbox;

    // AP Standard: constructors
    public GameObject(double x, double y, float width2, float height2, String imagePath, int lives) {
        this.x = x;
        this.y = y;
        this.width = width2;
        this.height = height2;
        this.image = new Texture(imagePath);
        this.lives = lives;
        // AP Review: Casting double to int for the LibGDX Rectangle class
        this.hitbox = new Rectangle((int) x, (int) y, width2, height2);
    }

    // TODO 1: Write getter methods for x, y, and hitbox.

    public double getX(){
     return x;
    }

    public double getY(){
        return y;
    }

    public double getWidth(){
        return width;
    }
    public double getHeight(){
        return height;
    }
    public Rectangle getHibox(){
        return hitbox;
    }
    public int getPlayerNum(){
        return isPlayer;
    }
    

    // TODO 2: Write setter methods for x and y. 
    // HINT: When you change x or y, you MUST also update the hitbox!
    // Example: hitbox.setPosition((int) newX, (int) newY);
    public void setX(double x){
        this.x = x;
        hitbox.setPosition((int) x, (int) y);
    }


    public boolean isOnRectangle(Rectangle otherHitbox){
        if(hitbox.overlaps(otherHitbox)){
          return true;
        } else{
          return false;
        } 
    }
    
    public void setY(double y){
        this.y = y;
        hitbox.setPosition((int) x, (int) y);
    }

    /**
     * Draws the object to the screen. 
     */
    public void draw(SpriteBatch batch) {
        batch.draw(image, (int) x, (int) y, width, height);
    }

    /**
     * To be overridden by subclasses (Polymorphism).
     * The default GameObject does not move.
     */
    public void move(double deltaTime) {
        // Leave blank for subclasses to override!
    }
    public void jump(double deltaTime){

    }
  //  public Bullet shoot(){
       // return null;
   // }
}

