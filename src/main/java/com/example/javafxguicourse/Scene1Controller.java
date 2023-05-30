package com.example.javafxguicourse;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class Scene1Controller implements Initializable {

    @FXML
    private TreeView<String> treeView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TreeItem<String> rootItem = new TreeItem<>("Files", new ImageView(new Image(getClass().getResourceAsStream("file_icon.png"))));

        // String css = this.getClass().getResource("application.css").toExternalForm();
        // treeView.getStylesheets().add(css);

        TreeItem<String> branchItem1 = new TreeItem<>("Pictures");
        TreeItem<String> branchItem2 = new TreeItem<>("Videos");
        TreeItem<String> branchItem3 = new TreeItem<>("Music");

        TreeItem<String> leafItem1 = new TreeItem<>("Picture1");
        TreeItem<String> leafItem2 = new TreeItem<>("Picture2");
        TreeItem<String> leafItem3 = new TreeItem<>("Video1");
        TreeItem<String> leafItem4 = new TreeItem<>("Video2");
        TreeItem<String> leafItem5 = new TreeItem<>("Music1");
        TreeItem<String> leafItem6 = new TreeItem<>("Music2");

        // adding leaf nodes(children) to branches
        branchItem1.getChildren().addAll(leafItem1, leafItem2);
        branchItem2.getChildren().addAll(leafItem3, leafItem4);
        branchItem3.getChildren().addAll(leafItem5, leafItem6);

        // adding branches/children to rootItem
        rootItem.getChildren().addAll(branchItem1, branchItem2, branchItem3);

        treeView.setShowRoot(false);
        treeView.setRoot(rootItem);
    }

    public void selectItem(){
        TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();

        if(item != null){
            System.out.println(item.getValue());
        }
    }
}
