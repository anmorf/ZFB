package com.zuehlke.zfb.control;

import com.zuehlke.zfb.model.RootModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

/**
 *
 * @author hem
 */
public class SandboxControl implements Initializable {

    private RootModel rootModel = RootModel.getInstance();
    @FXML
    private AnchorPane defaultContent;
    Group g;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        g = new Group();
        defaultContent.getChildren().add(g);
    }

    private Path generatePath() {
        Path path = new Path();
        path.getElements().add(new MoveTo(80, 20));
        path.getElements().add(new LineTo(200, 20));
        path.getElements().add(new CubicCurveTo(380, 0, 380, 120, 200, 120));
        return path;
    }

    private PathTransition generatePathTransition(final Shape shape, final Path path) {
        final PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(8.0));
        pathTransition.setDelay(Duration.seconds(1.0));
        pathTransition.setPath(path);
        pathTransition.setNode(shape);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        return pathTransition;
    }

    public void startAnimation() {
        Circle circle = new Circle(80, 20, 15);
        circle.setFill(Color.DARKRED);
        Path path = generatePath();
        g.getChildren().add(path);
        g.getChildren().add(circle);
        generatePathTransition(circle, path).play();
    }
}
