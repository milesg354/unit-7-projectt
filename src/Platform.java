import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Platform extends GameObject {
    public Platform(double x, double y, int width, int height) {
        super(x, y, width, height, "assets/brick.png");
    }

    @Override
    public void move(double deltaTime) {
        // Platforms don't move, so this method can be empty.
    }
}