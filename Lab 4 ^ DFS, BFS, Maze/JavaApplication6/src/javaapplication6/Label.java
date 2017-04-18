package javaapplication6;

public class Label {

    protected String label;

    public Label() {
        label = "NotVisited";
    }

    public void Visit() {
        label = "Visited";
    }

    public String ShowLabel() {
        return label;
    }

    public void ClearLabels() {
        label = "NotVisited";
    }
}
