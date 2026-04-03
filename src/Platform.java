import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Platform extends GameObject {

    public Platform(float x, float y, float width, float height) {
        super(x, y, width, height, "assets/platform.png", Integer.MAX_VALUE);
    }

    @Override
    public void move(double deltaTime) {
        // Platforms don't move, so this method can be empty.
    }
    
    public double getHeight() {
        return height;
    }
    
    public double getWidth() {
        return width;
    }
}